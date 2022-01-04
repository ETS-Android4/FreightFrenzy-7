package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.Constants;
import org.firstinspires.ftc.teamcode.hardware.Robot;

@Autonomous (name = "Turn90IMU", group = "PRTest")
public class Turn90IMU extends LinearOpMode {

    Robot prbot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {
        prbot.init(hardwareMap, telemetry);
        telemetry.setMsTransmissionInterval(50);

        waitForStart();

        while (opModeIsActive()) {
            while (prbot.imu.getFirstAngleNum() < 90) {
                prbot.imu.updateAngles();
                prbot.drivetrain.pivotTurn(Constants.Status.LEFT);
            }
            prbot.imu.updateAngles();
            prbot.drivetrain.stop();
            break;
        }
    }
}
