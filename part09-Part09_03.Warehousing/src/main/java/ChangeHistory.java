
import java.util.ArrayList;


/**
 *
 * @author tom
 */
public class ChangeHistory {
    
    private ArrayList<Double> log;
    
    
    public ChangeHistory() {
        this.log = new ArrayList<>();
    }
    
    public void add(double status) {
        this.log.add(status);
    }
    
    public void clear() {
        this.log.clear();
    }
     
    public double maxValue() {
        
        if (log.isEmpty()) {
            return 0.0;
        }
        
        double max = this.log.get(0);
        for (double value : this.log) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
    
    public double minValue() {
        if (log.isEmpty()) {
            return 0.0;
        }
        
        double min = log.get(0);
        for (double value : this.log) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
    
    public double average() {
        if (log.isEmpty()) {
            return 0.0;
        }
        
        double total = 0.0;
        for (double value : this.log) {
            total += value;
        }
        return total / this.log.size();
    }
    
    
    @Override
    public String toString() {
        return this.log.toString();
    }
}
