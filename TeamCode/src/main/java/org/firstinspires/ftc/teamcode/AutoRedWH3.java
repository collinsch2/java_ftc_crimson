package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "TESTING Red")
public class AutoRedWH3 extends LinearOpMode {
    RobotEncoded2 encoders = new RobotEncoded2();
    @Override
    public void runOpMode() throws InterruptedException {
        encoders.hardwareMap(hardwareMap);

        waitForStart();
        encoders.arm2();
        encoders.forward(37);
        encoders.turnLeft(16);
        encoders.outtake(1000);
        encoders.turnLeft(30);
        encoders.arm0();
        encoders.strafeRight(52);
        encoders.forward(52);

        encoders.intake(1500);
        encoders.backward(5);
        encoders.strafeRight(8);
        encoders.arm2();
        encoders.backward(69);
        encoders.turnRight(16);
        encoders.forward(13);
        encoders.outtake (2000);

        encoders.turnRight(14);
        encoders.strafeRight(28);
        encoders.forward(70);
        encoders.strafeLeft(12);


    }
}
