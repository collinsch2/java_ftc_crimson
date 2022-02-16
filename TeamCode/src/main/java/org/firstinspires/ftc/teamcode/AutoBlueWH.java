package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "Old Blue WAREHOUSE")
public class AutoBlueWH extends LinearOpMode {
    Robot robot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.hardwareMap(hardwareMap);

        waitForStart();
        robot.turnLeft(0.5);
        sleep(600);
        robot.strafeLeft(0.5);
        sleep(800);
        robot.forward(0.5);
        sleep(2000);
        robot.stop();


    }
}
