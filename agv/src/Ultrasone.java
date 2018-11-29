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
        System.out.println(pulse);
        if (pulse != -2 && pulse != 17 && pulse != -1 && pulse < 5000) {
            System.out.println(pulse);
            this.servo.stop();
            BoeBot.digitalWrite(15,false);
        }
    }
}