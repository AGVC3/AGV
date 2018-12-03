import TI.BoeBot;
import TI.Servo;

import java.util.ArrayList;

public class RobotMain {

    public static void main(String[] args) {
        ArrayList<Updateble> sensors = new ArrayList<>();
        ServoMethods servo = new ServoMethods();
        RemoteControl control = new RemoteControl(servo);
        Ultrasone ultra = new Ultrasone(servo);
        LineSensor lineSensor = new LineSensor(servo);
        BluetoothTrial BT = new BluetoothTrial();


        sensors.add(control);
        sensors.add(servo);
        sensors.add(ultra);
//        sensors.add(lineSensor);

        control.getControl().setCurrentSpeedL(1500);
        control.getControl().setCurrentSpeedR(1500);

        BoeBot.digitalWrite(0, true);

        while (true) {
            for (Updateble sensor : sensors) {
                sensor.update();
            }
            BT.tokyoDrift();


            BoeBot.wait(100);

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














