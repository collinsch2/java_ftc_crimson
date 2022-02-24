package org.firstinspires.ftc.teamcode.drive.advanced;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

/**
 * This opmode demonstrates how one would implement field centric control using
 * `SampleMecanumDrive.java`. This file is essentially just `TeleOpDrive.java` with the addition of
 * field centric control. To achieve field centric control, the only modification one needs is to
 * rotate the input vector by the current heading before passing it into the inverse kinematics.
 * <p>
 * See lines 42-57.
 */
@TeleOp(group = "advanced")
public class TeleOpFieldCentric extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize SampleMecanumDrive
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        // We want to turn off velocity control for teleop
        // Velocity control per wheel is not necessary outside of motion profiled auto
        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Retrieve our pose from the PoseStorage.currentPose static field
        // See AutoTransferPose.java for further details
        drive.setPoseEstimate(PoseStorage.currentPose);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive() && !isStopRequested()) {
            // Read pose
            Pose2d poseEstimate = drive.getPoseEstimate();

            // Create a vector from the gamepad x/y inputs
            // Then, rotate that vector by the inverse of that heading
            Vector2d input = new Vector2d(
                    -gamepad1.left_stick_y,
                    -gamepad1.left_stick_x
            ).rotated(-poseEstimate.getHeading());

            // Pass in the rotated input + right stick value for rotation
            // Rotation is not part of the rotated input thus must be passed in separately
            drive.setWeightedDrivePower(
                    new Pose2d(
                            input.getX(),
                            input.getY(),
                            -gamepad1.right_stick_x
                    )
            );

            // Update everything. Odometry. Etc.
            drive.update();

            // Print pose to telemetry
            telemetry.addData("x", poseEstimate.getX());
            telemetry.addData("y", poseEstimate.getY());
            telemetry.addData("heading", poseEstimate.getHeading());
            telemetry.update();

            double armVelocity = 1500;
            if (gamepad2.x) { //default
                drive.intakeArm.setTargetPosition(-80);
                drive.intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
                drive.intakeArm.setVelocity(1000);

            }

            if (gamepad2.y) { //level 1
                drive.intakeArm.setTargetPosition(-168);
                //-70
                drive.intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
                drive.intakeArm.setVelocity(armVelocity);


            }

            if (gamepad2.b) {// level 2
                drive.intakeArm.setTargetPosition(-342);
                //-120
                drive.intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
                drive.intakeArm.setVelocity(armVelocity);

            }

            if (gamepad2.a) {// level 3
                drive.intakeArm.setTargetPosition(-590);
                //-590
                drive.intakeArm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
                drive.intakeArm.setVelocity(armVelocity);

            }

            if(gamepad2.left_stick_y > 0.3){ // up
                drive.intakeArm.setTargetPosition(drive.intakeArm.getCurrentPosition() + 20);
                drive.intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                drive.intakeArm.setVelocity(armVelocity);
            }

            if(gamepad2.dpad_up){ // up
                drive.intakeArm.setTargetPosition(drive.intakeArm.getCurrentPosition() - 20);
                drive.intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                drive.intakeArm.setVelocity(armVelocity);
            }

            if(gamepad2.left_stick_y < -0.3){ // down
                drive.intakeArm.setTargetPosition(drive.intakeArm.getCurrentPosition() - 20);
                drive.intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                drive.intakeArm.setVelocity(armVelocity);
            }

            if(gamepad2.dpad_down){ // down
                drive.intakeArm.setTargetPosition(drive.intakeArm.getCurrentPosition() + 20);
                drive.intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                drive.intakeArm.setVelocity(armVelocity);
            }

            //rotate the carousel
            double carouselPower = 1; //needs to be low bc motor moves faster than servo

            if (gamepad1.b) {//red
                drive.carouselMotor.setPower(carouselPower);
                telemetry.addData("Carousel moving clockwise", "true");
                telemetry.update();
            }
            else if (gamepad1.x) {//blue
                drive.carouselMotor.setPower(-carouselPower);
                telemetry.addData("Carousel moving counter-clockwise", "true");
                telemetry.update();
            } else {
                drive.carouselMotor.setPower(0);
                telemetry.addData("Carousel is stopped", "true");
                telemetry.update();
            }

            //Intake movement
            //double intakePower = 0.75;

            if (gamepad2.right_trigger > 0.3) {
                drive.intakeMotor.setPower(0.9);
                telemetry.addData("Intake moving inwards", "true");
                telemetry.update();
            }
            else if (gamepad2.left_trigger > 0.3) {
                drive.intakeMotor.setPower(-0.5);
                telemetry.addData("Intake moving outwards", "true");
                telemetry.update();
            } else {
                drive.intakeMotor.setPower(0);
                telemetry.addData("Intake stopped", "true");
                telemetry.update();
            }
        }
    }
}
