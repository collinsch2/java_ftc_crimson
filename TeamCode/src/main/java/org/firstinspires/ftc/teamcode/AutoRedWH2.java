package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "New Red WAREHOUSE")
public class AutoRedWH2 extends LinearOpMode {
    RobotEncoded2 encoders = new RobotEncoded2();
    @Override
    public void runOpMode() throws InterruptedException {
        encoders.hardwareMap(hardwareMap);

        waitForStart();
        encoders.arm2();
        encoders.forward(37);
        encoders.turnLeft(16);
        encoders.outtake(2000);
        encoders.turnLeft(30);
        encoders.arm0();
        encoders.strafeRight(48);
        encoders.forward(50);




    }
}
