
import java.util.ArrayList;


/**
 *
 * @author tom
 */
public class BoxWithMaxWeight extends Box {
    
    private ArrayList<Item> box;
    private int capacity;
    
    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.box = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (item.getWeight() <= this.capacity) {
            this.box.add(item);
            this.capacity -= item.getWeight();
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return this.box.contains(item);
    }
}
