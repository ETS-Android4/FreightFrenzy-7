package org.firstinspires.ftc.teamcode.hardware;

public interface Constants {

    int STOP = 0;

    double forwardPos = 15 / 300.0;
    double neutralPos = 90 / 300.0;
    double backPos = 240 / 300.0;

    double bowlOne = 10;
    double bowlTwo = 20;
    double bowlThree = 30;

    // 96 mm wheels = 537.6/((120 / 25.4)*Math.PI)
    // 120 mm wheels = (537.6/((120 / 25.4)*Math.PI)) * (5.0/6.0)
    double TICKS_PER_IN = 537.6/((96 / 25.4)*Math.PI);

    int LIFT_THRESHOLD = -500;

    int MIN_LEVEL = -2;
    int MAX_LEVEL = 5;

    int LEVEL_SUBTWO = 0;
    int LEVEL_SUBONE = 0;

    int LEVEL_ZERO = 0;
//
    int LEVEL_ONE = 250;
    int LEVEL_TWO = 1400;
    int LEVEL_THREE = 0;

    int LEVEL_FOUR = 0;
    int LEVEL_FIVE = 0;

    enum Status {
        FORWARDS, BACKWARDS,
        UP, DOWN,
        LEFT, RIGHT,
        OPEN, CLOSE,
        NEUTRAL,
        NORTH, SOUTH, EAST, WEST,
        RED, GREEN, BLUE,
        DARK, LIGHT,
        NORMAL, AUTO;
    }
}
