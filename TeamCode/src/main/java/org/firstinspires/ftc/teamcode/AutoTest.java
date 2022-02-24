package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

@Autonomous(name = "AutoTest")
public class AutoTest extends LinearOpMode {
    RobotEncoded2 encoders = new RobotEncoded2();
    CrimTensorFlow webcam = new CrimTensorFlow();

    final String VUFORIA_KEY = "AcTcWzH/////AAABmRZzoPbpRUDTrZOQJsPdfgAmVO9oOthVYlDFc04vu8+t+m18E8Ee3vLgLIT8y5RhoWGwG3tA2BtaA/3ANMMchxJG5ppxfrv6k5b2jSiBxu5SSNhdm3hZfwv5LQMs3K8UHnIeZnD6dLF3gkpPwv/p94X60PfZsteVR6LcCn8sXsTqBDwoWRBesa1vzTAChqv+qpVUeTHSmImjwfqwFJByr5eKujlEYIpYlYOfDGIDS1DTt44O7/lMY+9LTq7Hj8szzAnU2u9nXcXjgyUEgjdbqvmA1sU6vDlmMzvV+5r2qOiKciPmym/AE0eSR256bHpx7dkeNc1mKizaXeGCYvuwy9giiffsaNzGSXTwvjuP1Eyy";
    final String TFOD_MODEL_ASSET = "Tensorflow.tflite";
    final String[] LABELS = {
            "Cube",
            "Ball",
            "ShippingElement",
            "ShippingHub"
    };


    @Override
    public void runOpMode() throws InterruptedException {
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

        Tfod.loadModelFromAsset("Tensorflow.tflite",
                "Cube",
                "Ball",
                "ShippingElement",
                "ShippingHub");

        Tfod.activate();

    waitForStart();

        while (opModeIsActive()) {
            // getUpdatedRecognitions() will return null if no new information is available since
            // the last time that call was made.
            List<Recognition> updatedRecognitions = Tfod.getUpdatedRecognitions();
            if (updatedRecognitions != null) {
                telemetry.addData("# Object Detected", updatedRecognitions.size());

                // step through the list of recognitions and display boundary info.
                int i = 0;
                for (Recognition recognition : updatedRecognitions) {
                    telemetry.addData(String.format("label (%d)", i), recognition.getLabel());
                    telemetry.addData(String.format("  left,top (%d)", i), "%.03f , %.03f",
                            recognition.getLeft(), recognition.getTop());
                    telemetry.addData(String.format("  right,bottom (%d)", i), "%.03f , %.03f",
                            recognition.getRight(), recognition.getBottom());
                    i++;

                    if (recognition.getLabel().equals("Cube")) {
                        telemetry.addData("Object detected is ", "Cube");
                        telemetry.addData("Confidence: ", recognition.getConfidence());
                        telemetry.addData("Height of Cube: ", recognition.getHeight());
                        telemetry.addData("Height of Camera view: ", recognition.getImageHeight());
                        telemetry.update();
                    }
                }
            }
        }
    }
}


                        /*while (getOffset() < 0) { //turn left
                            encoders.turnLeft(200);
                            getOffset();
                        }

                        while (getOffset() > 0) { //turn right
                            encoders.turnRight(200);
                            getOffset();
                        }

                        while (getOffset() == 0) { //forward if centered
                            getDistanceCube();
                            encoders.forward(200);
                            if (getDistanceCube() == intakeDistance) {
                                break;
                            }
                        }
                    }

                    if (Level == 1) {
            encoders.intakeArm.setTargetPosition(-168);
            encoders.intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            encoders.intakeArm.setVelocity(1000);
            while (encoders.intakeArm.isBusy()) {
                telemetry.addData("Arm ", "is busy");
            }
            encoders.intakeArm.setVelocity(0);
        } else if (Level == 2) {
            encoders.intakeArm.setTargetPosition(-342);
            encoders.intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            encoders.intakeArm.setVelocity(1000);
            while (encoders.intakeArm.isBusy()) {
                telemetry.addData("Arm ", "is busy");
            }
            encoders.intakeArm.setVelocity(0);
        } else if (Level == 3) {
            encoders.intakeArm.setTargetPosition(-590);
            encoders.intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            encoders.intakeArm.setVelocity(1000);
            while (encoders.intakeArm.isBusy()) {
                telemetry.addData("Arm ", "is busy");
            }
            encoders.intakeArm.setVelocity(0);
        } else {
            telemetry.addData("No level", "is found");
        }


                         */