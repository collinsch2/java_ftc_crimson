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
        encoders.hardwareMap(hardwareMap);
        waitForStart();

        encoders.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encoders.frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encoders.backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encoders.backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        encoders.frontRight.setTargetPosition(10000);
        encoders.frontLeft.setTargetPosition(10000);
        encoders.backLeft.setTargetPosition(10000);
        encoders.backRight.setTargetPosition(10000);

        encoders.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        encoders.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        encoders.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        encoders.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        encoders.frontRight.setPower(0.5);
        encoders.frontLeft.setPower(0.5);
        encoders.backLeft.setPower(0.5);
        encoders.backRight.setPower(0.5);

        telemetry.addData("Path", "Completed");
        }

    }


