package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author tom
 */

public class PracticeView {
    
    private Dictionary dictionary;
    private String word;
    
    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = dictionary.getRandomWord();
    }
    
    
    public Parent getView() {
        
        //components
        Label wordInstruction = new Label("Translate the word '" 
                + this.word + "'");
        TextField translationField = new TextField();
        Button checkBtn = new Button("Check");
        Label feedback = new Label("");
        
        
        // layout
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        
        layout.add(wordInstruction, 0, 0);
        layout.add(translationField, 0, 1);
        layout.add(checkBtn, 0, 2);
        layout.add(feedback, 0, 3);
        
        
        // button event handler
        checkBtn.setOnMouseClicked((event) -> {
            String userInput = translationField.getText();
            
            if (userInput.equalsIgnoreCase(dictionary.get(word))) {
                feedback.setText("Correct!");
            
            } else {
                feedback.setText("Incorrect! The translation of the word '"
                        + word + "' is '" + dictionary.get(word) + "'.");
                return;
            }
            
            
            this.word = dictionary.getRandomWord();
            wordInstruction.setText("Translate the word '" + word + "'");
            translationField.clear();
        });
        
        return layout;
    }


    
}
