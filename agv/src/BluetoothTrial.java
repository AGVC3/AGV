import TI.SerialConnection;

public class BluetoothTrial {
    private SerialConnection conn;
    private ServoMethods servo;

    public BluetoothTrial() {
        this.conn = new SerialConnection(115200);
        this.servo = new ServoMethods();

    }

    public void tokyoDrift() {
        if (conn.available() > 0) {
            int data = conn.readByte();
            char i = (char) data;
            System.out.println(i);
            switch (i) {
                case 'w':
                    servo.goToSpeed(1600);
                break;
                case 'd':
                    servo.turn(90);
                break;
                case 'a':
                    servo.turn(-90);
                break;
                case 'x':
                    servo.goToSpeed(1400);
                break;
                case 's':
                    servo.stop();
                break;
            }
        }
    }
}