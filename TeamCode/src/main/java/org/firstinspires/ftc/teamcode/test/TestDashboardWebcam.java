package org.firstinspires.ftc.teamcode.test;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.hardware.Barcode;
import org.firstinspires.ftc.teamcode.hardware.Constants;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;

@Disabled
@Autonomous (name = "TestDasboardWebcam")
public class TestDashboardWebcam extends LinearOpMode {

    OpenCvCamera webcam;

    Barcode pipeline = new Barcode(telemetry, Constants.StartPos.REDLEFT);

    @Override
    public void runOpMode() throws InterruptedException {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "webcam 1"), cameraMonitorViewId);

        webcam.setPipeline(pipeline);
        waitForStart();
        FtcDashboard.getInstance().startCameraStream(webcam, 0);

        while (opModeIsActive()) {

        }
    }
}
