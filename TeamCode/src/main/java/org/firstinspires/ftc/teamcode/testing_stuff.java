package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "123")
public class testing_stuff extends LinearOpMode {
RobotEncoded2 encoders = new RobotEncoded2();
    @Override
    public void runOpMode() throws InterruptedException {
        encoders.hardwareMap(hardwareMap);
        waitForStart();
        encoders.strafeRight(30);
        while (opModeIsActive()) {
            telemetry.addData("Front right", encoders.frontRight.getCurrentPosition());
            telemetry.addData("Front left", encoders.frontLeft.getCurrentPosition());
            telemetry.addData("back left", encoders.backLeft.getCurrentPosition());
            telemetry.addData("back right", encoders.backRight.getCurrentPosition());

            telemetry.addData("Front right velocity", encoders.frontRight.getVelocity());
            telemetry.addData("Front left velocity", encoders.frontLeft.getVelocity());
            telemetry.addData("back left velocity", encoders.backLeft.getVelocity());
            telemetry.addData("back right velocity", encoders.backRight.getVelocity());
            telemetry.update();
        }
    }
}



