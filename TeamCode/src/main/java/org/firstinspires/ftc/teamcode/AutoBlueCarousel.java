package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "BlueCAROUSEL")
public class AutoBlueCarousel extends LinearOpMode {
    RobotEncoded encoders = new RobotEncoded();

    @Override
    public void runOpMode() throws InterruptedException {
        encoders.hardwareMap(hardwareMap);
        waitForStart();
        encoders.arm3();
        encoders.strafeLeft(8);
        encoders.forward(11);
        encoders.outtake(1000);
        encoders.backward(11);

        /*encoders.forward();
        encoders.strafeRight();

         */



        }
    }



