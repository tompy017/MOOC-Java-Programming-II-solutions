package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tom
 */
public class AverageSensor implements Sensor {
    
    private List<Sensor> sensors;
    private List<Integer> readings;
    
    
    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }
    
    
    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }
    
    
    @Override
    public boolean isOn() {
        for (Sensor sensor : this.sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        this.sensors.stream()
                .forEach(sensor -> sensor.setOn());
    }

    @Override
    public void setOff() {
        this.sensors.stream().forEach(sensor -> sensor.setOff());
    }

    @Override
    public int read() {
        if (!this.isOn() || this.sensors.isEmpty()) {
            throw new IllegalStateException("Average sensor is off or there aren't sensors added to it.");
        }
        
        double average = this.sensors.stream()
                .mapToInt(sensor -> sensor.read())
                .average()
                .getAsDouble();
        
        int intAverage = (int) average;
        this.readings.add(intAverage);
        return intAverage;
    }
    
    public List<Integer> readings() {
        return this.readings;
    }
    
}
