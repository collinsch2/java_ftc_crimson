package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "RedWH")
public class AutoRedWH extends LinearOpMode {
    Robot robot = new Robot();
 //   RobotEncoded encodedMotors = new RobotEncoded();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.hardwareMap(hardwareMap);
        waitForStart();
        robot.turnLeft(0.5);
        sleep(500);
        robot.strafeLeft(0.5);
        sleep(500);
        robot.strafeRight(0.5);
        sleep(1000);
        robot.turnLeft(0.5);
        sleep(500);
        robot.strafeRight(0.5);
        sleep(5000);
        robot.forward(0.25);
        sleep(500);
        robot.carouselMotor.setPower(0.7);
        sleep(4000);
        robot.backward(0.5);
        sleep(500);
        robot.strafeLeft(0.5);
        sleep(1000);
        robot.turnLeft(0.5);
        sleep(700);
        robot.strafeRight(0.5);
        sleep(500);
        robot.forward(0.5);
        sleep(4000);
        robot.stop();
        /*waitForStart();
        encodedMotors.hardwareMap(hardwareMap);

        //move to carousel
        encodedMotors.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encodedMotors.frontRight.setTargetPosition(-2500); //?
        encodedMotors.frontRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        encodedMotors.strafeRight(-300);
        while (encodedMotors.frontRight.isBusy()) {
            telemetry.addData("Robot is strafing", "True");
            telemetry.update();
        }
        encodedMotors.stop();

        //turn to position servo at carousel
        encodedMotors.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encodedMotors.frontRight.setTargetPosition(1140); //?
        encodedMotors.frontRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        encodedMotors.turnLeft(-300);
        while (encodedMotors.frontRight.isBusy()) {
            telemetry.addData("Robot is turning left", "True");
            telemetry.update();
        }
        encodedMotors.stop();

        //move carousel servo
        encodedMotors.moveCarousel(0.5);
        sleep(5000); //?

        //move to warehouse and park
        encodedMotors.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encodedMotors.frontRight.setTargetPosition(2650);
        encodedMotors.frontRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        encodedMotors.forward(100);
        while (encodedMotors.frontRight.isBusy()) {
            telemetry.addData("Robot is moving forward", "True");
            telemetry.update();
        }
        encodedMotors.stop();

        encodedMotors.frontRight.setTargetPosition(-780);
        encodedMotors.frontRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        encodedMotors.strafeRight(-100);
        while (encodedMotors.frontRight.isBusy()) {
            telemetry.addData("Robot is strafing", "True");
            telemetry.update();
        }
        encodedMotors.stop();

        encodedMotors.frontRight.setTargetPosition(400);
        encodedMotors.frontRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        encodedMotors.forward(100);
        while (encodedMotors.frontRight.isBusy()) {
            telemetry.addData("Robot is moving forward", "True");
            telemetry.update();
        }
        encodedMotors.stop();


        //autonomous complete
        telemetry.addData("Run", "Completed");
        telemetry.update();
*/
    }

}

