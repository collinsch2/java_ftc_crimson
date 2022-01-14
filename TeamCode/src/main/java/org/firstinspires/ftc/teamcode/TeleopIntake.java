package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import static android.os.SystemClock.sleep;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

@TeleOp(name="TeleopIntake")
public class TeleopIntake extends OpMode {

    DcMotorEx intakeMotor;
    DcMotorEx intakeArm;

    @Override
    public void init() {
        intakeMotor = hardwareMap.get(DcMotorEx.class, "intakeMotor");
        intakeArm = hardwareMap.get(DcMotorEx.class, "intakeArm");
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            intakeMotor.setPower(0.5);
            telemetry.addData("Moving arm", "forwards");
        }
        if (gamepad1.b) {
            intakeMotor.setPower(-0.5);
            telemetry.addData("Moving arm", "reversed");
        }


    }

}
