import TI.BoeBot;
import TI.Servo;

import java.util.ArrayList;

public class RobotMain {

    public static void main(String[] args) {
        ArrayList<Updateble> sensors = new ArrayList<>();
        ServoMethods servo = new ServoMethods();
        RemoteControl control = new RemoteControl(servo);

        Ultrasone ultra = new Ultrasone(servo);
//        sensors.add(new RemoteControl());
        sensors.add(ultra);

        control.getControl().setCurrentSpeedL(1500);
        control.getControl().setCurrentSpeedR(1500);

        while (true) {
            control.update();
            control.getControl().update();
            BoeBot.wait(10);
            ultra.update();

        }
    }
}













