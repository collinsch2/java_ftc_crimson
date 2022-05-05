package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

@Autonomous(name = "TESTING Red")
public class AutoRedWH3 extends LinearOpMode {
    RobotEncoded robot = new RobotEncoded();
    Pipeline pipeline = new Pipeline(telemetry);

    @Override
    public void runOpMode() throws InterruptedException {
        robot.hardwareMap(hardwareMap);
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        OpenCvCamera webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "webcam"), cameraMonitorViewId);

        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                webcam.startStreaming(1280, 720, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {
                telemetry.addData("Camera failed to", "turn on ");
                telemetry.update();
            }
        });

        waitForStart();

        switch (pipeline.getLocation()){
            case LEFT:
                robot.arm1();
                break;
            case CENTER:
                robot.arm2();
                break;
            case RIGHT:
                robot.arm3();
                break;
            case NOTHING:
                break;
        }

        robot.turnLeft(0);
        robot.forward(0);
        robot.outtake(0);
        robot.backward(0);
        robot.turnRight(0);
        robot.strafeRight(0);
        robot.forward(0);


//        encoders.arm2();
//        encoders.forward(37);
//        encoders.turnLeft(16);
//        encoders.outtake(1000);
//        encoders.turnLeft(30);
//        encoders.arm0();
//        encoders.strafeRight(52);
//        encoders.forward(52);
//
//        encoders.intake(1500);
//        encoders.backward(5);
//        encoders.strafeRight(8);
//        encoders.arm2();
//        encoders.backward(69);
//        encoders.turnRight(16);
//        encoders.forward(13);
//        encoders.outtake (2000);
//
//        encoders.turnRight(14);
//        encoders.strafeRight(28);
//        encoders.forward(70);
//        encoders.strafeLeft(12);


    }
}
