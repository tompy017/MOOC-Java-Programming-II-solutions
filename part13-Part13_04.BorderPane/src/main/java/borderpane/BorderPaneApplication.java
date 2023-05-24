package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class BorderPaneApplication extends Application{


    public static void main(String[] args) {
        
        launch(BorderPaneApplication.class);
        
    }

    
    @Override
    public void start(Stage stage) throws Exception {
        
        BorderPane layoutBP = new BorderPane();
        
        Label north = new Label("NORTH");
        Label east = new Label("EAST");
        Label south = new Label("SOUTH");
        
        layoutBP.setTop(north);
        layoutBP.setRight(east);
        layoutBP.setBottom(south);
        
        Scene window = new Scene(layoutBP);
        
        stage.setScene(window);
        stage.show();
    }

}
