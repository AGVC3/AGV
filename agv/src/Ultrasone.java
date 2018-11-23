import TI.BoeBot;

public class Ultrasone implements Updateble {

    public Ultrasone() {

    }

    public void update() {
        BoeBot.digitalWrite(0, true);
        BoeBot.wait(1);
        BoeBot.digitalWrite(0, false);

        int pulse = BoeBot.pulseIn(5, true, 10000);
        System.out.println(pulse);
    }
}
