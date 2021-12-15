package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.Robot2;

public class slimeAutonRR extends LinearOpMode {

Robot2 robot = new Robot2();

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        while(opModeIsActive()) {
            // forward x inches
            robot.drivetrain.forward(24);
            // stop
            robot.drivetrain.stop();
            sleep(500);
            // turn left 90 degrees
            robot.drivetrain.pointTurnRight();
            // stop
            robot.drivetrain.stop();
            // forwad x inches
            robot.drivetrain.forward(12);
            // stop
            robot.drivetrain.stop();

        }
    }
}
