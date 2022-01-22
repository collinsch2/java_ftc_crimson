package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import static android.os.SystemClock.sleep;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

//This class is used to determine encoder values and is NOT a usuable OpMode
@TeleOp(name="Encoder Values")
public class EncoderValues extends OpMode {

    DcMotor frontRight;
    DcMotorEx intakeArm;

@Override
    public void init() {
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        intakeArm = hardwareMap.get(DcMotorEx.class, "intakeArm");

    }
@Override
    public void loop() {
        telemetry.addData("Intake Motor encoder value", intakeArm.getCurrentPosition());
        telemetry.update();
//830
    //668
    //469
    //1600
    //320
    //166
        if (gamepad1.a) {
            frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            telemetry.addData("Encoder reset", "True");
            sleep(1000);
        }
    }

}
