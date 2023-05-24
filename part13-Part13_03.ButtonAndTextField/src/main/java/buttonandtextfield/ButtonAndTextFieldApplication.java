package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {


    public static void main(String[] args) {
        //System.out.println("Hello world!");
        launch(ButtonAndTextFieldApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        Button btn = new Button("Button");
        TextField text = new TextField("This is a text field");
        
        FlowPane buttonAndText = new FlowPane();
        buttonAndText.getChildren().add(btn);
        buttonAndText.getChildren().add(text);
        
        Scene view = new Scene(buttonAndText);
        
        stage.setScene(view);
        stage.show();
        
    }

}



