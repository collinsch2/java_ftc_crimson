package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "New Red WAREHOUSE")
public class AutoRedWH2 extends LinearOpMode {
    RobotEncoded robot = new RobotEncoded();
    @Override
    public void runOpMode() throws InterruptedException {
        robot.hardwareMap(hardwareMap);

        waitForStart();
        robot.arm2();
        robot.forward(37);
        robot.turnLeft(16);
        robot.outtake(2000);
        robot.turnLeft(30);
        robot.arm0();
        robot.strafeRight(48);
        robot.forward(50);




    }
}
