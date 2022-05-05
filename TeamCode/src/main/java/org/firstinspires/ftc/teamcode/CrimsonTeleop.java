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
    ColorSensor colorSensor;
    DcMotor intakeMotor;
    Servo cappingArm;
    CRServo cappingClaw;


    double armVelocity = 2000;
    double drivePower;
    double carouselPower = 1;


    double restingPos = 0.468;
    double startingPos = 0.217;
    double grabPos = 0.897;
    double cappingPos = 0.6;

    @Override
    public void init() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");
        intakeMotor = hardwareMap.get(DcMotorEx.class, "intakeMotor");
        intakeArm = hardwareMap.get(DcMotorEx.class, "intakeArm");
        cappingArm = hardwareMap.get(Servo.class, "cappingArm");
        cappingClaw = hardwareMap.get(CRServo.class, "cappingClaw");
        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
        intakeArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

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
            drivePower = 0.65;
        }

        frontLeft.setPower((yPower + xPower + rx) * drivePower);
        frontRight.setPower((yPower - xPower - rx) * drivePower);
        backLeft.setPower((yPower - xPower + rx) * drivePower);
        backRight.setPower((yPower + xPower - rx) * drivePower);

        //fourth value: 182

        if (gamepad2.x) { //default
            intakeArm.setTargetPosition(45);
            //48
            intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(1000);

                yPower = -gamepad1.left_stick_y;
                xPower = gamepad1.left_stick_x;
                rx = gamepad1.right_stick_x;

                frontLeft.setPower((yPower + xPower + rx) * drivePower);
                frontRight.setPower((yPower - xPower - rx) * drivePower);
                backLeft.setPower((yPower - xPower + rx) * drivePower);
                backRight.setPower((yPower + xPower - rx) * drivePower);
        }

        if (gamepad2.y) { //Shared shipping hub
            intakeArm.setTargetPosition(170);
            //94 LEvel 1
            //170
            intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(armVelocity);

                yPower = -gamepad1.left_stick_y;
                xPower = gamepad1.left_stick_x;
                rx = gamepad1.right_stick_x;

                frontLeft.setPower((yPower + xPower + rx) * drivePower);
                frontRight.setPower((yPower - xPower - rx) * drivePower);
                backLeft.setPower((yPower - xPower + rx) * drivePower);
                backRight.setPower((yPower + xPower - rx) * drivePower);

        }

        if (gamepad2.b) {// level 2
            intakeArm.setTargetPosition(357);
            //245
            intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(armVelocity);

                yPower = -gamepad1.left_stick_y;
                xPower = gamepad1.left_stick_x;
                rx = gamepad1.right_stick_x;

                frontLeft.setPower((yPower + xPower + rx) * drivePower);
                frontRight.setPower((yPower - xPower - rx) * drivePower);
                backLeft.setPower((yPower - xPower + rx) * drivePower);
                backRight.setPower((yPower + xPower - rx) * drivePower);

        }

        if (gamepad2.a) {// level 3
            intakeArm.setTargetPosition(507);
            //500
            intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(armVelocity);

                yPower = -gamepad1.left_stick_y;
                xPower = gamepad1.left_stick_x;
                rx = gamepad1.right_stick_x;

                frontLeft.setPower((yPower + xPower + rx) * drivePower);
                frontRight.setPower((yPower - xPower - rx) * drivePower);
                backLeft.setPower((yPower - xPower + rx) * drivePower);
                backRight.setPower((yPower + xPower - rx) * drivePower);


        }



        if(gamepad2.left_stick_y < -0.3){ // up
            intakeArm.setTargetPosition(intakeArm.getCurrentPosition() + 20);
            intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(armVelocity);
        }

        if(gamepad2.left_stick_y > 0.3){ // down
            intakeArm.setTargetPosition(intakeArm.getCurrentPosition() - 20);
            intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            intakeArm.setVelocity(armVelocity);
        }


        if (gamepad1.b) {//red
            carouselMotor.setPower(-carouselPower);
            telemetry.addData("Carousel moving clockwise", "true");
            telemetry.update();
        }
        else if (gamepad1.x) {//blue
            carouselMotor.setPower(carouselPower);
            telemetry.addData("Carousel moving counter-clockwise", "true");
            telemetry.update();
        } else {
            carouselMotor.setPower(0);
            telemetry.addData("Carousel is stopped", "true");
            telemetry.update();
        }

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

        if(gamepad2.dpad_up){
            cappingArm.setPosition(cappingPos);
        }
        else if (gamepad2.dpad_down){
            cappingArm.setPosition(grabPos);
        }

        if(gamepad2.start){
            cappingArm.setPosition(restingPos);
        }
        else if(gamepad2.back){
            cappingArm.setPosition(startingPos);
        }


        if(gamepad2.dpad_left){
            cappingArm.setPosition(cappingArm.getPosition() + 0.01);
        }
        else if(gamepad2.dpad_right){
            cappingArm.setPosition(cappingArm.getPosition() - 0.01);
        }

        if(gamepad2.right_bumper){
            cappingClaw.setPower(-0.5);

        }
        else if (gamepad2.left_bumper){
            cappingClaw.setPower(0.5);
        }
        else{
            cappingClaw.setPower(0);
        }


        if(colorSensor.red() > 400){
            carouselMotor.setPower(0.1);
        }

        telemetry.addData("Red = ", colorSensor.red());
        telemetry.addData("Green = ", colorSensor.green());
        telemetry.addData("Blue = ", colorSensor.blue());
        telemetry.addData("ARGB = ", colorSensor.argb());
        telemetry.addData("Alpha/light = ", colorSensor.alpha());
        telemetry.addData("capping arm ", cappingArm.getPosition());

        telemetry.addData("Motor at", intakeArm.getCurrentPosition());
        telemetry.addData("Motor velocity at", intakeArm.getVelocity());

        telemetry.update();
//open: 0.51
        //
    }
}
