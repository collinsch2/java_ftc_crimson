
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import static android.os.SystemClock.sleep;

public class RobotEncoded {

    final double driveVelocity = 700;
    final double turnVelocity = 250;
    final int armVelocity = 1500;
    final double intakePower = 0.8;
    final double outtakePower = -0.4;
    final double carouselPower = 0.7;
    //initially 1, but was going too fast for auto
    final double degreesPerInch = 5.294;


    DcMotorEx frontLeft;
    DcMotorEx frontRight;
    DcMotorEx backLeft;
    DcMotorEx backRight;
    DcMotor carouselMotor;
    DcMotorEx intakeArm;
    DcMotorEx intakeMotor;
    Servo cappingArm;
    CRServo cappingClaw;

    double restingPos = 0.468;
    double startingPos = 0.217;
    double grabPos = 0.897;
    double cappingPos = 0.6;

    final double     TICKS_PER_MOTOR_ROTATION    = 537.7 ;
    final double     GEAR_REDUCTION    = 1;
    final double     WHEEL_DIAMETER_INCHES   = 3.77953;
    final double     TICKS_PER_INCH  = (TICKS_PER_MOTOR_ROTATION*GEAR_REDUCTION)/(WHEEL_DIAMETER_INCHES * 3.1415);


    public void hardwareMap(HardwareMap hardwareMap){
        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");
        intakeMotor = hardwareMap.get(DcMotorEx.class, "intakeMotor");
        intakeArm = hardwareMap.get(DcMotorEx.class, "intakeArm");
        intakeArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        cappingArm = hardwareMap.get(Servo.class, "cappingArm");
        cappingClaw = hardwareMap.get(CRServo.class, "cappingClaw");
    }

    public void cappingArmRest(){
        cappingArm.setPosition(restingPos);
    }
    public void cappingArmStart(){cappingArm.setPosition(startingPos);}

    public void arm0(){
        intakeArm.setTargetPosition(45);
        intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        intakeArm.setVelocity(1000);

        while(intakeArm.isBusy()){ }

        intakeArm.setVelocity(0);
    }

    public void arm1(){
        intakeArm.setTargetPosition(205);
        //-168
        intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        intakeArm.setVelocity(armVelocity);

        while(intakeArm.isBusy()){ }

    }

    public void arm2(){
        intakeArm.setTargetPosition(377);
        //-360
        intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        intakeArm.setVelocity(armVelocity);

        while(intakeArm.isBusy()){ }

    }

    public void arm3(){
        intakeArm.setTargetPosition(570);
        //-590
        intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        intakeArm.setVelocity(armVelocity);

        while(intakeArm.isBusy()){ }

    }

    public void intake(int intakeTime){
        intakeMotor.setPower(intakePower);
        sleep(intakeTime);
        intakeMotor.setPower(0);
    }

    public void outtake(int outtakeTime){
        intakeMotor.setPower(outtakePower);
        sleep(outtakeTime);
        intakeMotor.setPower(0);
    }

    public void carouselRed(int carouselTime){
        carouselMotor.setPower(carouselPower);
        sleep(carouselTime);
        carouselMotor.setPower(0);
    }

    public void carouselBlue(int carouselTime){
        carouselMotor.setPower(-carouselPower);
        sleep(carouselTime);
        carouselMotor.setPower(0);
    }

    public void forward(int distanceInches) {
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() +(int)(distanceInches*TICKS_PER_INCH));
        frontRight.setTargetPosition(frontRight.getCurrentPosition() +(int)(distanceInches*TICKS_PER_INCH));
        backRight.setTargetPosition(backRight.getCurrentPosition() +(int)(distanceInches*TICKS_PER_INCH));
        backLeft.setTargetPosition(backLeft.getCurrentPosition() + (int)(distanceInches*TICKS_PER_INCH));

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setVelocity(driveVelocity);
        frontLeft.setVelocity(driveVelocity);
        backLeft.setVelocity(driveVelocity);
        backRight.setVelocity(driveVelocity);

        while (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) { }

