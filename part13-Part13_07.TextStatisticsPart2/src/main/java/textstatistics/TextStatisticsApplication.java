package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
//import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application {


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }
    

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane layout = new BorderPane();
        
        //set a text area in the center
        TextArea text = new TextArea();
        layout.setCenter(text);
        
        //bottom edge
        HBox bottomLabels = new HBox();
        bottomLabels.setSpacing(50);
        //adding labels
        Label lettersCount = new Label("Letters: 0");
        Label wordsCount = new Label("Words: 0");
        Label longestWord = new Label("The longest word is: ");
        bottomLabels.getChildren().add(lettersCount);
        bottomLabels.getChildren().add(wordsCount);
        bottomLabels.getChildren().add(longestWord);
        
        //set the position of bottom labels
        layout.setBottom(bottomLabels);
        
        
        // statistics in real time funtion
        text.textProperty().addListener((change, oldValue, newValue) -> {
        
            int letterQty = newValue.length();
        
            String[] parts = newValue.split(" ");
            int wordQty = parts.length;
            String longest = Arrays.stream(parts)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .get();
            
            lettersCount.setText("Letters: " + letterQty);
            wordsCount.setText("Words: " + wordQty);
            longestWord.setText("The longest word is: " + longest);
        
        
        });
        
        
        
        
        
        
        // Set the scene and show it
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

}
