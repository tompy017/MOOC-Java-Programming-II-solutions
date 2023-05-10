package application;

/**
 *
 * @author tom
 */
public class StandardSensor implements Sensor {
    
    private int value;
    
    
    public StandardSensor(int temperature) {
        this.value = temperature;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {
    }

    @Override
    public void setOff() {
    }

    @Override
    public int read() {   
        return this.value;
    }
    
}
