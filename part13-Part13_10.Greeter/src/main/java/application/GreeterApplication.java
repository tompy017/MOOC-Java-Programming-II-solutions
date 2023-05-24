package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {


    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // components to use
        Label instructions = new Label("Enter your name and start.");
        Label greeter = new Label("");
        TextField nameField = new TextField();
        Button startBtn = new Button("Start");
        
        //First view layout
        GridPane layout = new GridPane();
        layout.add(instructions, 0, 0);
        layout.add(nameField, 0, 1);
        layout.add(startBtn, 0, 2);
        
        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        //generate first view
        Scene firstView = new Scene(layout);
        
        
        // Second view
        StackPane greet = new StackPane();
        greet.getChildren().add(greeter);
        greet.setPrefSize(300, 180);
        greet.setAlignment(Pos.CENTER);
        
        //generate second view
        Scene welcome = new Scene(greet);
        
        // event handler of button
        startBtn.setOnAction((event) -> {
            greeter.setText("Welcome " + nameField.getText() + "!");
            
            stage.setScene(welcome);
        
        });
        
        stage.setScene(firstView);
        stage.show();
    }
}
