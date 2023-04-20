
import java.util.ArrayList;


/**
 *
 * @author tom
 */
public class Box implements Packable{
    
    private ArrayList<Packable> box;
    private double maxCapacity;
    
    
    public Box(double maxCapacity) {
        this.box = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }
    
    public void add(Packable item) {
        if (item.weight() <= this.maxCapacity - this.weight()) {
            this.box.add(item);
        }
    }
    
    @Override
    public double weight() {
        /*if (this.box.isEmpty()) {
            return 0;
        }*/
        double weight = 0;
        for (Packable item : this.box) {
            weight += item.weight();
        }
        return weight;
    }
    
    @Override
    public String toString() {
        return "Box: " + box.size() + " items, "
                + "total weight " + this.weight() + " kg";
    }
    
}
