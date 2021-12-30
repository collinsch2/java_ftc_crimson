package org.firstinspires.ftc.teamcode;

import com.google.gson.FieldAttributes;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.vuforia.HINT;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.ClassFactory;

@Autonomous(name = "Vuforia")
public class CrimVuforia extends LinearOpMode
{
    // Variables to be used for later
    private VuforiaLocalizer vuforiaLocalizer;
    private VuforiaLocalizer.Parameters parameters;
    private VuforiaTrackables visionTargets;
    private VuforiaTrackable target;
    private VuforiaTrackableDefaultListener wheelListener;

    private OpenGLMatrix lastKnownLocation;
    private OpenGLMatrix webcamLocation;

    private static final String VUFORIA_KEY = "AcTcWzH/////AAABmRZzoPbpRUDTrZOQJsPdfgAmVO9oOthVYlDFc04vu8+t+m18E8Ee3vLgLIT8y5RhoWGwG3tA2BtaA/3ANMMchxJG5ppxfrv6k5b2jSiBxu5SSNhdm3hZfwv5LQMs3K8UHnIeZnD6dLF3gkpPwv/p94X60PfZsteVR6LcCn8sXsTqBDwoWRBesa1vzTAChqv+qpVUeTHSmImjwfqwFJByr5eKujlEYIpYlYOfDGIDS1DTt44O7/lMY+9LTq7Hj8szzAnU2u9nXcXjgyUEgjdbqvmA1sU6vDlmMzvV+5r2qOiKciPmym/AE0eSR256bHpx7dkeNc1mKizaXeGCYvuwy9giiffsaNzGSXTwvjuP1Eyy";

    private float robotX = 0;
    private float robotY = 0;
    private float robotAngle = 0;
    Robot robot = new Robot();

    public void runOpMode() throws InterruptedException
    {
        lastKnownLocation = createMatrix(0, 0, 0, 0, 0, 0);

        waitForStart();

        // Start tracking the targets
        visionTargets.activate();

        while(opModeIsActive())
        {
            setupVuforia();

            // Ask the listener for the latest information on where the robot is
            OpenGLMatrix latestWheelLocation = wheelListener.getUpdatedRobotLocation();
           // OpenGLMatrix latestToolsLocation = toolsListener.getUpdatedRobotLocation();
            OpenGLMatrix latestLegosLocation = wheelListener.getUpdatedRobotLocation();
            OpenGLMatrix latestGearsLocation = wheelListener.getUpdatedRobotLocation();


            // The listener will sometimes return null, so we check for that to prevent errors
           // if(latestLocation != null)
            //    lastKnownLocation = latestLocation;

            float[] coordinates = lastKnownLocation.getTranslation().getData();

            robotX = coordinates[0];
            robotY = coordinates[1];
            robotAngle = Orientation.getOrientation(lastKnownLocation, AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES).thirdAngle;

            // Send information about whether the target is visible, and where the robot is
            FieldAttributes wheelTarget;
          //  telemetry.addData("Tracking " + wheelTarget.getName(), wheelListener.isVisible());
            telemetry.addData("Last Known Location", formatMatrix(lastKnownLocation));

            // Send telemetry and idle to let hardware catch up
            telemetry.update();
            idle();
/*
            if (wheelListener.IsVisible) {
                robot.move(-50, 50, 0);
                while (robotY < 700) {
                    sleep(100);
                }
                stop();
                //use arm to load storage Units
                robot.move(-50, 0, 0);
                while (robotX < 500) {
                    sleep(100);
                }
            }

            if (toolsListener.IsVisible) {
                robot.move(-50, 50, 0);
                while (robotY < 700) {
                    sleep(100);
                }
                stop();
                //use arm to load storage Units
                robot.move(-50, 0, 0);
                while (robotX < 500) {
                    sleep(100);
                }
            }

            if (legosListener.IsVisible) {
                robot.move(-50, 50, 0);
                while (robotY < 700) {
                    sleep(100);
                }
                stop();
                //use arm to load storage Units
                robot.move(-50, 0, 0);
                while (robotX < 500) {
                    sleep(100);
                }
            }

            if (gearsListener.IsVisible) {
                robot.move(-50, 50, 0);
                while (robotY < 700) {
                    sleep(100);
                }
                stop();
                //use arm to load storage Units
                robot.move(-50, 0, 0);
                while (robotX < 700) {
                    sleep(100);
                }
            } */


        }
    }



