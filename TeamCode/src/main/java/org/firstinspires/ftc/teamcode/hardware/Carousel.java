package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
* Author: Slimeafro
* Date: 10.12.21
* System: Carousel
*/

//Essentially an exact replica of the lift system with different variable and method names

public class Carousel {

   private DcMotor leftCarousel, rightCarousel;

   public Carousel(DcMotor Lc, DcMotor Rc) {
       this.leftCarousel = Lc ;
       this.rightCarousel = Rc ;
   }

   //Different spins depending on what side of the field we are on

   public void rightSpin(double rotation) {
       rightCarousel.setPower(rotation);
   }

   public void leftSpin (double rotation) {
       leftCarousel.setPower(-rotation);
   }

   public void stopSpin () {
       spin(0);
   }

   public void spin(double c) {
       leftCarousel.setPower(c);
       rightCarousel.setPower(c);
   }
}
