package textstatistics;

import javafx.application.Application;
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
        layout.setCenter(new TextArea());
        
        //bottom edge
        HBox bottomLabels = new HBox();
        bottomLabels.setSpacing(120);
        //adding labels
        bottomLabels.getChildren().add(new Label("Letters: 0"));
        bottomLabels.getChildren().add(new Label("Words: 0"));
        bottomLabels.getChildren().add(new Label("The longest word is:"));
        
        //set the position of bottom labels
        layout.setBottom(bottomLabels);
        
        // Set the scene and show it
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

}
