
/**
 *
 * @author tom
 */
public class CustomTacoBox implements TacoBox {
    
    private int tacosLeft;
    
    public CustomTacoBox(int tacos) {
        this.tacosLeft = tacos;
    }

    @Override
    public int tacosRemaining() {
        return tacosLeft;
    }

    @Override
    public void eat() {
        if (this.tacosLeft > 0) {
            this.tacosLeft -= 1;
        }
    }
    
}
