import TI.BoeBot;
import TI.Servo;
import TI.Timer;

public class ServoMethods {

    private Servo s1;
    private Servo s2;

    public ServoMethods(int servo1, int servo2) {
        this.s1 = new Servo(servo1);                                            //turns counterclockwise
        this.s2 = new Servo(servo2);                                            //turns clockwise
    }

    public void goToSpeed(int speed) {
        if (speed >= 1500) {                                                    //increase speed forwards
            while (this.s2.getPulseWidth() <= speed) {
                this.s1.update(this.s1.getPulseWidth() - 1);
                this.s2.update(this.s2.getPulseWidth() + 1);
                BoeBot.wait(10);
            }
        }
        if (speed <= 1500) {                                                    //increase speed backwards
            while (this.s1.getPulseWidth() >= speed) {
                this.s1.update(this.s1.getPulseWidth() + 1);
                this.s2.update(this.s2.getPulseWidth() - 1);
                BoeBot.wait(10);
            }
        }
        if (speed == 0) {                                                       //decrease speed to 1500
            if (this.s2.getPulseWidth() > 1500) {
                while (this.s2.getPulseWidth() > 1500) {
                    this.s1.update(this.s1.getPulseWidth() + 1);
                    this.s2.update(this.s2.getPulseWidth() - 1);
                    BoeBot.wait(10);
                }
            } else {
                while (this.s1.getPulseWidth() < 1500) {                        //increase speed to 1500
                    this.s1.update(this.s1.getPulseWidth() - 1);
                    this.s2.update(this.s2.getPulseWidth() + 1);
                    BoeBot.wait(10);
                }
            }
        }
    }

    public void emegencyBreak() {                                               //both servos to 1500
        this.s1.update(1500);
        this.s2.update(1500);
    }

    public void turn(int degrees) {
        if (degrees >= -180 && degrees <= 180 && degrees != 0) {
            int currentSpeedL = this.s2.getPulseWidth();
            int currentSpeedR = this.s1.getPulseWidth();

            if (degrees > 0) {                                                  //turn to the right
                this.s1.update(1500);
                double part = degrees / 180.0;
                int time = (int) Math.round(5000 * part);
                System.out.println(time);
                Timer timer = new Timer(time);
                while (true) {
                    this.s2.update(1600);
                    if (timer.timeout()) {
                        System.out.println("stop");
                        break;
                    }
                }
                this.s2.update(currentSpeedL);
                this.s1.update(currentSpeedR);
            }

            if (degrees < 0) {                                                     //turn to the left
                this.s2.update(1500);
                double part = Math.abs(degrees) / 180.0;
                int time = (int) Math.round(5000 * part);
                Timer timer = new Timer(time);
                System.out.println(time);
                while (true) {
                    this.s1.update(1400);
                    if (timer.timeout()) {
                        break;
                    }
                }
                this.s2.update(currentSpeedL);
                this.s1.update(currentSpeedR);
            }
        }
    }
}




