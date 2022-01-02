package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

//This class is used to determine encoder values and is NOT a usuable OpMode
@TeleOp(name="Encoder Values")
public class EncoderValues {

    DcMotor frontRight;
    DcMotorEx armMotor;

    public void init() {
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        armMotor = hardwareMap.get(DcMotorEx.class, "armMotor");
    }

    public void loop() {
        telemetry.addData("Encoder value", frontRight.getCurrentPosition());
        //telemetry.addData("Arm Motor value", armMotor.getCurrentPosition());
        telemetry.update();

        if (gamepad1.a) {
            frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }
    }

}
