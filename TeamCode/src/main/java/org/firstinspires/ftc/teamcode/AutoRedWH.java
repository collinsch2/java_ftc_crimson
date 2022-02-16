package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "Old Red WAREHOUSE")
public class AutoRedWH extends LinearOpMode {
    Robot robot = new Robot();
    RobotEncoded2 encoders = new RobotEncoded2();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.hardwareMap(hardwareMap);
        waitForStart();

        robot.turnRight(0.5);
        sleep(600);
        robot.strafeRight(0.5);
        sleep(800);
        robot.forward(0.5);
        sleep(2000);
        robot.stop();

    }
}

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

         */



