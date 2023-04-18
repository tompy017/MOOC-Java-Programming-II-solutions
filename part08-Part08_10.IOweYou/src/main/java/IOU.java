
import java.util.HashMap;


/**
 *
 * @author tom
 */
public class IOU {
    
    private HashMap<String, Double> debts;
    
    public IOU() {
        this.debts = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount) {
        double newTotal = this.debts.getOrDefault(toWhom, 0.0);
        newTotal += amount;
        
        this.debts.put(toWhom, newTotal);
    }
    
    public double howMuchDoIOweTo(String toWhom) {
        return this.debts.getOrDefault(toWhom, 0.0);
    }
}
