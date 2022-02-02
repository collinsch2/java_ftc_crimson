package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotor.RunMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;



@Autonomous(name = "RedCAROUSEL")
public class AutoRedCarousel extends LinearOpMode {
    Robot robot = new Robot();


    @Override
    public void runOpMode() throws NullPointerException {
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
        sleep(2000);
        robot.forward(0.3);
        sleep(3000);
        robot.stop();
        sleep(1000);
        robot.moveCarousel(0.7);
        telemetry.addData("Carousel power is", robot.carouselMotor.getPower());
        telemetry.update();
        sleep(4000);
        robot.backward(0.5);
        sleep(500);
        robot.stop();

        telemetry.addData("Path", "Completed");
        telemetry.update();
        }

    }


