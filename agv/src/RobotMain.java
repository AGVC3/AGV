import TI.BoeBot;
import TI.Servo;

import java.util.ArrayList;

public class RobotMain {

    public static void main(String[] args) {
        ArrayList<Updateble> sensors = new ArrayList<>();

        sensors.add(new RemoteControl(12, 13));
        sensors.add(new Ultrasone());

        while (true) {
            for (Updateble sensor : sensors) {
                sensor.update();
            }
        }
    }
}













