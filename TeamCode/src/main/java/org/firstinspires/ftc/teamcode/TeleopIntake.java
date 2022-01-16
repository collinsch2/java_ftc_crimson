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
        //intakeMotor = hardwareMap.get(DcMotorEx.class, "intakeMotor");
        intakeArm = hardwareMap.get(DcMotorEx.class, "intakeArm");
        intakeArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    @Override
    public void loop() {
        /*if (gamepad1.dpad_up) {
            intakeMotor.setPower(0.5);
            telemetry.addData("Moving arm", "forwards");
        }
        if (gamepad1.b) {
            intakeMotor.setPower(-0.5);
            telemetry.addData("Moving arm", "reversed");
        }*/

        double armVelocity = 500;
        if (gamepad1.dpad_down) {
            intakeArm.setTargetPosition(70);
            intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(armVelocity);
            while(intakeArm.isBusy()) {
                telemetry.addData("Status", "Waiting for motor");
                telemetry.addData("Motor at", intakeArm.getCurrentPosition());
                telemetry.update();
            }
        }
        if (gamepad1.y) {
            intakeArm.setTargetPosition(590);
            intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(armVelocity);
            while(intakeArm.isBusy()) {
                telemetry.addData("Status", "Waiting for motor");
                telemetry.addData("Motor at", intakeArm.getCurrentPosition());
                telemetry.update();
            }
        }
    }
}
