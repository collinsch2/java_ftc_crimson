package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "New Blue WAREHOUSE")
public class AutoBlueWH2 extends LinearOpMode {
    Robot robot = new Robot();
    RobotEncoded encoders = new RobotEncoded();

    @Override
    public void runOpMode() throws InterruptedException {
        encoders.hardwareMap(hardwareMap);
        waitForStart();

        encoders.arm2();
        encoders.forward(37);
        encoders.turnRight(16);
        encoders.outtake(2000);
        encoders.turnRight(31);
        encoders.arm0();
        encoders.strafeLeft(44);
        encoders.forward(50);


    }


    }
