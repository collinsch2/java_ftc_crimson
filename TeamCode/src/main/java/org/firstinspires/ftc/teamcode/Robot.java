package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {

    DcMotor frontLeft;
    DcMotorEx frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor carouselMotor;
    DcMotorEx armMotor;

    public void hardwareMap(HardwareMap hardwareMap){
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        armMotor = hardwareMap.get(DcMotorEx.class, "intakeArm");
        carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");
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


    public void moveCarousel(double power) {
        carouselMotor.setPower(power);
    }

}
