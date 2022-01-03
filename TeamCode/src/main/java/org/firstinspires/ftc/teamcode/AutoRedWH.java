package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "BWH")
public class AutoRedWH extends LinearOpMode {
    Robot robot = new Robot();
    RobotEncoded encodedMotors = new RobotEncoded();

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        encodedMotors.hardwareMap(hardwareMap);

        //move to carousel
        encodedMotors.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encodedMotors.frontRight.setTargetPosition(500); //?
        encodedMotors.strafe(-100);
        while (encodedMotors.frontRight.isBusy()) {
            telemetry.addData("Robot is moving", "True");
            telemetry.update();
        }

        //turn to position servo at carousel
        encodedMotors.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encodedMotors.frontRight.setTargetPosition(-200); //?
        encodedMotors.turnLeft(100);
        while (encodedMotors.frontRight.isBusy()) {
            telemetry.addData("Robot is moving", "True");
            telemetry.update();
        }

        //move carousel servo
        encodedMotors.moveCarousel(0.5);
        sleep(2000); //?

        //move to warehouse and park
        encodedMotors.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encodedMotors.frontRight.setTargetPosition(500);
        encodedMotors.forward(100);
        while (encodedMotors.frontRight.isBusy()) {
            telemetry.addData("Robot is moving", "True");
            telemetry.update();
        }
        encodedMotors.frontRight.setTargetPosition(200);
        encodedMotors.strafe(-100);
        while (encodedMotors.frontRight.isBusy()) {
            telemetry.addData("Robot is moving", "True");
            telemetry.update();
        }
        encodedMotors.frontRight.setTargetPosition(300);
        encodedMotors.forward(100);
        while (encodedMotors.frontRight.isBusy()) {
            telemetry.addData("Robot is moving", "True");
            telemetry.update();
        }

        //autonomous complete
        telemetry.addData("run", "completed");
        telemetry.update();

    }

}
