package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor actuatorMotor;
    DcMotor carouselMotor;
    CRServo leftClaw;
    CRServo rightClaw;
    DcMotorEx armMotor;

    public void hardwareMap(HardwareMap hardwareMap){
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        actuatorMotor = hardwareMap.get(DcMotor.class, "actuatorMotor");
        armMotor = hardwareMap.get(DcMotorEx.class, "armMotor");
        carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");
        leftClaw = hardwareMap.get(CRServo.class, "leftClaw");
        rightClaw = hardwareMap.get(CRServo.class, "rightClaw");
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void forward(double Power) {
        frontLeft.setPower(Power);
        frontRight.setPower(Power);
        backLeft.setPower(Power);
        backRight.setPower(Power);
    }

    public void strafe(double Power) {
        frontLeft.setPower(Power);
        frontRight.setPower(-Power);
        backLeft.setPower(-Power);
        backRight.setPower(Power);
    }

    public void turnRight(double Power) {
        frontLeft.setPower(-Power);
        frontRight.setPower(Power);
        backLeft.setPower(-Power);
        backRight.setPower(Power);
    }

    public void turnLeft(double Power) {
        frontLeft.setPower(Power);
        frontRight.setPower(-Power);
        backLeft.setPower(Power);
        backRight.setPower(-Power);
    }

    public void stop () {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }


    public void moveCarousel() {
        carouselMotor.setPower(1);
    }

}
