package title;

import javafx.application.Application;
import javafx.stage.Stage;


public class UserTitle extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        Parameters parameters = getParameters();
        String title = parameters.getNamed().get("title");
        
        stage.setTitle(title);
        
        stage.show();
        
    }


}
