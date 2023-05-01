
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author tom
 */
public class Hand implements Comparable<Hand> {
    
    private List<Card> hand;
    
    public Hand() {
        this.hand = new ArrayList<>();
    }
    
    public void add(Card card) {
        this.hand.add(card);
    }
    
    public void print() {
        this.hand.stream()
                .forEach(card -> System.out.println(card));
    }
    
    public void sort() {
        Collections.sort(this.hand);
    }

    @Override
    public int compareTo(Hand otherHand) {
       
        int thisHandSum = this.hand.stream().mapToInt(card -> card.getValue())
                .sum();
        int otherHandSum = otherHand.hand.stream()
                .mapToInt(card -> card.getValue())
                .sum();
        
        return thisHandSum - otherHandSum;
   
    }
    
    public void sortBySuit() {
        Collections.sort(this.hand, new BySuitInValueOrder());
    }
}
