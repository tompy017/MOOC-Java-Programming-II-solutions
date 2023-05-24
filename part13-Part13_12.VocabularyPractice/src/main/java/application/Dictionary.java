package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author tom
 */
public class Dictionary {
    
    private List<String> words;
    private Map<String, String> translations;
    
    
    public Dictionary() {
        this.words = new ArrayList<>();
        this.translations = new HashMap();
        
        // add to start without an empty dictionary
        add("sana", "word");
    }
    
    
    public void add(String word, String translation) {
        //add to dictionary
        this.translations.put(word, translation);
        //add to list if the word wasn't already added
        if (!this.words.contains(word)) {
            this.words.add(word);
        }
    }
    
    
    public String get(String word) {
        return this.translations.get(word);
    }
    
    
    
    public String getRandomWord() {
        
        Random random = new Random();
        int randomIndex = random.nextInt(words.size());  // va hasta el size -1
        
        return words.get(randomIndex);
    }
}
