import TI.BoeBot;
import TI.Servo;

public class RobotMain {

    public static void main(String[] args) {

        Servo right = new Servo(12);                                //turns counter clock wise
        Servo left = new Servo(13);                                 //turns clock wise
        ServoMethods methodS = new ServoMethods(12, 13);
        RemoteControl control = new RemoteControl(12, 13);
        LEDMethods led = new LEDMethods(2);

        while (true) {
            control.buttonToAction(8,1550);
        }

    }
}