    private void setupVuforia() {
        WebcamName webcamName = hardwareMap.get(WebcamName.class,"webcam");
        float mmPerInch        = 25.4f;
        float mmBotWidth       = 18 * mmPerInch; //change
        float mmFTCFieldWidth  = (12*12 - 2) * mmPerInch;

        // Setup parameters to create localizer
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        //parameters.cameraDirection = CameraDirection.BACK;
        parameters.cameraName = webcamName;
        parameters.useExtendedTracking = false;
        vuforiaLocalizer = ClassFactory.createVuforiaLocalizer(parameters);
        /*VuforiaLocalizer myVuforia = ClassFactory.getInstance().createVuforia(parameters);*/

        // These are the vision targets that we want to use
        // The string needs to be the name of the appropriate .xml file in the assets folder
        visionTargets = vuforiaLocalizer.loadTrackablesFromAsset("FTC_2016-17");
        Vuforia.setHint(HINT.HINT_MAX_SIMULTANEOUS_IMAGE_TARGETS, 4);

        webcamLocation = createMatrix(0, mmBotWidth/2, 0, 90, 0, 180); // Set webcam location on robot

        /*target*/VuforiaTrackable wheelTarget = visionTargets.get(0); // Setup the target to be tracked
        wheelTarget.setName("Wheels Target");
        wheelTarget.setLocation(createMatrix(0, 3581, 0, 90, 0, 0));
        wheelListener = (VuforiaTrackableDefaultListener) wheelTarget.getListener(); // Setup listener and inform it of webcam information
        assert parameters.cameraName != null;
        wheelListener.setCameraLocationOnRobot(parameters.cameraName, webcamLocation);

        VuforiaTrackable toolsTarget = visionTargets.get(1);
        toolsTarget.setName("Tools Target");
        toolsTarget.setLocation(createMatrix(0, 3581, 0, 90, 0, 0));
        VuforiaTrackableDefaultListener toolsListener = (VuforiaTrackableDefaultListener) toolsTarget.getListener();
        assert parameters.cameraName != null;
        toolsListener.setCameraLocationOnRobot(parameters.cameraName, webcamLocation);

        VuforiaTrackable legosTarget = visionTargets.get(2);
        legosTarget.setName("Legos Target");
        legosTarget.setLocation(createMatrix(0, 3581, 0, 90, 0, 0));
        VuforiaTrackableDefaultListener legosListener = (VuforiaTrackableDefaultListener) legosTarget.getListener();
        assert parameters.cameraName != null;
        legosListener.setCameraLocationOnRobot(parameters.cameraName, webcamLocation);


        VuforiaTrackable gearsTarget = visionTargets.get(3);
        gearsTarget.setName("Gears Target");
        gearsTarget.setLocation(createMatrix(0, 3581, 0, 90, 0, 0));
        VuforiaTrackableDefaultListener gearsListener = (VuforiaTrackableDefaultListener) gearsTarget.getListener();
        assert parameters.cameraName != null;
        gearsListener.setCameraLocationOnRobot(parameters.cameraName, webcamLocation);

    }

    // Creates a matrix for determining the locations and orientations of objects
    // Units are millimeters for x, y, and z, and degrees for u, v, and w
    private OpenGLMatrix createMatrix(float x, float y, float z, float u, float v, float w)
    {
        return OpenGLMatrix.translation(x, y, z).
                multiplied(Orientation.getRotationMatrix(
                        AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES, u, v, w));
    }

    // Formats a matrix into a readable string
    private String formatMatrix(OpenGLMatrix matrix)
    {
        return matrix.formatAsTransform();
    }


}