 package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.OpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.DcMotorSimple;
        import com.qualcomm.hardware.bosch.BNO055IMU;
        import com.qualcomm.robotcore.util.Range;
        import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;

        import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
        import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
        import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
        import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
        import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
        import org.firstinspires.ftc.robotcore.external.navigation.Position;
        import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
        import com.qualcomm.robotcore.hardware.GyroSensor;

        import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.DEGREES;


@TeleOp(name="TeleOp2")
public class Teleop2 extends OpMode {

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    public BNO055IMU imu;
    Orientation angle;
    Acceleration gravity;
    public GyroSensor gyroSensor;

    double driveTurn;
    double gamepadXCoordinate;
    double gamepadYCoordinate;
    double gamepadHypot;
    double gamepadDegree;
    double robotDegree;
    double movementDegree;
    double gamepadXControl;
    double gamepadYControl;


    @Override
    public void init() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        gyroSensor = hardwareMap.get(GyroSensor.class, "gyro");
        gyroSensor.calibrate();
        imu.initialize(parameters);

    }

    @Override
    public void loop() {

        imu.startAccelerationIntegration(new Position(), new Velocity(), 1000);
        driveTurn = -gamepad1.right_stick_x;

        gamepadXCoordinate = gamepad1.left_stick_x; //this simply gives our x value relative to the driver
        gamepadYCoordinate = -gamepad1.left_stick_y; //this simply gives our y vaue relative to the driver

        gamepadHypot = Range.clip(Math.hypot(gamepadXCoordinate, gamepadYCoordinate), -1, 1);
        //finds just how much power to give the robot based on how much x and y given by gamepad
        //range.clip helps us keep our power within positive 1
        // also helps set maximum possible value of 1/sqrt(2) for x and y controls if at a 45 degree angle (which yields greatest possible value for y+x)
        gamepadDegree = Math.atan2(gamepadYCoordinate, gamepadXCoordinate);
        //the inverse tangent of opposite/adjacent gives us our gamepad degree
        robotDegree = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.XZY, AngleUnit.DEGREES).firstAngle;
        //gives us the angle our robot is at ZXY
        movementDegree = gamepadDegree - robotDegree;
        //adjust the angle we need to move at by finding needed movement degree based on gamepad and robot angles
        gamepadXControl = Math.cos(Math.toRadians(movementDegree)) * gamepadHypot;
        //by finding the adjacent side, we can get our needed x value to power our motors
        gamepadYControl = Math.sin(Math.toRadians(movementDegree)) * gamepadHypot;
        //by finding the opposite side, we can get our needed y value to power our motors


        frontRight.setPower(gamepadYControl * Math.abs(gamepadYControl) - gamepadXControl * Math.abs(gamepadXControl) - driveTurn);
        backRight.setPower(gamepadYControl * Math.abs(gamepadYControl) + gamepadXControl * Math.abs(gamepadXControl) - driveTurn);
        frontLeft.setPower(gamepadYControl * Math.abs(gamepadYControl) + gamepadXControl * Math.abs(gamepadXControl) + driveTurn);
        backLeft.setPower(gamepadYControl * Math.abs(gamepadYControl) - gamepadXControl * Math.abs(gamepadXControl) + driveTurn);

        /*frontRight.setPower(gamepadYControl  - gamepadXControl  - driveTurn);
        backRight.setPower(gamepadYControl  + gamepadXControl - driveTurn);
        frontLeft.setPower(gamepadYControl  + gamepadXControl + driveTurn);
        backLeft.setPower(gamepadYControl   - gamepadXControl  + driveTurn);

         */

        telemetry.addData("heading = ", gyroSensor.getHeading());
        telemetry.addData("X = ", gyroSensor.rawX());
        telemetry.addData("Y = ", gyroSensor.rawY());
        telemetry.addData("Z = ", gyroSensor.rawZ());
        telemetry.update();
        //* Math.abs(gamepadYControl)


    }
}
