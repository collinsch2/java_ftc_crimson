package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "BlueWH")
public class AutoBlueWH extends LinearOpMode {
    Robot robot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.hardwareMap(hardwareMap);

        waitForStart();

        robot.hardwareMap(hardwareMap);

        //move to carousel
        robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.strafeRight(0.5);
        while (robot.frontRight.getCurrentPosition() <2500) {
            telemetry.addData("Robot is strafing", "True");
            telemetry.update();
        }
        robot.stop();

        //turn to position servo at carousel
        robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.turnRight(0.5);
        while (robot.frontRight.getCurrentPosition() > -1140) {
            telemetry.addData("Robot is moving", "True");
            telemetry.update();
        }
        robot.stop();

        //move carousel servo
        robot.moveCarousel(0.75);
        sleep(5000);
        robot.moveCarousel(0);

        //move to warehouse and park
        robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.forward(0.5);
        while (robot.frontRight.getCurrentPosition() < -2650) {
            telemetry.addData("Robot is moving", "True");
            telemetry.update();
        }
        robot.stop();

        robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.strafeRight(0.5);
        while (robot.frontRight.getCurrentPosition() < 780) {
            telemetry.addData("Robot is moving", "True");
            telemetry.update();
        }
        robot.stop();

        robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.forward(0.5);
        while (robot.frontRight.getCurrentPosition() < 400) {
            telemetry.addData("Robot is moving", "True");
            telemetry.update();
        }
        robot.stop();

        //autonomous complete
        telemetry.addData("run", "completed");
        telemetry.update();
    }
}

