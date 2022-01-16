package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import static android.os.SystemClock.sleep;


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
    }

    /*public void strafe (int velocity){
        frontLeft.setVelocity(velocity);
        frontRight.setVelocity(-4*velocity);
        backLeft.setVelocity(-velocity);
        backRight.setVelocity(velocity);
    }*/

    public void strafe (int velocity){
        frontRight.setVelocity(velocity);
        sleep(100);
        frontLeft.setVelocity(frontRight.getPower());
        backLeft.setVelocity(-frontRight.getPower());
        backRight.setVelocity(-frontRight.getPower());
    }


    public void forward(int velocity) {
        frontLeft.setPower(velocity);
        frontRight.setPower(velocity);
        backLeft.setPower(velocity);
        backRight.setPower(velocity);
    }

    public void turnRight(int velocity) {
        frontLeft.setPower(-velocity);
        frontRight.setPower(velocity);
        backLeft.setPower(-velocity);
        backRight.setPower(velocity);
    }

    public void turnLeft(int velocity) {
        frontLeft.setPower(velocity);
        frontRight.setPower(-velocity);
        backLeft.setPower(velocity);
        backRight.setPower(-velocity);
    }

    public void stop () {
        frontLeft.setVelocity(0);
        frontRight.setVelocity(0);
        backLeft.setVelocity(0);
        backRight.setVelocity(0);
    }

    public void moveCarousel(double power) {
        carouselMotor.setPower(power);
    }


}
