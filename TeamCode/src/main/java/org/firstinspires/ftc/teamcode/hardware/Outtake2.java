package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.Servo;

public class Outtake2 implements Constants {
    private Servo outtake2;

    public Outtake2(Servo s) {this.outtake2 = s;}

    public void neutralPosition() {
            outtake2.setPosition(neutralPos);
    }

    public void backPosition() {
        outtake2.setPosition(backPos);
    }

    public void forwardPosition() {
        outtake2.setPosition(forwardPos);
    }

    public Servo getOuttake2() {
        return outtake2;
    }
}
