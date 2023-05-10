package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author tom
 */
public class SaveableDictionary {
    
    private HashMap<String, String> translations;
    private String file;
    
    
    public SaveableDictionary() {
        this("");
    }
    
    public SaveableDictionary(String file) {
        this.translations = new HashMap<>();
        this.file = file;
        
    }
    
    
    public void add(String words, String translation) {
        if (!this.translations.containsKey(words) 
                && !this.translations.values().contains(words)) {
            this.translations.put(words, translation);    
        }
    }
    
    
    public String translate(String word) {
     
        return this.translations.getOrDefault(word, this.searchByValue(word));
    }
    
    
    public String searchByValue(String word) {
        
        for (Map.Entry<String, String> entry: translations.entrySet()) {
            if (entry.getValue().equals(word)) { 
                return entry.getKey();
            }
        } 
        return null;
    }
    
    public void delete(String word) {
        
        if (translations.keySet().contains(word)) {
            translations.remove(word);
        }
                
        String toDelete = translations.getOrDefault(word, searchByValue(word));
        
        if (toDelete != null) {
            translations.remove(toDelete);
        }
    }
    
    
    public boolean load() {
        
        try (Scanner reader = new Scanner(Paths.get(this.file))) {
            
            while (reader.hasNextLine()) {
                
                String line = reader.nextLine();
                
                if (line.isEmpty()) {
                    continue;
                }
                
                String[] parts = line.split(":");
                
                translations.put(parts[0], parts[1]);
            }
            
        } catch (Exception e) {
            
            return false;
        }
        
        return true;
    }
    
    
    
    public boolean save() {
        
        try (PrintWriter writer = new PrintWriter(this.file)) {
            
            translations.entrySet()
                    .stream()
                    .forEach(wordSet -> { 
                        writer.println(wordSet.getKey() + ":" + wordSet.getValue());
                                });
                            
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
}
