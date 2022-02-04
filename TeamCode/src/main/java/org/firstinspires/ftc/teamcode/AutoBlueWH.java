package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "redWAREHOUSEfreightNpark")
public class AutoBlueWH extends LinearOpMode {
    RobotEncoded2 encoders = new RobotEncoded2();
    @Override
    public void runOpMode() throws InterruptedException {
        encoders.hardwareMap(hardwareMap);

        waitForStart();
        encoders.arm1();
        encoders.forward(37);
        encoders.turnLeft(16);
        encoders.outtake(2000);
        encoders.arm1();
        encoders.arm0();
        encoders.turnLeft(28);
        encoders.strafeRight(46);
        encoders.forward(50);
        encoders.intake(1500);
        encoders.arm3();
        encoders.backward(62);
        encoders.turnRight(16);
        encoders.forward(21);
        encoders.outtake (2000);

        encoders.turnRight(16);
        encoders.strafeRight(22);
        encoders.forward(62);
        encoders.strafeLeft(12);

        /*robot.hardwareMap(hardwareMap);

        //move to carousel
        robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.strafeRight(0.5);
        while (robot.frontRight.getCurrentPosition() <2500) {
            telemetry.addData("Robot is strafing", "True");
            telemetry.update();
        }
        robot.stop();

        //turn to position servo at carousel
        robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.turnRight(0.5);
        while (robot.frontRight.getCurrentPosition() > -1140) {
            telemetry.addData("Robot is moving", "True");
            telemetry.update();
        }
        robot.stop();

        //move carousel servo
        robot.moveCarousel(0.75);
        sleep(5000);
        robot.moveCarousel(0);

        //move to warehouse and park
        robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.forward(0.5);
        while (robot.frontRight.getCurrentPosition() < -2650) {
            telemetry.addData("Robot is moving", "True");
            telemetry.update();
        }
        robot.stop();

        robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.strafeRight(0.5);
        while (robot.frontRight.getCurrentPosition() < 780) {
            telemetry.addData("Robot is moving", "True");
            telemetry.update();
        }
        robot.stop();

        robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.forward(0.5);
        while (robot.frontRight.getCurrentPosition() < 400) {
            telemetry.addData("Robot is moving", "True");
            telemetry.update();
        }
        robot.stop();

        //autonomous complete
        telemetry.addData("run", "completed");
        telemetry.update();
    }
}
*/
    }
}
