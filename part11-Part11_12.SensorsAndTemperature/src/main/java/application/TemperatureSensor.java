package application;

import java.util.Random;

/**
 *
 * @author tom
 */
public class TemperatureSensor implements Sensor {
    
    private boolean isOn;

    public TemperatureSensor() {
        this.isOn = false;
    }
    
    
    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void setOn() {
        this.isOn = true;
    }

    @Override
    public void setOff() {
        this.isOn = false;
    }

    @Override
    public int read() {
        if (!this.isOn()) {
            throw new IllegalStateException("Temperature sensor is off.");
        }
        return new Random().nextInt(61) - 30; // to return a value between -30 and 30
    }
    
}
