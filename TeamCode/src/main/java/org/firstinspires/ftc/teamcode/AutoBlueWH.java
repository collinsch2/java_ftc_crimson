package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "BWH")
public class AutoBlueWH extends LinearOpMode {
    Robot robot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        robot.hardwareMap(hardwareMap);

        robot.strafe(-0.5);
        sleep(5000);
        robot.turnLeft(0.4);
        sleep(2000);
        robot.moveCarousel();
        telemetry.addData("run", "completed");
        telemetry.update();

    }

}

