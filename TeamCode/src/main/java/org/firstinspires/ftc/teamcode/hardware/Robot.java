package org.firstinspires.ftc.teamcode.hardware;


import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot implements Constants {

    public Drivetrain drivetrain;
    public Intake intake;
    public Outtake outtake;
    public Lift lift;
    public Carousel carousel;
    public IMU imu;

    public void init(HardwareMap hwMap, Telemetry telemetry) {
        drivetrain = new Drivetrain(hwMap.dcMotor.get("frontLeft"), hwMap.dcMotor.get("frontRight"), hwMap.dcMotor.get("backLeft"), hwMap.dcMotor.get("backRight"));
        intake = new Intake(hwMap.dcMotor.get("intake"));
        outtake = new Outtake(hwMap.servo.get("outtake"));
        lift = new Lift(hwMap.dcMotor.get("lift"));
        carousel = new Carousel(hwMap.dcMotor.get("leftCarousel"), hwMap.dcMotor.get("rightCarousel"));
        imu = new IMU(hwMap.get(BNO055IMU.class, "imu 1"));
        lift.setTelemetry(telemetry);
        drivetrain.setTelemetry(telemetry);
    }

    public void setMode(Status mode) {
        switch (mode) {
            case NORMAL:
                drivetrain.useBrake(true);
                outtake.neutralPosition();
                lift.init();
                lift.useEncoders(true);
                lift.useBrake(true);
                lift.setMaxPower(.5);
                break;
            case AUTO:
                drivetrain.setPower(.4);
                drivetrain.useBrake(true);
                outtake.neutralPosition();
                lift.init();
                lift.useEncoders(true);
                lift.useBrake(true);
                lift.setMaxPower(.3);
                break;
            case SLOW:
                drivetrain.useBrake(true);
                outtake.neutralPosition();
                lift.init();
                lift.useEncoders(true);
                lift.useBrake(true);
                lift.setMaxPower(.3);
                break;
            case FAST:
                drivetrain.useBrake(true);
                outtake.neutralPosition();
                lift.init();
                lift.useEncoders(true);
                lift.useBrake(true);
                lift.setMaxPower(.8);
                break;
        }
    }
}



