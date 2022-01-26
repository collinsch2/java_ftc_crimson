package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "bricks")
public class AutoBlueCarousel extends LinearOpMode {

    RobotEncoded2 encoders = new RobotEncoded2();


    @Override
    public void runOpMode() throws InterruptedException {

        final double TICKS_PER_MOTOR_ROTATION = 537.7;
        final double GEAR_REDUCTION = 2.0;
        final double WHEEL_DIAMETER_INCHES = 3.77953;
        final double TICKS_PER_INCH = ((WHEEL_DIAMETER_INCHES * 3.1415) / (TICKS_PER_MOTOR_ROTATION * GEAR_REDUCTION));
        double speed = 0.5;
        double leftInches = 10;
        double rightInches = 10;
        double leftInches2 = 10;
        double rightInches2 = 10;
        int newLeftTarget;
        int newRightTarget;
        int newRightTarget2;
        int newLeftTarget2;

        DcMotorEx frontLeft;
        DcMotorEx frontRight;
        DcMotorEx backLeft;
        DcMotorEx backRight;
        DcMotor carouselMotor;
        DcMotorEx intakeArm;
        DcMotorEx intakeMotor;

        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");
        carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");
        intakeMotor = hardwareMap.get(DcMotorEx.class, "intakeMotor");
        intakeArm = hardwareMap.get(DcMotorEx.class, "intakeArm");

        ;
        //encoders.hardwareMap(hardwareMap);
        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("Step 0","Complete");
            telemetry.update();

            frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            // Determine new target position, and pass to motor controller
            newLeftTarget = (int) (leftInches * TICKS_PER_INCH);
            newRightTarget = (int) (rightInches * TICKS_PER_INCH);
            newRightTarget2 = (int) (rightInches2 * TICKS_PER_INCH);
            newLeftTarget2 = (int) (leftInches2 * TICKS_PER_INCH);

            telemetry.addData("Step 1", "Complete");
            telemetry.update();

            frontLeft.setTargetPosition(3000);
            frontRight.setTargetPosition(3000);
            backLeft.setTargetPosition(3000);
            backRight.setTargetPosition(3000);

            telemetry.addData("Step 2","Complete");
            telemetry.update();

            // Turn On RUN_TO_POSITION
            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            telemetry.addData("Step 3","Complete");
            telemetry.update();

            backLeft.setVelocity(100);
            frontLeft.setVelocity(backLeft.getVelocity());
            frontRight.setVelocity(backLeft.getVelocity());
            backRight.setVelocity(backLeft.getVelocity());

            telemetry.addData("Step 4","Complete");
            telemetry.update();

            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the robot will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the robot continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.
            while (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) {

                // Display it for the driver.
                telemetry.addData("Path1", "Running to %7d :%7d", newLeftTarget, newRightTarget);
                telemetry.addData("Path2", "Running at %7d :%7d",
                        frontLeft.getCurrentPosition(),
                        frontRight.getCurrentPosition());
                telemetry.update();
            }

            // Stop all motion;
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0);

            // Turn off RUN_TO_POSITION
            frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

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


