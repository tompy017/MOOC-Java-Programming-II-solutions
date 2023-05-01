
import java.util.Comparator;


/**
 *
 * @author tom
 */
public class SortBySuit implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        return card1.getSuit().ordinal() - card2.getSuit().ordinal();
    }
    
}
