package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.Drivetrain;

@Autonomous (name = "Drivetrain Test", group = "PRTest")
@Disabled
public class TestDrivetrain extends LinearOpMode {

    Drivetrain move;

    @Override
    public void runOpMode() throws InterruptedException {
        move = new Drivetrain(hardwareMap.dcMotor.get("frontLeft"),
                hardwareMap.dcMotor.get("frontRight"),
                hardwareMap.dcMotor.get("backLeft"),
                hardwareMap.dcMotor.get("backRight"));

        waitForStart();

        move.forward(.3);
        sleep(1000);

        move.backward(.3);
        sleep(1000);

    }
}
