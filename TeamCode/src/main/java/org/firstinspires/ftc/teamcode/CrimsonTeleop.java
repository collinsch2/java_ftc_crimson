package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import static android.os.SystemClock.sleep;

@TeleOp(name="CrimsonTeleop")
public class CrimsonTeleop extends OpMode {
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor carouselMotor;
    DcMotorEx intakeArm;
    DcMotorEx intakeMotor;
    //Servo clawRight;
    //Servo clawLeft;

    @Override
    public void init() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");
        intakeMotor = hardwareMap.get(DcMotorEx.class, "intakeMotor");
        intakeArm = hardwareMap.get(DcMotorEx.class, "intakeArm");
        intakeArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    @Override
    public void loop() {

        //Mecanum wheel movement
        double yPower = -gamepad1.left_stick_y;
        double xPower = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;
        double drivePower;

        if (gamepad1.right_bumper) {
            drivePower = 0.25;
        }
        else {
            drivePower = 0.5;
        }

        frontRight.setDirection(DcMotorSimple.Direction.REVERSE); //reverse the right side so that they move counter-clockwise
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setPower((yPower + xPower + rx) * drivePower);
        frontRight.setPower((yPower - xPower - rx) * drivePower);
        backLeft.setPower((yPower - xPower + rx) * drivePower);
        backRight.setPower((yPower + xPower - rx) * drivePower);


        //Raise and lower the arm
        double armVelocity = 1500;
        if (gamepad2.x) { //default
            intakeArm.setTargetPosition(-80);
            intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(1000);

                frontLeft.setPower((yPower + xPower + rx) * drivePower);
                frontRight.setPower((yPower - xPower - rx) * drivePower);
                backLeft.setPower((yPower - xPower + rx) * drivePower);
                backRight.setPower((yPower + xPower - rx) * drivePower);

                telemetry.addData("Status", "Waiting for motor");
                telemetry.addData("Motor at", intakeArm.getCurrentPosition());
                telemetry.addData("Motor velocity at", intakeArm.getVelocity());
                telemetry.addData("Motor power at", intakeArm.getPower());
                telemetry.update();
            }


        if (gamepad2.y) { //level 1
            intakeArm.setTargetPosition(-168);
            //-70
            intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(armVelocity);

                frontLeft.setPower((yPower + xPower + rx) * drivePower);
                frontRight.setPower((yPower - xPower - rx) * drivePower);
                backLeft.setPower((yPower - xPower + rx) * drivePower);
                backRight.setPower((yPower + xPower - rx) * drivePower);

                telemetry.addData("Status", "Waiting for motor");
                telemetry.addData("Motor at", intakeArm.getCurrentPosition());
                telemetry.addData("Motor velocity at", intakeArm.getVelocity());
                telemetry.addData("Motor power at", intakeArm.getPower());
                telemetry.update();
            }

telemetry.addData("arm is" , intakeArm.getCurrentPosition());

        if (gamepad2.b) {// level 2
            intakeArm.setTargetPosition(-342);
            //-120
            intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(armVelocity);

                frontLeft.setPower((yPower + xPower + rx) * drivePower);
                frontRight.setPower((yPower - xPower - rx) * drivePower);
                backLeft.setPower((yPower - xPower + rx) * drivePower);
                backRight.setPower((yPower + xPower - rx) * drivePower);

                telemetry.addData("Status", "Waiting for motor");
                telemetry.addData("Motor at", intakeArm.getCurrentPosition());
                telemetry.update();
            }


        if (gamepad2.a) {// level 3
            intakeArm.setTargetPosition(-590);
            //-590
            intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(armVelocity);

                frontLeft.setPower((yPower + xPower + rx) * drivePower);
                frontRight.setPower((yPower - xPower - rx) * drivePower);
                backLeft.setPower((yPower - xPower + rx) * drivePower);
                backRight.setPower((yPower + xPower - rx) * drivePower);

                telemetry.addData("Status", "Waiting for motor");
                telemetry.addData("Motor at", intakeArm.getCurrentPosition());
                telemetry.update();
            }

        if(gamepad2.left_stick_y > 0.3){ // up
            intakeArm.setTargetPosition(intakeArm.getCurrentPosition() + 20);
            intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(armVelocity);
        }
        if(gamepad2.dpad_up){ // up
            intakeArm.setTargetPosition(intakeArm.getCurrentPosition() - 20);
            intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(armVelocity);
        }

        if(gamepad2.left_stick_y < -0.3){ // down
            intakeArm.setTargetPosition(intakeArm.getCurrentPosition() - 20);
            intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(armVelocity);
        }

        if(gamepad2.dpad_down){ // down
            intakeArm.setTargetPosition(intakeArm.getCurrentPosition() + 20);
            intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(armVelocity);
        }

        //rotate the carousel
        double carouselPower = 1; //needs to be low bc motor moves faster than servo

        if (gamepad1.x) {
            carouselMotor.setPower(carouselPower);
            telemetry.addData("Carousel moving clockwise", "true");
            telemetry.update();
        }
        else if (gamepad1.y) {
            carouselMotor.setPower(-carouselPower);
            telemetry.addData("Carousel moving counter-clockwise", "true");
            telemetry.update();
        } else {
            carouselMotor.setPower(0);
            telemetry.addData("Carousel is stopped", "true");
            telemetry.update();
        }

        //Intake movement
        //double intakePower = 0.75;

        if (gamepad2.right_trigger > 0.3) {
            intakeMotor.setPower(0.9);
            telemetry.addData("Intake moving inwards", "true");
            telemetry.update();
        }
        else if (gamepad2.left_trigger > 0.3) {
            intakeMotor.setPower(-0.5);
            telemetry.addData("Intake moving outwards", "true");
            telemetry.update();
        } else {
            intakeMotor.setPower(0);
            telemetry.addData("Intake stopped", "true");
            telemetry.update();
        }

        /*if (gamepad2.dpad_down) {
            clawRight.setPosition(-1.0);
            clawLeft.setPosition(1.0);
            telemetry.addData("claw moving inwards", "true");
            telemetry.update();
        }
        if (gamepad2.dpad_up) {
            clawRight.setPosition(1.0);
            clawLeft.setPosition(-1.0);
            telemetry.addData("claw moving outwards", "true");
            telemetry.update();
        }*/

        //Moving the arm a different way
        /*if (gamepad2.left_bumper) {
            armMotor.setTargetPosition(armMotor.getCurrentPosition() -40);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setVelocity(armVelocity);
            telemetry.addData("Arm moving up", "true");
            telemetry.update();
        }
        if (gamepad2.right_bumper) {
            armMotor.setTargetPosition(armMotor.getCurrentPosition() +40);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setVelocity(armVelocity);
            telemetry.addData("Arm moving down", "true");
            telemetry.update();
        } */

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

    }
}
