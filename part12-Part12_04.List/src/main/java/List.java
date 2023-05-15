
/**
 *
 * @author tom
 */
public class List<T> {
    
    private T[] values;        // array
    private int firstEmptyIndex;
    
    public List() {                             // generate array of 10 "places" -> arbitrary number of the excercise
        this.values = (T[]) new Object[10];     // java doesn't suppor new T[10]
        this.firstEmptyIndex = 0;
    }
    
    
    public void add(T value) {
        
        if (this.values.length == this.firstEmptyIndex) {
            this.grow();
        }

        this.values[this.firstEmptyIndex] = value;
        this.firstEmptyIndex ++;
    }
    
    
    private void grow() {
        int newSize = this.values.length + this.values.length / 2;     // grows the list by 1.5
        
        T[] newValues = (T[]) new Object[newSize];
        
        for (int i = 0; i < this.values.length; i ++) {
            newValues[i] = this.values[i];
        }
        
        this.values = newValues;
    }
    
    
    public boolean contains(T value) {
        return this.indexOfValue(value) >= 0;
    }
    
    
    
    public int indexOfValue(T value) {
        
        int index = -1;
        
        for (int i = 0; i < this.firstEmptyIndex; i ++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }
        
        return index;
    }
    
    
    
    private void moveToTheLeft(int fromIndex) {
        
        for (int i = fromIndex; i < this.firstEmptyIndex; i ++) {
            this.values[i] = this.values[i + 1];
        }
        
    }
    
    
    public void remove(T value) {
        int indexToRemove = indexOfValue(value);
        
        if (indexToRemove >= 0) {
            this.moveToTheLeft(indexToRemove);
            this.firstEmptyIndex --;
        }
    }
    
    
    public T value(int index) {
        
        if (index < 0 || index >= firstEmptyIndex) {
            throw new ArrayIndexOutOfBoundsException("Index " + index 
                    + " outside of [0, " + this.firstEmptyIndex + "]");
        }
        
        return this.values[index];
    }
    
    
    public int size() {
        return this.firstEmptyIndex;
    }
}
