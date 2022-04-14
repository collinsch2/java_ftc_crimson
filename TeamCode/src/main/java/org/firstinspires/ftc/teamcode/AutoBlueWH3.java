package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "TESTING Blue")
public class AutoBlueWH3 extends LinearOpMode {
    Robot robot = new Robot();
    RobotEncoded encoders = new RobotEncoded();

    @Override
    public void runOpMode() throws InterruptedException {
        encoders.hardwareMap(hardwareMap);
        waitForStart();
        encoders.forward(10);
        /*encoders.arm2();
        encoders.forward(37);
        encoders.turnRight(16);
        encoders.outtake(2000);
        encoders.turnRight(31);
        encoders.arm0();
        encoders.strafeLeft(44);
        encoders.forward(50);

        encoders.intake(1500);
        encoders.arm2();
        encoders.backward(74);
        encoders.turnRight(16);
        encoders.forward(13);
        encoders.outtake (2000);

        encoders.turnLeft(14);
        encoders.strafeLeft(28);
        encoders.forward(70);
        encoders.strafeRight(12);

         */

    }


}
