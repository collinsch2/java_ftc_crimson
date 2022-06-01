package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

@Autonomous(name = "BlueCAROUSEL JAWN")
public class AutoBlueCarousel extends LinearOpMode {
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
        robot.turnLeft(35);
        robot.forward(26);
        robot.outtake(2500);
        robot.backward(26);
        robot.arm0();
        robot.turnRight(95);
        robot.forward(21);
        robot.turnRight(180);
        robot.strafeLeft(16);
        robot.carouselBlue(3000);
        robot.strafeRight(24);
        robot.turnLeft(220);
        //fix after this line
        robot.forward(13);



//        robot.forward(42);
//        robot.turnLeft(17);
//        robot.forward(0);
//        robot.outtake(2000);
//        robot.backward(0);
//        robot.turnLeft(3);
//        robot.strafeLeft(32);
//        robot.carouselBlue(3000);
//        robot.strafeRight(15);
//        robot.stop();


        }
    }



