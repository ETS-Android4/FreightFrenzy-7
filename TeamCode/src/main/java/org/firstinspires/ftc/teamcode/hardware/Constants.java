package org.firstinspires.ftc.teamcode.hardware;

public interface Constants {
//nuts
    int STOP = 0;

    double forwardPos = 0 / 300.0;
    double neutralPos = 90 / 300.0;
    double backPos = 225 / 300.0;

    // 96 mm wheels = 537.6/((120 / 25.4)*Math.PI)
    // 120 mm wheels = (537.6/((120 / 25.4)*Math.PI)) * (5.0/6.0)
    //double TICKS_PER_IN = 537.6/((96 / 25.4)*Math.PI);

    double TICKS_PER_IN = (537.6/((120 / 25.4)*Math.PI));

    int LIFT_THRESHOLD = -500;

    int MIN_LEVEL = -2;
    int MAX_LEVEL = 5;

    int LEVEL_SUBTWO = 0;
    int LEVEL_SUBONE = 0;

    int LEVEL_ZERO = 50;

    int LEVEL_ONE = 700;
    int LEVEL_TWO = 1600;
    int LEVEL_THREE = 1100;

    int LEVEL_FOUR = 0;
    int LEVEL_FIVE = 0;

    int SPIN_TIME = 1400;
    int DUMP_TIME = 500;
    int RETRACT_TIMEOUT = 3000;

    // 250
    // 1.05
    // -0.5
    double SPIN_RATE_MS = 125;
    double SPIN_RATE_MULT = 1.15;
    double SPIN_RATE_START = -0.5;

    /*
        barcode[0]: redLeft
        barcode[1]: redRight
        barcode[2]: blueLeft
        barcode[3]: blueRight
        barcode[i][0] / barcode[i][1]: BarcodePosition.LEFT coordinates x/y
        barcode[i][2] / barcode[i][3]: BarcodePosition.CENTER coordinates x/y
        barcode[i][4] / barcode[i][5]: BarcodePosition.RIGHT coordinates x/y
    */

    int[][] barcodeCoordinate = {
            {
               12 + 80, 140,
               110 + 80, 140,
               215 + 80, 140
            }, {
                90, 140,
                195, 140,
                290, 140
            }, {
                25, 140,
                115, 140,
                215, 140
            }, {
                12, 140,
                110, 140,
                215, 140
            }
    };

    enum StartPos {
        REDLEFT, REDRIGHT,
        BLUELEFT, BLUERIGHT
    }

    enum Status {
        FORWARDS, BACKWARDS,
        UP, DOWN,
        LEFT, RIGHT,
        OPEN, CLOSE,
        NEUTRAL,
        NORTH, SOUTH, EAST, WEST,
        RED, GREEN, BLUE,
        DARK, LIGHT,
        NORMAL, AUTO, SLOW, FAST;
    }
}
