package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import static android.os.SystemClock.sleep;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

//This class is used to determine encoder values and is NOT a usuable OpMode
@TeleOp(name="Encoder Values")
public class EncoderValues extends OpMode {


    DcMotorEx frontRight;
    DcMotorEx frontLeft;
    DcMotorEx intakeArm;
    //Servo intakeServo;
    int intakeServoPosition = 0;

@Override
    public void init() {
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        intakeArm = hardwareMap.get(DcMotorEx.class, "intakeArm");
        intakeArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //intakeServo = hardwareMap.get(Servo.class, "intakeServo");
    }
@Override
    public void loop() {

        if (gamepad1.a) {
            intakeArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }

    if (gamepad1.dpad_up) {
        intakeArm.setTargetPosition(intakeArm.getCurrentPosition() + 5);
        intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        intakeArm.setVelocity(1000);
    }

  //444 245 94 -81
    if(gamepad1.dpad_down){
        intakeArm.setTargetPosition(intakeArm.getCurrentPosition() - 5);
        intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        intakeArm.setVelocity(1000);
    }

        telemetry.addData("Arm encoder value: ", intakeArm.getCurrentPosition());
        telemetry.addData("Intake Servo Position: ", intakeServoPosition);
        telemetry.addData("intake arm values (proper naming): ", intakeArm.getVelocity());
    telemetry.update();
    }

}
