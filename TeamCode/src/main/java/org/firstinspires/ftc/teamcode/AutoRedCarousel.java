package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotor.RunMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;



@Autonomous(name = "TestRC")
public class AutoRedCarousel extends LinearOpMode {
    Robot robot = new Robot();
    RobotEncoded encoders = new RobotEncoded();

    @Override
    public void runOpMode() throws NullPointerException {
        waitForStart();
        robot.hardwareMap(hardwareMap);

        encoders.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encoders.frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encoders.backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encoders.backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        encoders.frontRight.setTargetPosition(1000);
        encoders.frontLeft.setTargetPosition(1000);
        encoders.backLeft.setTargetPosition(1000);
        encoders.backRight.setTargetPosition(1000);

        encoders.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        encoders.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        encoders.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        encoders.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        encoders.forward(100);

        telemetry.addData("Front Left is",  encoders.frontLeft.getDirection());
        telemetry.addData("Back Right is", encoders.backRight.getDirection());
        telemetry.addData("Back Left is", encoders.backLeft.getDirection());
        telemetry.addData("Front Right is", encoders.frontRight.getDirection());
        }

    }


