import TI.BoeBot;
import TI.PWM;

import java.awt.*;

public class LEDMethods {

    private int led1;
    private int led2;
    private int led3;

    public LEDMethods(int red, int green, int blue) {
        this.led1 = red;
        this.led2 = green;
        this.led3 = blue;
    }

    public LEDMethods(int led1, int led2) {
        this.led1 = led1;
        this.led2 = led2;
    }

    public LEDMethods(int led) {
        this.led1 = led;
    }

    public void sirene() {                                                          //woop woop thats the sound of the police
        BoeBot.digitalWrite(this.led1, false);
        BoeBot.wait(100);
        BoeBot.digitalWrite(this.led1, true);
        BoeBot.wait(100);
        BoeBot.digitalWrite(this.led2, false);
        BoeBot.wait(100);
        BoeBot.digitalWrite(this.led2, true);
        BoeBot.wait(100);
    }

    public void rainbow() {                                                         //insert Mario Kart star theme
        PWM pwmr = new PWM(this.led1, 0);
        PWM pwmg = new PWM(this.led2, 0);
        PWM pwmb = new PWM(this.led3, 0);

        for (int i = 0; i < 360; i++) {
            Color kleur = Color.getHSBColor(i / 360f, 1f, 0.9f);
            pwmr.update(kleur.getRed());
            pwmg.update(kleur.getGreen());
            pwmb.update(kleur.getBlue());
            BoeBot.wait(2);

        }
    }

    public void on() {                                                               //only cool with red LED
        BoeBot.digitalWrite(this.led1, false);
    }
}
