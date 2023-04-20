
import java.util.ArrayList;


/**
 *
 * @author tom
 */
public class MisplacingBox extends Box {
    
    ArrayList<Item> box;
    
    public MisplacingBox() {
        super();
        this.box = new ArrayList<>();
        
    }

    @Override
    public void add(Item item) {
        this.box.add(item);
    }

    @Override
    public boolean isInBox(Item item) {
        return false;
    }
    
}
