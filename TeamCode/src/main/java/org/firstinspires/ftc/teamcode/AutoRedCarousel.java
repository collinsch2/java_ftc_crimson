package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;


@Autonomous(name = "TestRC")
public class AutoRedCarousel extends LinearOpMode {
    Robot robot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {

    }
    //final TFObjectDetector myTfod;
    //final
   /* private void initVuforia(){
        final String VUFORIA_KEY = "AcTcWzH/////AAABmRZzoPbpRUDTrZOQJsPdfgAmVO9oOthVYlDFc04vu8+t+m18E8Ee3vLgLIT8y5RhoWGwG3tA2BtaA/3ANMMchxJG5ppxfrv6k5b2jSiBxu5SSNhdm3hZfwv5LQMs3K8UHnIeZnD6dLF3gkpPwv/p94X60PfZsteVR6LcCn8sXsTqBDwoWRBesa1vzTAChqv+qpVUeTHSmImjwfqwFJByr5eKujlEYIpYlYOfDGIDS1DTt44O7/lMY+9LTq7Hj8szzAnU2u9nXcXjgyUEgjdbqvmA1sU6vDlmMzvV+5r2qOiKciPmym/AE0eSR256bHpx7dkeNc1mKizaXeGCYvuwy9giiffsaNzGSXTwvjuP1Eyy";
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;

        VuforiaLocalizer myVuforia = ClassFactory.getInstance().createVuforia(parameters);
    }
    private void initTfod(){

        final String TFOD_MODEL_ASSET = "model_unquant.tflite";
        final String[] LABELS = {
                "cube",
                "ball",
        };

        int tfodMonitorViewId =
                hardwareMap.appContext.getResources().getIdentifier("tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());

        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);

        tfodParameters.minResultConfidence = 0.8f;
        tfodParameters.isModelTensorFlow2 = true;
        tfodParameters.inputSize = 320;

        TFObjectDetector myTfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, Vuforia);

        myTfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABELS);

    }

    @Override
    public void runOpMode() throws InterruptedException {
        initVuforia();
        initTfod();
        waitForStart();
        robot.hardwareMap(hardwareMap);


        }


    }
 */
}