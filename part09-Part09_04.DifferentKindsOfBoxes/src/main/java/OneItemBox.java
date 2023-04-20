
import java.util.ArrayList;



/**
 *
 * @author tom
 */
public class OneItemBox extends Box {
    
    private ArrayList<Item> uniqueBox;
    
    public OneItemBox() {
        super();
        this.uniqueBox = new ArrayList<>();
        
    }

    @Override
    public void add(Item item) {
        if (this.uniqueBox.isEmpty()) {
            this.uniqueBox.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return this.uniqueBox.contains(item);
    }
    
}
