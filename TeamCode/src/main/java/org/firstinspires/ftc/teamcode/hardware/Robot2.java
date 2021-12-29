package org.firstinspires.ftc.teamcode.hardware;


import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot2 {

    public DrivetrainJ drivetrain;
    public Intake intake;
    public Outtake2 outtake;
    public Lift lift;
    public Carousel carousel;
    public IMU imu;


    public void init(HardwareMap hwMap, Telemetry telemetry) {
        drivetrain = new DrivetrainJ(hwMap.dcMotor.get("frontLeft"), hwMap.dcMotor.get("frontRight"), hwMap.dcMotor.get("backLeft"), hwMap.dcMotor.get("backRight"));
        intake = new Intake(hwMap.dcMotor.get("intake"));
        outtake = new Outtake2(hwMap.servo.get("outtake"));
        lift = new Lift(hwMap.dcMotor.get("lift"));
        carousel = new Carousel(hwMap.dcMotor.get("leftCarousel"), hwMap.dcMotor.get("rightCarousel"));
        imu = new IMU(hwMap.get(BNO055IMU.class, "imu 1"));

        lift.init();
        lift.setTelemetry(telemetry);
        lift.useEncoders(true);
        lift.useBrake(true);
        lift.setMaxPower(.3);
    }


}



