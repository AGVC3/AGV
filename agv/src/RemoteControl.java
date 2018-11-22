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
                this.control.turn(-10);
                break;
            case 5:
                this.control.emegencyBreak();
                break;
            case 6:
                this.control.turn(10);
                break;
            case 7:
                this.control.turnWhileDriving(-1);
                break;
            case 8:
                this.control.goToSpeed(speedBackwards);
                break;
            case 9:
                this.control.turnWhileDriving(1);
                break;
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

    }
}


