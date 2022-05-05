package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotor.RunMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;


@Autonomous(name = "RedCAROUSEL")
public class AutoRedCarousel extends LinearOpMode {
    RobotEncoded robot = new RobotEncoded();
    Pipeline pipeline = new Pipeline(telemetry);

    int turn90 = 17;
    final double degreesPerInch = 5.294;

    @Override
    public void runOpMode() throws NullPointerException {
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
            case NOTHING:
                break;
        }

        robot.turnRight(0);
        robot.forward(0);
        robot.outtake(0);



//        robot.forward(42);
//        robot.turnRight((int)(90/degreesPerInch));
//        robot.forward(3);
//        robot.outtake(2000);
//        robot.backward(27);
//        robot.turnLeft((int)(180/degreesPerInch));
//        robot.strafeLeft(32);
//        robot.turnRight((int)(25/degreesPerInch));
//        robot.carouselRed(3000);
//        robot.turnLeft((int)(25/degreesPerInch));
//        robot.strafeRight(15);


        }

    }


