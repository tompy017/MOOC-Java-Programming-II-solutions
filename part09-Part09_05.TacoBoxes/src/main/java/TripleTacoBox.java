
/**
 *
 * @author tom
 */
public class TripleTacoBox implements TacoBox {
    
    private int tacosLeft;
    
    
    public TripleTacoBox() {
        this.tacosLeft = 3;
    }
    
    @Override
    public int tacosRemaining() {
        return this.tacosLeft;
    }

    @Override
    public void eat() {
        if (this.tacosLeft > 0) {
            this.tacosLeft -= 1;
        }
    }
    
}
