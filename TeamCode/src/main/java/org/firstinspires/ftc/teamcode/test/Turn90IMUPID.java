package org.firstinspires.ftc.teamcode.test;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardware.Button;
import org.firstinspires.ftc.teamcode.hardware.Constants;
import org.firstinspires.ftc.teamcode.hardware.PIDController;
import org.firstinspires.ftc.teamcode.hardware.Robot;

@Config
@Autonomous (name = "Turn90IMUPID", group = "PRTest")
public class Turn90IMUPID extends LinearOpMode {

    Robot prbot = new Robot();

    PIDController turnPID;

    Button a;

    boolean toggle = false;

    public static double P = 0.1;
    public static double I = 0.01;
    public static double D = 0;

    public static double targetAngle = 90;

    @Override
    public void runOpMode() throws InterruptedException {
        prbot.init(hardwareMap, telemetry);
        prbot.setMode(Constants.Status.AUTO);

        a = new Button();

        FtcDashboard dashboard = FtcDashboard.getInstance();

        Telemetry telem = dashboard.getTelemetry();

        prbot.drivetrain.setTelemetry(telem);

        waitForStart();

        while (opModeIsActive()) {
            a.previous();
            a.setState(gamepad1.a);

            if (a.isPressed()) toggle = !toggle;

            if (toggle) {
                prbot.drivetrain.PIDTurn(targetAngle, new PIDController(P, I, D, 20));
                sleep(2000);
            }
        }
    }
}
