import TI.BoeBot;
import TI.Servo;

import java.util.ArrayList;

public class RobotMain {

    public static void main(String[] args) {
        ArrayList<Updateble> sensors = new ArrayList<>();
        ServoMethods servo = new ServoMethods();
        RemoteControl control = new RemoteControl(servo);
        Ultrasone ultra = new Ultrasone(servo);

        sensors.add(control);
        sensors.add(ultra);
        sensors.add(servo);

        control.getControl().setCurrentSpeedL(1500);
        control.getControl().setCurrentSpeedR(1500);

        while (true) {
            for (Updateble sensor : sensors) {
                sensor.update();
            }
            BoeBot.wait(10);

//            int pulseLen = BoeBot.pulseIn(8, false, 6000);
//            if (pulseLen > 2000) {
//                int lengtes[] = new int[12];
//                for (int i = 0; i < 12; i++) {
//                    lengtes[i] = BoeBot.pulseIn(8, false, 20000);
//                }
//                for (int i = 0; i < 12; i++) {
//                    System.out.print(lengtes[i] + ", ");
//                }
//                System.out.println();
//
//                BoeBot.wait(10);
//
//            }

        }

    }
}














