package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "BWH")
public class AutoBlueWH extends LinearOpMode {
    Robot robot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        robot.hardwareMap(hardwareMap);

        //move to carousel
        robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontRight.setTargetPosition(500);
        robot.strafe(0.5);
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Robot is moving", "True");
            telemetry.update();
        }

        //turn to position servo at carousel
        robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontRight.setTargetPosition(200);
        robot.turnRight(0.5);


        sleep(2000);
        robot.moveCarousel();
        telemetry.addData("run", "completed");
        telemetry.update();

    }

}

