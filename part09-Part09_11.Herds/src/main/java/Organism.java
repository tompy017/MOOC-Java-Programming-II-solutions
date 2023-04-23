
/**
 *
 * @author tom
 */
public class Organism implements Movable {
    //position in 2 dimensional coordinate system
    private int x;
    private int y;
    
    public Organism(int x, int y) {
        this.x = x;
        this.y = y;
        
    }
    
    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    
    
    @Override
    public String toString() {
        return "x: " + x + "; y: " + y;
    }
}
