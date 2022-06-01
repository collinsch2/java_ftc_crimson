package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

@Autonomous(name = "BlueWH JAWN")
public class AutoBlueWH3 extends LinearOpMode {
    RobotEncoded robot = new RobotEncoded();
    Pipeline2 pipeline = new Pipeline2(telemetry);

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
        webcam.setPipeline(pipeline);
        waitForStart();
        robot.cappingArmRest();

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
        }
        robot.cappingArmStart();
        robot.strafeRight(25);
        robot.forward(21);
        robot.outtake(2000);
        robot.turnLeft(87);
        robot.arm0();
        robot.strafeLeft(28);
        robot.forward(62);
        robot.stop();

//        encoders.strafeRight(31);
//        encoders.forward(20);
//        encoders.outtake(2000);
//        encoders.turnLeft(17);
//        encoders.arm0();
//        encoders.strafeLeft(25);
//        encoders.forward(54);
//
//        encoders.stop();

         /*encoders.arm2();
        encoders.forward(37);
        encoders.turnRight(16);
        encoders.outtake(2000);
        encoders.turnRight(31);
        encoders.arm0();
        encoders.strafeLeft(44);
        encoders.forward(50);

        encoders.intake(1500);
        encoders.arm2();
        encoders.backward(74);
        encoders.turnRight(16);
        encoders.forward(13);
        encoders.outtake (2000);

        encoders.turnLeft(14);
        encoders.strafeLeft(28);
        encoders.forward(70);
        encoders.strafeRight(12);

         */

    }


}
