package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.Robot2;

public class slimeAutonRL extends LinearOpMode {

Robot2 robot = new Robot2();

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        while(opModeIsActive()) {
            //move forward
            robot.drivetrain.forward(12);
            //stop
            robot.drivetrain.stop();
            //turn right
            robot.drivetrain.pointTurnLeft();
            //stop
            robot.drivetrain.stop();
            //position at carousel
            robot.drivetrain.forward(30);
            //stop
            robot.drivetrain.stop();
            //spin carousel
            robot.carousel.leftSpin(.3);
            sleep(2500);
            //turn and park in box
            robot.drivetrain.backward(18);


        }
    }
}
