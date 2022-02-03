
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import static android.os.SystemClock.sleep;

public class RobotEncoded2 {

    static final double     TICKS_PER_MOTOR_ROTATION    = 537.7 ;
    static final double     GEAR_REDUCTION    = 2.0;
    static final double     WHEEL_DIAMETER_INCHES   = 3.77953;
    static final double     TICKS_PER_INCH  = (TICKS_PER_MOTOR_ROTATION*GEAR_REDUCTION)/(WHEEL_DIAMETER_INCHES * 3.1415);
    final double drivePower = 0.6;
    final double driveVelocity = 500;
    final double turnVelocity = 250;

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
    }

    public void forward(int distanceInches){
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setTargetPosition(2000);
        frontRight.setTargetPosition(2000);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setVelocity(driveVelocity);
        frontLeft.setVelocity(driveVelocity);
        backLeft.setVelocity(frontLeft.getVelocity());
        backRight.setVelocity(frontRight.getVelocity());
    }


    public void backward(int distanceInches){
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setTargetPosition(2000);
        frontRight.setTargetPosition(2000);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setVelocity(-driveVelocity);
        frontLeft.setVelocity(driveVelocity);
        backLeft.setVelocity(-frontLeft.getVelocity());
        backRight.setVelocity(-frontRight.getVelocity());
    }

    public void strafeRight (int distanceInches){
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setTargetPosition((int)(distanceInches*TICKS_PER_INCH));
        frontRight.setTargetPosition((int)(-distanceInches*TICKS_PER_INCH));
        backLeft.setTargetPosition((int)(-distanceInches*TICKS_PER_INCH));
        backRight.setTargetPosition((int)(distanceInches*TICKS_PER_INCH));

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setVelocity(driveVelocity);
        frontRight.setVelocity(driveVelocity);
        backLeft.setVelocity(driveVelocity);
        backRight.setVelocity(driveVelocity);
    }

    public void strafeLeft (int distanceInches){
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setTargetPosition((int)(-distanceInches*TICKS_PER_INCH));
        frontRight.setTargetPosition((int)(distanceInches*TICKS_PER_INCH));
        backLeft.setTargetPosition((int)(distanceInches*TICKS_PER_INCH));
        backRight.setTargetPosition((int)(-distanceInches*TICKS_PER_INCH));

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setVelocity(driveVelocity);
        frontRight.setVelocity(driveVelocity);
        backLeft.setVelocity(driveVelocity);
        backRight.setVelocity(driveVelocity);
    }

    public void turnRight (int distanceInches){
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setTargetPosition((int)(distanceInches*TICKS_PER_INCH));
        frontRight.setTargetPosition((int)(-distanceInches*TICKS_PER_INCH));
        backLeft.setTargetPosition((int)(distanceInches*TICKS_PER_INCH));
        backRight.setTargetPosition((int)(-distanceInches*TICKS_PER_INCH));

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setVelocity(turnVelocity);
        frontRight.setVelocity(turnVelocity);
        backLeft.setVelocity(turnVelocity);
        backRight.setVelocity(turnVelocity);
    }

    public void turnLeft (int distanceInches){
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setTargetPosition((int)(-distanceInches*TICKS_PER_INCH));
        frontRight.setTargetPosition((int)(distanceInches*TICKS_PER_INCH));
        backLeft.setTargetPosition((int)(-distanceInches*TICKS_PER_INCH));
        backRight.setTargetPosition((int)(distanceInches*TICKS_PER_INCH));

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setVelocity(turnVelocity);
        frontRight.setVelocity(turnVelocity);
        backLeft.setVelocity(turnVelocity);
        backRight.setVelocity(turnVelocity);
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


