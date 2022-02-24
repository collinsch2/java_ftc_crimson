package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import com.qualcomm.robotcore.hardware.HardwareMap;


import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.internal.vuforia.VuforiaLocalizerImpl;

import java.util.List;

public class CrimTensorFlow  {
    final String VUFORIA_KEY = "AcTcWzH/////AAABmRZzoPbpRUDTrZOQJsPdfgAmVO9oOthVYlDFc04vu8+t+m18E8Ee3vLgLIT8y5RhoWGwG3tA2BtaA/3ANMMchxJG5ppxfrv6k5b2jSiBxu5SSNhdm3hZfwv5LQMs3K8UHnIeZnD6dLF3gkpPwv/p94X60PfZsteVR6LcCn8sXsTqBDwoWRBesa1vzTAChqv+qpVUeTHSmImjwfqwFJByr5eKujlEYIpYlYOfDGIDS1DTt44O7/lMY+9LTq7Hj8szzAnU2u9nXcXjgyUEgjdbqvmA1sU6vDlmMzvV+5r2qOiKciPmym/AE0eSR256bHpx7dkeNc1mKizaXeGCYvuwy9giiffsaNzGSXTwvjuP1Eyy";
    Recognition recognition;
    VuforiaLocalizer vuforia;
    TFObjectDetector Tfod;

    final String TFOD_MODEL_ASSET = "Tensorflow.tflite";
    final String[] LABELS = {
            "Cube",
            "Ball",
            "ShippingElement",
            "ShippingHub"
    };

    int Level = 0;
    double cameraHeight = 0; //in MM
    int intakeDistance = 0; //in MM

    public void initWebcam(HardwareMap hardwareMap){
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();
        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        VuforiaLocalizer vuforia = ClassFactory.getInstance().createVuforia(parameters);
        WebcamName webcamName = hardwareMap.get(WebcamName.class,"webcam");
        parameters.cameraName = webcamName;

        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        TFObjectDetector Tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);

        tfodParameters.minResultConfidence = 0.8f;
        tfodParameters.isModelTensorFlow2 = true;
        tfodParameters.inputSize = 320;
        vuforia.setFrameQueueCapacity(3);

        Tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABELS);
        Tfod.activate();
        Tfod.setZoom(2.5, 16.0/9.0);
    }

    /*private void initVuforia() {

        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();
        WebcamName webcam = hardwareMap.get(WebcamName.class,"webcam");
        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        //VuforiaLocalizer Vuforia = ClassFactory.createVuforiaLocalizer(parameters);
        //Vuforia.setFrameQueueCapacity(3);

        //Vuforia.setFrameFormat(PIXEL_FORMAT.RGB565, true);
        Vuforia = ClassFactory.getInstance().createVuforia(parameters);
    }

    private void initTfod() {

        final String TFOD_MODEL_ASSET = "model_unquant.tflite";
        final String[] LABELS = {
                "Cube",
                "Ball",
                "barcodeRed1",
                "barcodeRed2",
                "barcodeRed3",
                "barcodeBlue1",
                "barcodeBlue2",
                "barcodeBlue3",
        };

        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());

        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);

        tfodParameters.minResultConfidence = 0.8f;
        tfodParameters.isModelTensorFlow2 = true;
        tfodParameters.inputSize = 320;

        TFObjectDetector Tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, Vuforia);

        Tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABELS);
        Tfod.activate();
        Tfod.setZoom(2.5, 16.0 / 9.0);
        //camera resolution is 1280x720
    }

     */

   /* private int getBarcode() {
        tfod.getUpdatedRecognitions();
        if (recognition.equals("barcodeRed1")) {
            Level = 1;
        }
        if (recognition.equals("barcodeRed2")) {
            Level = 2;
        }
        if (recognition.equals("barcodeRed3")) {
            Level = 3;
        }
        if (recognition.equals("barcodeBlue1")) {
            Level = 1;
        }
        if (recognition.equals("barcodeBlue2")) {
            Level = 2;
        }
        if (recognition.equals("barcodeBlue3")) {
            Level = 3;
        } else {
            telemetry.addData("No object", "Is found");
            telemetry.update();
        }
        telemetry.addData("Image found is", recognition);
        telemetry.addData("Freight level is", Level);
        telemetry.update();
        return Level;
    }

    ;

    */

    private double getDistanceCube() {
        //distance = focal length*real height of obj*image height in pixels/
        //object height in pixels*sensor height, all heights are in MM
        double DISTANCE_MM = 0.01 * 50.8 * recognition.getImageHeight() / recognition.getHeight() * cameraHeight;
        return DISTANCE_MM;
    }

    public int getOffset() {
        int SCREEN_WIDTH = recognition.getImageWidth();
        int objectLeftCords = (int) recognition.getLeft();
        int objectRightCords = (int) recognition.getRight();
        int objectCenterCords = (objectLeftCords + objectRightCords) / 2;
        int offset = objectCenterCords - SCREEN_WIDTH / 2;
        return offset;
    }
}



 /*

  int SCREEN_WIDTH = recognition.getImageWidth();
                        int goldMineralLeftX = (int) recognition.getLeft();
                        int goldMineralRightX = (int) recognition.getRight();
                        int goldMineralCenterX = (goldMineralLeftX + goldMineralRightX) / 2;
                        int offset = goldMineralCenterX - SCREEN_WIDTH / 2;
 */

