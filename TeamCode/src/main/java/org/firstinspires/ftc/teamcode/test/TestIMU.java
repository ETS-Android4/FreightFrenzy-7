package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.Robot2;

@Autonomous (name = "TestIMU", group = "PRTest")
public class TestIMU extends LinearOpMode {

    Robot2 prbot = new Robot2();
    @Override
    public void runOpMode() throws InterruptedException {
        prbot.init(hardwareMap, telemetry);

        waitForStart();
        while (opModeIsActive()) {
            prbot.imu.updateAngles();
            telemetry.addLine()
                    .addData("Heading", prbot.imu.getFirstAngle())
                    .addData("Roll", prbot.imu.getSecondAngle())
                    .addData("Pitch", prbot.imu.getThirdAngle());
        }
    }
}
