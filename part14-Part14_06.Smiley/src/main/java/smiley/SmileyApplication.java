package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SmileyApplication extends Application {


    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        Canvas canvas = new Canvas(300, 300);
        GraphicsContext painter = canvas.getGraphicsContext2D();
        
        insertSmile(painter);
        
        BorderPane layout = new BorderPane();
        layout.setCenter(canvas);
        
        Scene scene = new Scene(layout);
        scene.setFill(Color.WHITE);        //background (canvas is transparent)
        stage.setScene(scene);
        stage.show();
        
        
        
        
    }
    
    
    private void insertSmile(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(80, 50, 30, 30);   //LEFT EYE
        gc.fillRect(180, 50, 30, 30);  //RIGHT EYE
        gc.fillRect(50, 170, 30, 30);  //UPPER-LEFT MOUTH
        gc.fillRect(210, 170, 30, 30); //UPPER-RIGHT MOUTH
        gc.fillRect(80, 200, 130, 30); //BOTTOM MOUTH
    }
    
    
}
