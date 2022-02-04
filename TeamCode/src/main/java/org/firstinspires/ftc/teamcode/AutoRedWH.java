package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "RedWAREHOUSE")
public class AutoRedWH extends LinearOpMode {
    Robot robot = new Robot();
    RobotEncoded2 encoders = new RobotEncoded2();

    /*public void telemetry(){
        while (encoders.frontLeft.isBusy() && encoders.frontRight.isBusy() && encoders.backLeft.isBusy() && encoders.backRight.isBusy()) {
            telemetry.addData("Front right", encoders.frontRight.getCurrentPosition());
            telemetry.addData("Front left", encoders.frontLeft.getCurrentPosition());
            telemetry.addData("back left", encoders.backLeft.getCurrentPosition());
            telemetry.addData("back right", encoders.backRight.getCurrentPosition());

            telemetry.addData("Front right velocity", encoders.frontRight.getVelocity());
            telemetry.addData("Front left velocity", encoders.frontLeft.getVelocity());
            telemetry.addData("back left velocity", encoders.backLeft.getVelocity());
            telemetry.addData("back right velocity", encoders.backRight.getVelocity());
            telemetry.update();
        }
    }

     */

    @Override
    public void runOpMode() throws InterruptedException {
        encoders.hardwareMap(hardwareMap);
        waitForStart();
        encoders.backward(35);
        encoders.turnLeft(15);
        encoders.arm2();
        encoders.outtake(1000);
       /* encoders.diagonalUpRight(10);
        encoders.diagonaldownLeft(10);
        encoders.diagonalUpLeft(10);
        encoders.diagonaldownRight(10);
        encoders.carouselBlue(5000);
        encoders.carouselRed(5000);
    }
        /*robot.turnRight(0.5);
        sleep(600);
        robot.strafeRight(0.5);
        sleep(800);
        robot.forward(0.5);
        sleep(2000);
        robot.stop();

         */

        /*robot.turnLeft(0.5);
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