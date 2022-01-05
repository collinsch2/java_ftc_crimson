package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class RobotEncoded {

    DcMotorEx frontLeft;
    DcMotorEx frontRight;
    DcMotorEx backLeft;
    DcMotorEx backRight;
    DcMotor carouselMotor;

    public void hardwareMap(HardwareMap hardwareMap){
        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");
        carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void strafe (int velocity){
        frontLeft.setVelocity(velocity);
        frontRight.setVelocity(-velocity);
        backLeft.setVelocity(-velocity);
        backRight.setVelocity(velocity);
    }

    public void forward(double velocity) {
        frontLeft.setPower(velocity);
        frontRight.setPower(velocity);
        backLeft.setPower(velocity);
        backRight.setPower(velocity);
    }

    public void turnRight(double velocity) {
        frontLeft.setPower(-velocity);
        frontRight.setPower(velocity);
        backLeft.setPower(-velocity);
        backRight.setPower(velocity);
    }

    public void turnLeft(double velocity) {
        frontLeft.setPower(velocity);
        frontRight.setPower(-velocity);
        backLeft.setPower(velocity);
        backRight.setPower(-velocity);
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
