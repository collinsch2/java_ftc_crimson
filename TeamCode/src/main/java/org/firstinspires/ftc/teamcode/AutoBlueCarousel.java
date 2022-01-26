package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "bricks")
public class AutoBlueCarousel extends LinearOpMode {

    RobotEncoded2 encoders = new RobotEncoded2();

    static final double TICKS_PER_MOTOR_ROTATION = 537.7;
    static final double GEAR_REDUCTION = 2.0;
    static final double WHEEL_DIAMETER_INCHES = 3.77953;
    static final double TICKS_PER_INCH = ((WHEEL_DIAMETER_INCHES * 3.1415) / (TICKS_PER_MOTOR_ROTATION * GEAR_REDUCTION));
    double speed = 0.5;
    double leftInches = 10;
    double rightInches = 10;
    double leftInches2 = 10;
    double rightInches2 = 10;
    int newLeftTarget;
    int newRightTarget;
    int newRightTarget2;
    int newLeftTarget2;

    @Override
    public void runOpMode() throws InterruptedException {
        encoders.hardwareMap(hardwareMap);
        waitForStart();

        while (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newLeftTarget = encoders.frontLeft.getCurrentPosition() + (int) (leftInches * TICKS_PER_INCH);
            newRightTarget = encoders.frontRight.getCurrentPosition() + (int) (rightInches * TICKS_PER_INCH);
            newRightTarget2 = encoders.backRight.getCurrentPosition() + (int) (rightInches * TICKS_PER_INCH);
            newLeftTarget2 = encoders.backLeft.getCurrentPosition() + (int) (rightInches * TICKS_PER_INCH);

            encoders.frontLeft.setTargetPosition(newLeftTarget);
            encoders.frontRight.setTargetPosition(newRightTarget);
            encoders.backLeft.setTargetPosition(newLeftTarget2);
            encoders.backRight.setTargetPosition(newRightTarget2);

            // Turn On RUN_TO_POSITION
            encoders.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            encoders.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            encoders.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            encoders.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.

            encoders.frontLeft.setPower(speed);
            encoders.frontRight.setPower(speed);
            encoders.backLeft.setPower(speed);
            encoders.backRight.setPower(speed);

            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the robot will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the robot continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.
            while (encoders.frontLeft.isBusy() && encoders.frontRight.isBusy() && encoders.backLeft.isBusy() && encoders.backRight.isBusy()) {

                // Display it for the driver.
                telemetry.addData("Path1", "Running to %7d :%7d", newLeftTarget, newRightTarget);
                telemetry.addData("Path2", "Running at %7d :%7d",
                        encoders.frontLeft.getCurrentPosition(),
                        encoders.frontRight.getCurrentPosition());
                telemetry.update();
            }

            // Stop all motion;
            encoders.frontLeft.setPower(0);
            encoders.frontRight.setPower(0);
            encoders.backLeft.setPower(0);
            encoders.backRight.setPower(0);

            // Turn off RUN_TO_POSITION
            encoders.frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            encoders.frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            encoders.backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            encoders.backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            //  sleep(250);   // optional pause after each move
        /*encoders.backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        encoders.backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        encoders.frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        encoders.frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        encoders.backRight.setTargetPosition(3000);
        encoders.backLeft.setTargetPosition(3000);
        encoders.frontRight.setTargetPosition(3000);
        encoders.frontLeft.setTargetPosition(3000);

        encoders.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        encoders.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        encoders.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        encoders.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        encoders.backLeft.setPower(0.01);
        encoders.backRight.setPower(0.01);
        encoders.frontRight.setPower(0.01);
        encoders.frontLeft.setPower(0.01);

        while (encoders.frontRight.isBusy() && encoders.frontLeft.isBusy() && encoders.backLeft.isBusy() && encoders.backRight.isBusy()) {
            telemetry.addData("Wheels", "are busy");
            telemetry.addData("Front right velocity is", encoders.frontRight.getVelocity());
            telemetry.addData("Front left velocity is", encoders.frontLeft.getVelocity());
            telemetry.addData("Back left velocity is", encoders.backLeft.getVelocity());
            telemetry.addData("Back right velocity is", encoders.backRight.getVelocity());
            telemetry.update();
        }

        encoders.backLeft.setPower(0);
        encoders.backRight.setPower(0);
        encoders.frontRight.setPower(0);
        encoders.frontLeft.setPower(0);


        /*encoders.intakeArm.setTargetPosition((-168));
        encoders.intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        encoders.intakeArm.setVelocity(1000);
        sleep(1000);
        encoders.intakeMotor.setPower(-0.75);
        sleep(2000);

         */

        /*robot.hardwareMap(hardwareMap);
        waitForStart();
        robot.turnRight(0.5);
        sleep(500);
        robot.strafeRight(0.5);
        sleep(1000);
        robot.forward(0.5);
        sleep(4000);
         */

        }
    }
}


