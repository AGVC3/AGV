import TI.BoeBot;
import TI.Servo;

import java.util.ArrayList;

public class RobotMain {

    public static void main(String[] args) {
        ArrayList<Updateble> list = new ArrayList<>();

        list.add(new ServoMethods(12, 13));
        list.add(new RemoteControl(12, 13));

        while (true) {
            //control.buttonToAction(8,1550);
            /*for (Updateble updateble : list) {
                updateble.update();
            }
            BoeBot.wait(10);*/
        }
    }
}













