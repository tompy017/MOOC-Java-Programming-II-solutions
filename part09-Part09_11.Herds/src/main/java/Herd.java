
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author tom
 */
public class Herd implements Movable {
    
    private List<Movable> herd;
    
    public Herd() {
        this.herd = new ArrayList<>();
    }
    
    public void addToHerd(Movable movable) {
        this.herd.add(movable);
    }

    
    @Override
    public void move(int dx, int dy) {
        for (Movable movable : this.herd) {
            movable.move(dx, dy);
        }
        
    }
    
    @Override
    public String toString() {
        String output = "";
        for (Movable movable : this.herd) {
            output += movable.toString() + "\n";
        }
        
        return output;
    }
    
}
