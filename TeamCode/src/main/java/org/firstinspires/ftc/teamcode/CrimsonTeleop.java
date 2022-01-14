package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import static android.os.SystemClock.sleep;

@TeleOp(name="CrimsonTeleop")
public class CrimsonTeleop extends OpMode {

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor actuatorMotor;
    CRServo leftClaw;
    CRServo rightClaw;
    DcMotorEx armMotor;
    DcMotor carouselMotor;

    @Override
    public void init() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        actuatorMotor = hardwareMap.get(DcMotor.class, "actuatorMotor");
        leftClaw = hardwareMap.get(CRServo.class, "leftClaw");
        rightClaw = hardwareMap.get(CRServo.class, "rightClaw");
        carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");
        armMotor = hardwareMap.get(DcMotorEx.class, "armMotor");
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    @Override
    public void loop() {

        //Mecanum wheel movement
        double yPower = -gamepad1.left_stick_y;
        double xPower = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;

        frontRight.setDirection(DcMotorSimple.Direction.REVERSE); //reverse the right side so that they move counter-clockwise
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setPower((yPower + xPower + rx) * 0.75);
        frontRight.setPower((yPower - xPower - rx) * 0.75);
        backLeft.setPower((yPower - xPower + rx) * 0.75);
        backRight.setPower((yPower + xPower - rx) * 0.75);

        //Raise and lower the arm
        double armVelocity = 500;
        if (gamepad2.a) {
            armMotor.setTargetPosition(-37);
            armMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            armMotor.setVelocity(armVelocity);
            while(armMotor.isBusy()) {
                telemetry.addData("Status", "Waiting for motor");
                telemetry.addData("Motor at", armMotor.getCurrentPosition());
                telemetry.update();
            }
        }

        if (gamepad2.b) {
            armMotor.setTargetPosition(-85);
            armMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            armMotor.setVelocity(armVelocity);
            while(armMotor.isBusy()) {
                telemetry.addData("Motor at", armMotor.getCurrentPosition());
                telemetry.addData("Status", "Waiting for motor");
                telemetry.update();
            }
        }

        if (gamepad2.y) {
            armMotor.setTargetPosition(-145);
            armMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            armMotor.setVelocity(armVelocity);
            while(armMotor.isBusy()) {
                telemetry.addData("Motor at", armMotor.getCurrentPosition());
                telemetry.addData("Status", "Waiting for motor");
                telemetry.update();
            }
        }
        //rotate the carousel
        double carouselRotation = 0.75; //needs to be low bc motor moves faster than servo

        if (gamepad1.x) {  //motor
            sleep(100);
            carouselMotor.setPower(carouselRotation);
            telemetry.addData("Servo moving clockwise", "true");
            telemetry.update();
        }
        if (gamepad1.y) {
            sleep(100);
            carouselMotor.setPower(-carouselRotation);
            telemetry.addData("Servo moving counter-clockwise", "true");
            telemetry.update();
        }
        if (gamepad1.a) {
            sleep(100);
            carouselMotor.setPower(0);
            telemetry.addData("Servo is stopped", "true");
            telemetry.update();
        }

        //Claw movement
        double clawRotation = 1.0;
        if (gamepad2.dpad_left) {
            leftClaw.setPower(-clawRotation);
            rightClaw.setPower(clawRotation);
            telemetry.addData("Claws are moving outward", "true");
            telemetry.update();
        }

        if (gamepad2.dpad_right) {
            leftClaw.setPower(clawRotation);
            rightClaw.setPower(-clawRotation);
            telemetry.addData("Claws are moving inward", "true");
            telemetry.update();
        }

        //Extend and retracting linear actuators
        double actuatorPower = 1.0;
        if (gamepad2.dpad_down) {
            actuatorMotor.setPower(actuatorPower);
            telemetry.addData("Linear actuator is extending", "true");
            telemetry.update();
        }

        if (gamepad2.dpad_up) {
            actuatorMotor.setPower(-actuatorPower);
            telemetry.addData("Linear actuator is retracting", "true");
            telemetry.update();
        }

        if (gamepad2.x) {
            actuatorMotor.setPower(0);
            telemetry.addData("Linear actuator is stopped", "true");
            telemetry.update();
        }

        //Moving the arm a different way
        if (gamepad2.left_bumper) {
            armMotor.setTargetPosition(armMotor.getCurrentPosition() -15);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setVelocity(armVelocity);
            telemetry.addData("Arm moving up", "true");
            telemetry.update();
        }
        if (gamepad2.right_bumper) {
            armMotor.setTargetPosition(armMotor.getCurrentPosition() +15);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setVelocity(armVelocity);
            telemetry.addData("Arm moving down", "true");
            telemetry.update();
        }


        /*armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        if (gamepad2.left_bumper) {
            armMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
            armMotor.setVelocity(-50);
            telemetry.addData("Arm moving", "up");
        }
        if (gamepad2.right_bumper) {
            armMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
            armMotor.setVelocity(50);
            telemetry.addData("Arm moving", "down");

        }
        if (armMotor.getCurrentPosition() > -30 ) {
            armMotor.setVelocity(0);
            telemetry.addData("Arm at", "minimum");

        }
        if (armMotor.getCurrentPosition() < -160) {
            armMotor.setVelocity(0);
            telemetry.addData("Arm at", "maximum");
        } */

/*      double armPosition = gamepad2.left_stick_y;
        armMotor.setTargetPosition((int) (armPosition * -160));
        armMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        armMotor.setVelocity(armVelocity); */
    }
}
