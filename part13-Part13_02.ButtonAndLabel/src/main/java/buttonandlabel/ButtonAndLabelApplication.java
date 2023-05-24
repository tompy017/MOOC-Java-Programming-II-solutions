package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonAndLabelApplication extends Application {
    
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        launch(ButtonAndLabelApplication.class);
        
    }

    @Override
    public void start(Stage stage) {
        Button btn = new Button("This is a button");
        Label label = new Label("This is a label");
        
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(label);
        componentGroup.getChildren().add(btn);
        
        Scene view = new Scene(componentGroup);
        
        stage.setScene(view);
        stage.show();
        
    }

}
