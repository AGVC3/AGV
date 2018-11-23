import TI.BoeBot;

public class Ultrasone implements Updateble {

    private ServoMethods servo;

    public Ultrasone(ServoMethods servo) {
        this.servo = servo;
    }

    public void update() {
        BoeBot.digitalWrite(10, true);
        BoeBot.wait(1);
        BoeBot.digitalWrite(10, false);

        int pulse = BoeBot.pulseIn(11, true, 10000);
        if (pulse != -2 && !(pulse > 9000) && pulse != 17 && pulse != -1 && pulse < 2500) {
            System.out.println(pulse);
            this.servo.stop();
        }
        if (pulse < 300) {
//            this.servo.stop();
        }
    }
}
