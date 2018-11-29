import TI.BoeBot;

public class LineSensor implements Updateble{

    private ServoMethods servo;

    public LineSensor(ServoMethods servo) {
        this.servo = servo;
    }

    @Override
    public void update() {
        int[] sensors = detect();
        System.out.println(sensors[0] + ", " + sensors[1] + ", " + sensors[2]);
        if (sensors[0] == 1) {
            this.servo.turn(1);
        } else if (sensors[2] == 1) {
            this.servo.turn(-1);
        } else if (sensors[1] == 1) {
            this.servo.goToSpeed(1550);
        } else {
            this.servo.stop();
        }
    }

    public int[] detect() {
        int[] sensors = new int[3];
        if (BoeBot.analogRead(0) > 1000) {
            sensors[0] = 1;
        } else {
            sensors[0] = 0;
        }

        if (BoeBot.analogRead(1) > 1000) {
            sensors[1] = 1;
        } else {
            sensors[1] = 0;
        }

        if (BoeBot.analogRead(2) > 1000) {
            sensors[2] = 1;
        } else {
            sensors[2] = 0;
        }

        return sensors;
    }
}
