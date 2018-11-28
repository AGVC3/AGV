import TI.BoeBot;

public class RemoteControl implements Updateble {

    private ServoMethods control;

    public RemoteControl(ServoMethods servo) {
        this.control = servo;

    }

    public ServoMethods getControl() {
        return control;
    }

    public void buttonToAction(int ioPort, int defaultSpeed) {
        int button = binaryToButton(ioPort);
        int speedBackwards = (3000 - defaultSpeed);
        switch (button) {
//            case 11:                                            //Up
//                this.control.goToSpeed(defaultSpeed);
//            case 12:                                            //Down
//                this.control.goToSpeed(speedBackwards);
//            case 13:                                            //Left
//                this.control.turn(-10);
//            case 14:                                            //Right
//                this.control.turn(10);
//            case 15:                                            //Mute
//                this.control.stop();

            case 1:
                this.control.stop();
                break;
            case 2:
                BoeBot.digitalWrite(10, true);
                BoeBot.wait(1);
                BoeBot.digitalWrite(10, false);

                int pulse = BoeBot.pulseIn(11, true, 10000);
                if (!(pulse != -2 && !(pulse > 9000) && pulse != 17 && pulse != -1 && pulse < 5000)) {
                    this.control.goToSpeed(defaultSpeed);
                }
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                this.control.turn(1);
                this.control.update();
                BoeBot.wait(1000);
                this.control.stop();

                break;
            case 4:
                this.control.turn(1);
                System.out.println("4");
                break;
            case 5:
                this.control.goToSpeed(1500);
                break;
            case 6:
                this.control.turn(-1);
                break;
//            case 7:
//                this.control.turnWhileDriving(-1);
//                break;
            case 8:
                this.control.goToSpeed(speedBackwards);
                break;
//            case 9:
//                this.control.turnWhileDriving(1);
//                break;
        }
    }

    private int binaryToButton(int ioPort) {
        String button = buttonToBinary(ioPort);
        switch (button) {
            case "000010001001":
                return 0;
            case "000010000000":
                return 1;
            case "000010000001":
                return 2;
            case "000010000010":
                return 3;
            case "000010000011":
                return 4;
            case "000010000100":
                return 5;
            case "000010000101":
                return 6;
            case "000010000110":
                return 7;
            case "000010000111":
                return 8;
            case "000010001000":
                return 9;
            case "000010010101":
                return 10;                                     //Power
            case "000010010000":
                return 11;                                     //UP
            case "000010010001":
                return 12;                                     //DOWN
            case "000010010011":
                return 13;                                     //LEFT
            case "000010010010":
                return 14;                                     //RIGHT
            case "000010010100":
                return 15;                                     //MUTE
            default:
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