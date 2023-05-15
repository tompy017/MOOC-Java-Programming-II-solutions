
/**
 *
 * @author tom
 */
public class Hideout<T> {
    
    private T[] hider;
    
    
    public Hideout() {
        this.hider = (T[]) new Object[1];
    }
    
    public void putIntoHideout(T toHide) {
        hider[0] = toHide;
    }
    
    public T takeFromHideout() {
        T removed = this.hider[0];
        this.hider[0] = null;
        return removed;
    }
    
    public boolean isInHideout() {
        return hider[0] != null;
    }
}
