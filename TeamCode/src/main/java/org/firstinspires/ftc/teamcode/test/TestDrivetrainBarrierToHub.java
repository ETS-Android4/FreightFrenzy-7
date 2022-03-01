package org.firstinspires.ftc.teamcode.test;

import android.icu.text.Transliterator;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.Constants;
import org.firstinspires.ftc.teamcode.hardware.Controller;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Robot;

@TeleOp (name = "TestDrivetrainBarrierToHub", group = "Test")
public class TestDrivetrainBarrierToHub extends LinearOpMode {
    Robot prbot = new Robot();
    Controller c;
    boolean isRed = false;
    boolean toggle = false;
    @Override
    public void runOpMode() throws InterruptedException {
        prbot.init(hardwareMap, telemetry);
        prbot.setMode(Constants.Status.NORMAL);

        c = new Controller(gamepad1, gamepad2);

        telemetry.setMsTransmissionInterval(20);

        waitForStart();

        while (opModeIsActive()) {
            c.updateInputs();

            switch (prbot.drivetrain.getState()) {
                case NEUTRAL:
                    // shouldn't do anything
                    if (c.x.isPressed()) {
                        // Goes forward, out of the barrier
                        prbot.drivetrain.setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
                        prbot.drivetrain.setRunMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        prbot.drivetrain.setTargetPos(Constants.BARRIER_FORWARD, Constants.BARRIER_FORWARD, Constants.BARRIER_FORWARD, Constants.BARRIER_FORWARD);
                        prbot.drivetrain.setRunMode(DcMotor.RunMode.RUN_TO_POSITION);
                        prbot.drivetrain.setBase(-.5);
                        prbot.drivetrain.setState(Drivetrain.DrivetrainState.START);
                        //toggle = !toggle;
                    }
                    break;
                case START:
                    // The first turn, away from the hub
                    if (!prbot.drivetrain.anyBusy()) {
                        prbot.drivetrain.setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
                        prbot.drivetrain.setRunMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        //prbot.drivetrain.setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
                        prbot.drivetrain.stop();
                        prbot.drivetrain.setTargetPos(Constants.TURN_ONE, Constants.TURN_ONE, Constants.TURN_ONE, Constants.TURN_ONE);
                        prbot.drivetrain.setRunMode(DcMotor.RunMode.RUN_TO_POSITION);
                        if (isRed) {
                            prbot.drivetrain.setLeftSide(-.5, -.5);
                        } else {
                            prbot.drivetrain.setRightSide(-.5, -.5);
                        }
                        prbot.drivetrain.setState(Drivetrain.DrivetrainState.TURN_ONE);

                    }
                    break;
                case TURN_ONE:
                    // The second turn, towards the hub
                    if (!prbot.drivetrain.anyBusy()) {
                        toggle = !toggle;
                        prbot.drivetrain.setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
                        prbot.drivetrain.setRunMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        prbot.drivetrain.stop();
                        prbot.drivetrain.setTargetPos(Constants.TURN_TWO, Constants.TURN_TWO, Constants.TURN_TWO, Constants.TURN_TWO);
                        prbot.drivetrain.setRunMode(DcMotor.RunMode.RUN_TO_POSITION);
                        if (isRed) {
                            prbot.drivetrain.setRightSide(-.5, -.5);
                        } else {
                            prbot.drivetrain.setLeftSide(-.5, -.5);
                        }
                        prbot.drivetrain.setState(Drivetrain.DrivetrainState.TURN_TWO);
                    }
                    break;
                case TURN_TWO:
                    // Needs to go forward a little bit to reach the hub
                    if (!prbot.drivetrain.anyBusy()) {
                        prbot.drivetrain.setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
                        prbot.drivetrain.setRunMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        prbot.drivetrain.setTargetPos(Constants.HUB_FORWARD, Constants.HUB_FORWARD, Constants.HUB_FORWARD, Constants.HUB_FORWARD);
                        prbot.drivetrain.setRunMode(DcMotor.RunMode.RUN_TO_POSITION);
                        prbot.drivetrain.setBase(-.5);
                        //prbot.drivetrain.stop();
                        prbot.drivetrain.setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
                        prbot.drivetrain.setState(Drivetrain.DrivetrainState.END);
                    }
                    break;
                case END:
                    if (!prbot.drivetrain.anyBusy()) {
                        prbot.drivetrain.setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
                        prbot.drivetrain.setRunMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        prbot.drivetrain.stop();
                        prbot.drivetrain.setState(Drivetrain.DrivetrainState.NEUTRAL);
                    }
                    break;
                default:
                    prbot.drivetrain.setState(Drivetrain.DrivetrainState.NEUTRAL);
            }
            telemetry.addData("fL pow", prbot.drivetrain.getFrontLeft().getPower());
            telemetry.addData("fR pow", prbot.drivetrain.getFrontRight().getPower());
            telemetry.addData("bL pow", prbot.drivetrain.getBackLeft().getPower());
            telemetry.addData("BR pow", prbot.drivetrain.getBackRight().getPower());
            telemetry.addData("fL pos", prbot.drivetrain.getFrontLeft().getCurrentPosition());
            telemetry.addData("fR pos", prbot.drivetrain.getFrontRight().getCurrentPosition());
            telemetry.addData("bL pos", prbot.drivetrain.getBackLeft().getCurrentPosition());
            telemetry.addData("bR pos", prbot.drivetrain.getBackRight().getCurrentPosition());
            telemetry.addData("state", prbot.drivetrain.getState().toString());
            telemetry.addData("toggle", toggle);
            telemetry.addData("x", gamepad1.x);
            telemetry.addData("anyBusy", prbot.drivetrain.anyBusy());
            telemetry.update();
        }
    }
}
