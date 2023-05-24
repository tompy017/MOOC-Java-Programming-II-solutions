package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JokeApplication extends Application {


    public static void main(String[] args) {
        launch(JokeApplication.class);
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        // menu
        Button jokeBtn = new Button("Joke");
        Button answerBtn = new Button("Answer");
        Button explanationBtn = new Button("Explanation");
        
        VBox buttonsLayout = new VBox();
        buttonsLayout.setPadding(new Insets(20, 20, 20, 20));
        buttonsLayout.setSpacing(20);
        buttonsLayout.getChildren().addAll(jokeBtn, answerBtn, explanationBtn);
        
        
        
        //subviews
        String joke = "What do you call a bear with no teeth?";
        String answer = "A gummy bear.";
        String explanation = "Because it have no teeth but gums xD";
        
        StackPane jokeView = createView(joke);
        StackPane answerView = createView(answer);
        StackPane explanationView = createView(explanation);
        
        
        // LAYOUT
        BorderPane layout = new BorderPane();
        layout.setLeft(buttonsLayout);
        layout.setCenter(jokeView);
        
        
        
        // buttons events handlers
        jokeBtn.setOnAction(event -> layout.setCenter(jokeView));
        answerBtn.setOnAction(event -> layout.setCenter(answerView));
        explanationBtn.setOnAction(event -> layout.setCenter(explanationView));
        
        
        
        //main scene
        Scene scene = new Scene(layout);
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    private StackPane createView(String text) {
        
        StackPane layout = new StackPane();
        
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);
        
        return layout;
    }
}
