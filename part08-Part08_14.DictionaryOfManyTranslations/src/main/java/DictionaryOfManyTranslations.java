
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author tom
 */
public class DictionaryOfManyTranslations {
    
    private HashMap<String, ArrayList<String>> dictionary;
    
    
    public DictionaryOfManyTranslations() {
        this.dictionary = new HashMap<>();
    }
    
    
    public void add(String word, String translation) {
        //Generate the list if there is no key for the given word
        this.dictionary.putIfAbsent(word, new ArrayList<>());
        //Append the translation to the list
        this.dictionary.get(word).add(translation);
        
    }
    
    public ArrayList<String> translate(String word) {
        return this.dictionary.getOrDefault(word, new ArrayList<>());
    }
    
    public void remove(String word) {
        dictionary.remove(word);
    }
}
