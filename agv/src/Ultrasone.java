import TI.BoeBot;

public class Ultrasone implements Updateble {

    private ServoMethods servo;

    public Ultrasone() {
        this.servo = new ServoMethods();
    }

    public void update() {
        BoeBot.digitalWrite(10,true);
        BoeBot.wait(1);
        BoeBot.digitalWrite(10,false);
        int pulse = BoeBot.pulseIn(11,true, 10000);

        if (pulse < 2000) {
            this.servo.goToSpeed(0);
        }
    }
}
