package notifier;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NotifierApplication extends Application {


    public static void main(String[] args) {
        
        launch(NotifierApplication.class);
    }

    
    @Override
    public void start(Stage stage) throws Exception {
        
        TextField text = new TextField();
        Label label = new Label();
        
        Button button = new Button("Update");
        // button funtionality
        EventHandler<ActionEvent> click = new EventHandler() {
            @Override
            public void handle(Event event) {
                label.setText(text.getText());
            }
        };
        
        button.setOnAction(click);
        
        //layout
        VBox components = new VBox();
        components.setSpacing(30);
        components.getChildren().addAll(text, button, label);
        
        // set the scene
        Scene scene = new Scene(components);
        stage.setScene(scene);
        stage.show();
        
    }

}
