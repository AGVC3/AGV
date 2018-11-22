import TI.BoeBot;

public class RemoteControl implements Updateble {

    private ServoMethods control;

    public RemoteControl(int s1, int s2) {
        this.control = new ServoMethods(s1, s2);
    }

    public void buttonToAction(int ioPort, int defaultSpeed) {
        int button = binaryToButton(ioPort);
        int speedBackwards = (3000 - defaultSpeed);
        switch (button) {
            case 1:
                this.control.turnWhileDriving(-1);
                break;
            case 2:
                this.control.goToSpeed(defaultSpeed);
                break;
            case 3:
                this.control.turnWhileDriving(1);
                break;
            case 4:
                this.control.turn(-5);
                break;
            case 5:
                this.control.emegencyBreak();
                break;
            case 6:
                this.control.turn(5);
                break;
            case 7:
                this.control.turn(45);
                BoeBot.wait(10);
                this.control.goToSpeed(speedBackwards);
                break;
            case 8:
                this.control.goToSpeed(speedBackwards);
                break;
            case 9:
                this.control.turn(-45);
                BoeBot.wait(10);
                this.control.goToSpeed(speedBackwards);
                break;
        }
//        if (button == 1) {                                      //turn -45 degrees and drive forwards
//            this.control.turn(-45);
//            BoeBot.wait(10);
//            this.control.goToSpeed(defaultSpeed);
//        }
//        if (button == 2) {                                      //drive forwards
//            this.control.goToSpeed(defaultSpeed);
//        }
//        if (button == 3) {                                      //turn 45 degrees and drive forwards
//            this.control.turn(45);
//            BoeBot.wait(10);
//            this.control.goToSpeed(defaultSpeed);
//        }
//        if (button == 4) {                                      //turn to the left
//            this.control.turn(-5);
//        }
//        if (button == 5) {                                      //stop
//            this.control.emegencyBreak();
//        }
//        if (button == 6) {                                      //turn to the right
//            this.control.turn(5);
//        }
//        if (button == 7) {                                      //turn 45 degrees and drive backwards
//            this.control.turn(45);
//            BoeBot.wait(10);
//            this.control.goToSpeed(speedBackwards);
//        }
//        if (button == 8) {                                      //drive backwards
//            this.control.goToSpeed(speedBackwards);
//        }
//        if (button == 9) {                                      //turn -45 degrees and drive backwards
//            this.control.turn(-45);
//            BoeBot.wait(10);
//            this.control.goToSpeed(speedBackwards);
//        }
    }

    private int binaryToButton(int ioPort) {
        String button = buttonToBinary(ioPort);
        if (button.equals("000010000000")) {
            return 1;
        }
        if (button.equals("000010000001")) {
            return 2;
        }
        if (button.equals("000010000010")) {
            return 3;
        }
        if (button.equals("000010000011")) {
            return 4;
        }
        if (button.equals("000010000100")) {
            return 5;
        }
        if (button.equals("000010000101")) {
            return 6;
        }
        if (button.equals("000010000110")) {
            return 7;
        }
        if (button.equals("000010000111")) {
            return 8;
        }
        if (button.equals("000010001000")) {
            return 9;
        } else {
            return -1;
        }
    }

    private String buttonToBinary(int ioPort) {

        int pulse = BoeBot.pulseIn(ioPort, false, 6000);
        StringBuilder binaryCode = new StringBuilder();
        if (pulse > 2000) {
            int[] signal = new int[12];
            for (int i = 0; i < 12; i++) {
                signal[i] = BoeBot.pulseIn(ioPort, false, 20000);
            }
            StringBuilder wtfAmIDoingV2 = new StringBuilder();
            for (int i = 0; i < 12; i++) {
                wtfAmIDoingV2.append(signal[i] < 800 ? "0" : "1");
            }

            wtfAmIDoingV2.reverse();
            return wtfAmIDoingV2.toString();

        } else {
            return binaryCode.toString();
        }
    }

    public void update() {
        buttonToAction(8, 1700);
    }
}