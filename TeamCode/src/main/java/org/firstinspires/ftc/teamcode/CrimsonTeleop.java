package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import static android.os.SystemClock.sleep;

@TeleOp
public class CrimsonTeleop extends OpMode {

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor actuatorMotor;
    CRServo carouselServo;
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
        armMotor = hardwareMap.get(DcMotorEx.class, "armMotor");
        carouselServo = hardwareMap.get(CRServo.class, "WheelServo");
        leftClaw = hardwareMap.get(CRServo.class, "leftClaw");
        rightClaw = hardwareMap.get(CRServo.class, "rightClaw");
        carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");

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
        double armPower = -1.0;
        /*if (gamepad1.dpad_up) {
            armMotor.setPower(armPower);
        } else {
         //   armMotor.setPower(0.3);
        }

        if (gamepad1.dpad_down) {
            armMotor.setPower(-armPower);
        } else {
            //armMotor.setPower(0);
        } */

        int shippingHeights[] = {0, 200, 300, 400};
        armMotor.setTargetPosition(shippingHeights[0]);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        double armVelocity = 200;
        int x = 0;
        if (gamepad1.dpad_up) {
            x++;
            armMotor.setTargetPosition(shippingHeights[x]);
            armMotor.setVelocity(armVelocity);
            while(armMotor.isBusy()) {
                telemetry.addData("Status", "Waiting for motor");
                telemetry.update();
            }
        }
        if (gamepad1.dpad_down) {
            x--;
            armMotor.setTargetPosition(shippingHeights[x]);
            armMotor.setVelocity(-armVelocity);
            while(armMotor.isBusy()) {
                telemetry.addData("Status", "Waiting for motor");
                telemetry.update();
            }
        }

        //rotate the carousel
        double carouselRotation = 0.25; //needs to be low bc motor moves faster than servo
        /* if (gamepad1.x) {  //servo
            sleep(100);
            carouselServo.setPower(carouselRotation);
            telemetry.addData("Servo moving clockwise", "true");
            telemetry.update();
        }
        if (gamepad1.y) {
            sleep(100);
            carouselServo.setPower(-carouselRotation);
            telemetry.addData("Servo moving counter-clockwise", "true");
            telemetry.update();
        } */

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
        double neutralPosition = 0.0;
        double clawRotation = 0.2;
        if (gamepad2.right_trigger >= 0.3) {
            leftClaw.setPower(clawRotation);
            rightClaw.setPower(-clawRotation);
            telemetry.addData("Claws are moving inward", "true");
            telemetry.update();
        }

        if (gamepad2.left_trigger >= 0.3) {
            leftClaw.setPower(-clawRotation);
            rightClaw.setPower(clawRotation);
            telemetry.addData("Claws are moving outward", "true");
            telemetry.update();
        }

        //Extend and retracting linear actuators
        double actuatorPower = 1.0;
        if (gamepad2.dpad_up) {
            actuatorMotor.setPower(actuatorPower);
            telemetry.addData("Linear actuator is extending", "true");
            telemetry.update();
        }

        if (gamepad2.dpad_down) {
            actuatorMotor.setPower(-actuatorPower);
            telemetry.addData("Linear actuator is retracting", "true");
            telemetry.update();
        }

        if (gamepad2.x) {
            actuatorMotor.setPower(0);
            telemetry.addData("Linear actuator is stopped", "true");
            telemetry.update();
        }
    }
}
