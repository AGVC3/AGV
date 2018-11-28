import TI.BoeBot;
import TI.Servo;
import TI.Timer;

public class ServoMethods implements Updateble {

    private Servo leftServo;
    private Servo rightServo;

    private int currentSpeedL;
    private int currentSpeedR;

    public ServoMethods() {
        this.leftServo = new Servo(12);                                            //turns counterclockwise
        this.rightServo = new Servo(13);                                            //turns clockwise
    }

    public void update() {
        this.rightServo.update(3000 - this.currentSpeedR);
        this.leftServo.update(this.currentSpeedL);
    }

    public void goToSpeed(int speed) {
        int accelaration = 20;
        if (speed > this.currentSpeedL) {
            this.currentSpeedR = this.currentSpeedL;
            this.currentSpeedL += accelaration;
            this.currentSpeedR += accelaration;
        } else if (speed < this.currentSpeedL) {
            this.currentSpeedR = this.currentSpeedL;
            this.currentSpeedL -= accelaration;
            this.currentSpeedR -= accelaration;
        }

//        if (speed < 1500 && speed != 0) {                                                    //increase speed backwards
//            while (this.leftServo.getPulseWidth() >= speed) {
//                this.leftServo.update(this.leftServo.getPulseWidth() + 1);
//                this.rightServo.update(this.rightServo.getPulseWidth() - 1);
//                BoeBot.wait(10);
//            }
//        }
    }

    public Servo getleftServo() {
        return leftServo;
    }

    public Servo getrightServo() {
        return rightServo;
    }

    public void setCurrentSpeedL(int currentSpeedL) {
        this.currentSpeedL = currentSpeedL;
    }

    public void setCurrentSpeedR(int currentSpeedR) {
        this.currentSpeedR = currentSpeedR;
    }

    public void stop() {                                               //both servos to 1500
        this.currentSpeedR = 1500;
        this.currentSpeedL = 1500;
    }

    public void turnWhileDriving(int direction) {
        if (direction == 1) {                                                   //Goes right
            this.currentSpeedR -= 75;
        } else if (direction == -1) {
            this.currentSpeedL -= 75;
        }
    }

    public void achtjedraaien() {
        turn(1);
        turn(1);
        turn(1);
        turn(1);
        turn(1);


        BoeBot.wait(1000);
        stop();

    }

    public void turn(int direction) {
        if (direction == 1) {
            currentSpeedR += 20;
        } else {
            currentSpeedL += 20;
        }

//        if (degrees >= -180 && degrees <= 180 && degrees != 0) {
//            if (degrees > 0) {                                                  //turn to the right
//                stop();
//                double part = degrees / 180.0;
//                int time = (int) Math.round(1915 * part);
//                System.out.println(time);
//                Timer timer = new Timer(time);
//                while (true) {
//                    this.currentSpeedL = 1600;
//                    if (timer.timeout()) {
//                        System.out.println("stop");
//                        break;
//                    }
//                }
//            }
//
//            if (degrees < 0) {                                                     //turn to the left
//                stop();
//                double part = Math.abs(degrees) / 180.0;
//                int time = (int) Math.round(1915 * part);
//                Timer timer = new Timer(time);
//                System.out.println(time);
//                while (true) {
//                    this.currentSpeedR = 1400;
//                    if (timer.timeout()) {
//                        break;
//                    }
//                }
//            }
//        }
    }
}