        frontLeft.setVelocity(0);
        frontRight.setVelocity(0);
        backLeft.setVelocity(0);
        backRight.setVelocity(0);
    }


    public void backward(int distanceInches){
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() +(int)(-distanceInches*TICKS_PER_INCH));
        frontRight.setTargetPosition(frontRight.getCurrentPosition() +(int)(-distanceInches*TICKS_PER_INCH));
        backRight.setTargetPosition(backRight.getCurrentPosition() +(int)(-distanceInches*TICKS_PER_INCH));
        backLeft.setTargetPosition(backLeft.getCurrentPosition() + (int)(-distanceInches*TICKS_PER_INCH));

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setVelocity(driveVelocity);
        frontLeft.setVelocity(driveVelocity);
        backLeft.setVelocity(driveVelocity);
        backRight.setVelocity(driveVelocity);


        while (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) { }

        frontLeft.setVelocity(0);
        frontRight.setVelocity(0);
        backLeft.setVelocity(0);
        backRight.setVelocity(0);
    }

    public void strafeRight (int distanceInches){
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() +(int)(distanceInches*TICKS_PER_INCH));
        frontRight.setTargetPosition(frontRight.getCurrentPosition() +(int)(-distanceInches*TICKS_PER_INCH));
        backRight.setTargetPosition(backRight.getCurrentPosition() +(int)(distanceInches*TICKS_PER_INCH));
        backLeft.setTargetPosition(backLeft.getCurrentPosition() + (int)(-distanceInches*TICKS_PER_INCH));

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setVelocity(driveVelocity);
        frontLeft.setVelocity(driveVelocity);
        backLeft.setVelocity(driveVelocity);
        backRight.setVelocity(driveVelocity);

        while (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) { }

        frontLeft.setVelocity(0);
        frontRight.setVelocity(0);
        backLeft.setVelocity(0);
        backRight.setVelocity(0);
    }

    public void strafeLeft (int distanceInches){
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() +(int)(-distanceInches*TICKS_PER_INCH));
        frontRight.setTargetPosition(frontRight.getCurrentPosition() +(int)(distanceInches*TICKS_PER_INCH));
        backRight.setTargetPosition(backRight.getCurrentPosition() +(int)(-distanceInches*TICKS_PER_INCH));
        backLeft.setTargetPosition(backLeft.getCurrentPosition() + (int)(distanceInches*TICKS_PER_INCH));

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setVelocity(driveVelocity);
        frontRight.setVelocity(driveVelocity);
        backLeft.setVelocity(driveVelocity);
        backRight.setVelocity(driveVelocity);

        while (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) { }

        frontLeft.setVelocity(0);
        frontRight.setVelocity(0);
        backLeft.setVelocity(0);
        backRight.setVelocity(0);

    }

    public void turnRight (int degrees){
        int distanceInches = (int)(degrees/degreesPerInch);
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() +(int)(distanceInches*TICKS_PER_INCH));
        frontRight.setTargetPosition(frontRight.getCurrentPosition() +(int)(-distanceInches*TICKS_PER_INCH));
        backRight.setTargetPosition(backRight.getCurrentPosition() +(int)(-distanceInches*TICKS_PER_INCH));
        backLeft.setTargetPosition(backLeft.getCurrentPosition() + (int)(distanceInches*TICKS_PER_INCH));

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setVelocity(driveVelocity);
        frontRight.setVelocity(driveVelocity);
        backLeft.setVelocity(driveVelocity);
        backRight.setVelocity(driveVelocity);

        while (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) { }

        frontLeft.setVelocity(0);
        frontRight.setVelocity(0);
        backLeft.setVelocity(0);
        backRight.setVelocity(0);

    }

    public void turnLeft (int degrees){
        int distanceInches = (int)(degrees/degreesPerInch);
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() +(int)(-distanceInches*TICKS_PER_INCH));
        frontRight.setTargetPosition(frontRight.getCurrentPosition() +(int)(distanceInches*TICKS_PER_INCH));
        backRight.setTargetPosition(backRight.getCurrentPosition() +(int)(distanceInches*TICKS_PER_INCH));
        backLeft.setTargetPosition(backLeft.getCurrentPosition() + (int)(-distanceInches*TICKS_PER_INCH));

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setVelocity(driveVelocity);
        frontRight.setVelocity(driveVelocity);
        backLeft.setVelocity(driveVelocity);
        backRight.setVelocity(driveVelocity);

        while (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) { }

        frontLeft.setVelocity(0);
        frontRight.setVelocity(0);
        backLeft.setVelocity(0);
        backRight.setVelocity(0);

    }

    public void diagonalUpLeft(int distanceInches){
        frontRight.setTargetPosition(frontRight.getCurrentPosition() +(int)(distanceInches*TICKS_PER_INCH));
        backLeft.setTargetPosition(backLeft.getCurrentPosition() + (int)(distanceInches*TICKS_PER_INCH));

        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setVelocity(driveVelocity);
        backLeft.setVelocity(driveVelocity);

        while (frontRight.isBusy() && backLeft.isBusy()) { }

        frontRight.setVelocity(0);
        backLeft.setVelocity(0);
    }

    public void diagonalUpRight(int distanceInches){
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() +(int)(distanceInches*TICKS_PER_INCH));
        backRight.setTargetPosition(backRight.getCurrentPosition() + (int)(distanceInches*TICKS_PER_INCH));

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setVelocity(driveVelocity);
        backRight.setVelocity(driveVelocity);

        while (frontLeft.isBusy() && backRight.isBusy()) { }

        frontLeft.setVelocity(0);
        backRight.setVelocity(0);
    }

    public void diagonaldownLeft(int distanceInches){
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() +(int)(-distanceInches*TICKS_PER_INCH));
        backRight.setTargetPosition(backRight.getCurrentPosition() + (int)(-distanceInches*TICKS_PER_INCH));

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setVelocity(driveVelocity);
        backRight.setVelocity(driveVelocity);

        while (frontLeft.isBusy() && backRight.isBusy()) { }

        frontLeft.setVelocity(0);
        backRight.setVelocity(0);
    }

    public void diagonaldownRight(int distanceInches){
        frontRight.setTargetPosition(frontRight.getCurrentPosition() +(int)(-distanceInches*TICKS_PER_INCH));
        backLeft.setTargetPosition(backLeft.getCurrentPosition() + (int)(-distanceInches*TICKS_PER_INCH));

        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setVelocity(driveVelocity);
        backLeft.setVelocity(driveVelocity);

        while (frontRight.isBusy() && backLeft.isBusy()) { }

        frontRight.setVelocity(0);
        backLeft.setVelocity(0);
    }

    public void stop(){
        frontLeft.setVelocity(0);
        frontRight.setVelocity(0);
        backLeft.setVelocity(0);
        backRight.setVelocity(0);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}


