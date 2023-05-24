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
public class InputView {
    
    private Dictionary dictionary;
    
    public InputView(Dictionary dict) {
        this.dictionary = dict;
    }
    
    
    public Parent getView() { // layouts implements Parent
        //components
        Label wordInstruction = new Label("Word");
        TextField wordField = new TextField();
        Label translationInstruction = new Label("Translation");
        TextField translationField = new TextField();
        Button addBtn = new Button("Add the word pair");
        
        //layout
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        layout.add(wordInstruction, 0, 0);
        layout.add(wordField, 0, 1);
        layout.add(translationInstruction, 0, 2);
        layout.add(translationField, 0, 3);
        
        // button event handler
        addBtn.setOnMouseClicked((event) -> { 
            String word = wordField.getText();
            String translation = translationField.getText();
            
            // add word
            dictionary.add(word, translation);
            
            // clear fields
            wordField.clear();
            translationField.clear();
        });

        return layout; //implements Parent class
        
    }
}
