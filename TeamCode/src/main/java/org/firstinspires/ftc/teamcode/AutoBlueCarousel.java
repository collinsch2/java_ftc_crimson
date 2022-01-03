package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "TestBC")
public class AutoBlueCarousel extends LinearOpMode {
    Robot robot = new Robot();

    @Override
    public  void runOpMode() throws InterruptedException {
        waitForStart();
        robot.hardwareMap(hardwareMap);
        //BLUE DOWN
        //face the shipping hub
        robot.turnLeft(0.7);
        sleep(1000);

        //go towards shipping hub
        robot.forward(0.7);
        sleep(1000);

        //arm puts the box in the shipping hub

        //turn towards the carousel
        robot.turnRight(0.7);
        sleep(1500);

        //move towards the carousel
        robot.forward(0.7);
        sleep(5000);

        //align with carousel
        robot.turnRight(0.7);
        sleep(1000);

        //carousel

        robot.forward(0.7);
        sleep(10000);

    }
}
