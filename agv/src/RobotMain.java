import TI.BoeBot;
import TI.Servo;

import java.util.ArrayList;

public class RobotMain {

    public static void main(String[] args) {
        ArrayList<Updateble> sensors = new ArrayList<>();

        RemoteControl control = new RemoteControl();

        sensors.add(new RemoteControl());
        sensors.add(new Ultrasone());

        while (true) {
           control.buttonToAction(8,1700);
           control.getControl().update();
           BoeBot.wait(10);
        }
    }
}














