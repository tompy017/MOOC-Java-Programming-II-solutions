
/**
 *
 * @author tom
 */
public class Container {
    
    private int contains;
    
    public Container() {
        this.contains = 0;
    }
    
    public int contains() {
        return this.contains;
    }
    
    public void add (int amount) {
        // only add positive integers
        if (amount > 0) {
            this.contains += amount;
        }
        // a container can only hold 100 units of liquid
        if (this.contains > 100) {
            this.contains = 100;
        }
    }
    
    public void remove (int amount) {
        if (amount > 0) {
            this.contains -= amount;
        }
        if (this.contains < 0) {
            this.contains = 0;
        }
    }
    
    public String toString() {
        return this.contains + "/100";
    }
}
