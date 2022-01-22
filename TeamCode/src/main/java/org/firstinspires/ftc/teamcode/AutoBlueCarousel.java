package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "TestBC")
public class AutoBlueCarousel extends LinearOpMode {
    Robot robot = new Robot();
    RobotEncoded encoders = new RobotEncoded();

    @Override
    public  void runOpMode() throws InterruptedException {
        waitForStart();
        robot.hardwareMap(hardwareMap);




        telemetry.addData("Back Right is", encoders.backRight.getDirection());
        telemetry.addData("Back Left is", encoders.backLeft.getDirection());
        telemetry.addData("Front Right is", encoders.frontRight.getDirection());
    }
}
