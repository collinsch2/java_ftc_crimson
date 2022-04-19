package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;

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
    //CRServo sideServo;
    //CRServo upServo;
    ColorSensor colorsensor;
    //Servo intakeServo;

    double sidePosition = 0.894;
    double servoPosition = 0.696;
    //0.25 straight up
    //0.6 horizontal
    double servoPower = 0.2;
    double armVelocity = 1500;
    double drivePower;
    double carouselPower = 1;
    double intakeServoPosition = 0;

    @Override
    public void init() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");
        intakeMotor = hardwareMap.get(DcMotorEx.class, "intakeMotor");
        intakeArm = hardwareMap.get(DcMotorEx.class, "intakeArm");
        //sideServo = hardwareMap.get(CRServo.class, "sideServo");
        //upServo = hardwareMap.get(CRServo.class, "upServo");
        //intakeServo = hardwareMap.get(Servo.class, "intakeServo");

        //colorsensor = hardwareMap.get(ColorSensor.class, "colorsensor");
        intakeArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {

        //Mecanum wheel movement
        double yPower = -gamepad1.left_stick_y;
        double xPower = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;

        if (gamepad1.right_bumper) {
            drivePower = 0.25;
        }

        else {
            drivePower = 0.7;
        }

        frontLeft.setPower((yPower + xPower + rx) * drivePower);
        frontRight.setPower((yPower - xPower - rx) * drivePower);
        backLeft.setPower((yPower - xPower + rx) * drivePower);
        backRight.setPower((yPower + xPower - rx) * drivePower);

        if (gamepad2.x) { //default
            intakeArm.setTargetPosition(-80);
            intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(1000);

                yPower = -gamepad1.left_stick_y;
                xPower = gamepad1.left_stick_x;
                rx = gamepad1.right_stick_x;

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

                yPower = -gamepad1.left_stick_y;
                xPower = gamepad1.left_stick_x;
                rx = gamepad1.right_stick_x;

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

        if (gamepad2.b) {// level 2
            intakeArm.setTargetPosition(-342);
            //-120
            intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(armVelocity);

                yPower = -gamepad1.left_stick_y;
                xPower = gamepad1.left_stick_x;
                rx = gamepad1.right_stick_x;

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

                yPower = -gamepad1.left_stick_y;
                xPower = gamepad1.left_stick_x;
                rx = gamepad1.right_stick_x;

                frontLeft.setPower((yPower + xPower + rx) * drivePower);
                frontRight.setPower((yPower - xPower - rx) * drivePower);
                backLeft.setPower((yPower - xPower + rx) * drivePower);
                backRight.setPower((yPower + xPower - rx) * drivePower);

                telemetry.addData("Status", "Waiting for motor");
                telemetry.addData("Motor at", intakeArm.getCurrentPosition());
                telemetry.update();

        }



        if(gamepad2.left_stick_y < -0.3){ // up
            intakeArm.setTargetPosition(intakeArm.getCurrentPosition() - 20);
            intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(armVelocity);
        }

        if(gamepad2.left_stick_y > 0.3){ // down
            intakeArm.setTargetPosition(intakeArm.getCurrentPosition() + 20);
            intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(armVelocity);
        }


        /*if(gamepad2.dpad_down){
        upServo.setPower(servoPower);
        }

        else if(gamepad2.dpad_up){
        upServo.setPower(-servoPower);
        }

        else {
            upServo.setPower (0);
        }

        if(gamepad2.dpad_left){
           sideServo.setPower(-servoPower);
        }
        else if(gamepad2.dpad_right){
            sideServo.setPower(servoPower);
        }
        else {
            sideServo.setPower(0);
        }

         */

        if (gamepad1.b) {//red
            carouselMotor.setPower(carouselPower);
            telemetry.addData("Carousel moving clockwise", "true");
            telemetry.update();
        }
        else if (gamepad1.x) {//blue
            carouselMotor.setPower(-carouselPower);
            telemetry.addData("Carousel moving counter-clockwise", "true");
            telemetry.update();
        } else {
            carouselMotor.setPower(0);
            telemetry.addData("Carousel is stopped", "true");
            telemetry.update();
        }

        if (gamepad2.right_trigger > 0.3) {
            intakeMotor.setPower(1.0);
            telemetry.addData("Intake moving inwards", "true");
            telemetry.update();
        }
        else if (gamepad2.left_trigger > 0.3) {
            intakeMotor.setPower(-1.0);
            telemetry.addData("Intake moving outwards", "true");
            telemetry.update();
        } else {
            intakeMotor.setPower(0);
            telemetry.addData("Intake stopped", "t  rue");
            telemetry.update();
        }


        telemetry.addData("Up servo = value =", servoPosition);
        telemetry.addData("side servo value = ", sidePosition);
       // telemetry.addData("Up servo position = ", upServo.getPower());
        //telemetry.addData("side servo power = ", sideServo.getPower());

        telemetry.update();

        //telemetry.addData("Red =", colorsensor.red());
        //telemetry.addData("Green =", colorsensor.green());
        //telemetry.addData("Blue =", colorsensor.blue());



    }
}
