package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "TestBC")
public class AutoBlueCarousel extends LinearOpMode {
    Robot robot = new Robot();
    RobotEncoded2 encoders = new RobotEncoded2();
    CrimTensorFlow crimtfod = new CrimTensorFlow();

    public void telemetryLoop(){
        while (encoders.frontRight.isBusy() && encoders.frontLeft.isBusy() && encoders.backLeft.isBusy() && encoders.backRight.isBusy()) {
            telemetry.addData("Wheels", "are busy");
            telemetry.addData("Front right velocity is", encoders.frontRight.getVelocity());
            telemetry.addData("Front left velocity is", encoders.frontLeft.getVelocity());
            telemetry.addData("Back left velocity is", encoders.backLeft.getVelocity());
            telemetry.addData("Back right velocity is", encoders.backRight.getVelocity());
            telemetry.update();
        }
    }

    @Override
    public  void runOpMode() throws InterruptedException {

        encoders.hardwareMap(hardwareMap);
        waitForStart();

        encoders.setDistance(5);
        encoders.forward(200);
        telemetryLoop();
        encoders.stop();


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
