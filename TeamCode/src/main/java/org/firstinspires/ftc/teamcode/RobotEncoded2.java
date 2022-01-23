package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;



public class RobotEncoded2 {

    static final double     TICKS_PER_MOTOR_ROTATION    = 537.7 ;
    static final double     GEAR_REDUCTION    = 2.0;
    static final double     WHEEL_DIAMETER_INCHES   = 3.77953 ;
    static final double     TICKS_PER_INCH         = ((WHEEL_DIAMETER_INCHES* 3.1415)/(TICKS_PER_MOTOR_ROTATION*GEAR_REDUCTION));


    DcMotorEx frontLeft;
    DcMotorEx frontRight;
    DcMotorEx backLeft;
    DcMotorEx backRight;
    DcMotor carouselMotor;
    DcMotorEx intakeArm;
    DcMotorEx intakeMotor;


    public void hardwareMap(HardwareMap hardwareMap){
        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");
        carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");
        intakeMotor = hardwareMap.get(DcMotorEx.class, "intakeMotor");
        intakeArm = hardwareMap.get(DcMotorEx.class, "intakeArm");
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void setDistance (int distanceInches){
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setTargetPosition((int)(distanceInches*TICKS_PER_INCH));
        frontRight.setTargetPosition((int)(distanceInches*TICKS_PER_INCH));
        backLeft.setTargetPosition((int)(distanceInches*TICKS_PER_INCH));
        backRight.setTargetPosition((int)(distanceInches*TICKS_PER_INCH));
    }

    public void strafeLeft(int velocity){
        frontLeft.setTargetPosition(frontLeft.getTargetPosition()*-1);
        backRight.setTargetPosition(backRight.getTargetPosition()*-1);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setVelocity(velocity);
        frontLeft.setVelocity(velocity);
        backLeft.setVelocity(velocity);
        backRight.setVelocity(velocity);
    }

    public void strafeRight(int velocity){
        frontRight.setTargetPosition(frontRight.getTargetPosition()*-1);
        backLeft.setTargetPosition(backLeft.getTargetPosition()*-1);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setVelocity(velocity);
        frontLeft.setVelocity(velocity);
        backLeft.setVelocity(velocity);
        backRight.setVelocity(velocity);
    }

    public void forward(int velocity) {
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setVelocity(velocity);
        frontLeft.setVelocity(velocity);
        backLeft.setVelocity(velocity);
        backRight.setVelocity(velocity);

    }

    public void backward(int velocity){
        frontLeft.setTargetPosition(frontLeft.getTargetPosition()*-1);
        frontRight.setTargetPosition(frontRight.getTargetPosition()*-1);
        backRight.setTargetPosition(backRight.getTargetPosition()*-1);
        backLeft.setTargetPosition(backLeft.getTargetPosition()*-1);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setVelocity(velocity);
        frontLeft.setVelocity(velocity);
        backLeft.setVelocity(velocity);
        backRight.setVelocity(velocity);
    }

    public void turnRight(int velocity){
        frontRight.setTargetPosition(frontRight.getTargetPosition()*-1);
        backRight.setTargetPosition(backRight.getTargetPosition()*-1);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setVelocity(velocity);
        frontLeft.setVelocity(velocity);
        backLeft.setVelocity(velocity);
        backRight.setVelocity(velocity);
    }

    public void turnLeft(int velocity){
        frontLeft.setTargetPosition(frontRight.getTargetPosition()*-1);
        backLeft.setTargetPosition(backRight.getTargetPosition()*-1);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setVelocity(velocity);
        frontLeft.setVelocity(velocity);
        backLeft.setVelocity(velocity);
        backRight.setVelocity(velocity);
    }

    public void stop () {
        frontLeft.setVelocity(0);
        frontRight.setVelocity(0);
        backLeft.setVelocity(0);
        backRight.setVelocity(0);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void moveCarousel(double power) {
        carouselMotor.setPower(power);
    }

}