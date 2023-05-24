package application;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author tom
 */
public class VocabularyPracticeApplication extends Application {
    
    private Dictionary dictionary;
    
    @Override
    public void init() {
        // create the dictionary that the application uses
        this.dictionary = new Dictionary();
    }
    
    
    @Override
    public void start(Stage stage) throws Exception {
        //views
        PracticeView practiceView = new PracticeView(this.dictionary);
        InputView inputView = new InputView(this.dictionary);

        //menu components
        Button enterButton = new Button("Enter new words");
        Button  practiceButton = new Button("Practice");
        
        //menu layout
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);
        
        menu.getChildren().addAll(enterButton, practiceButton);
        
        // principal layout
        BorderPane layout = new BorderPane();
        layout.setTop(menu);
        
        
        // 4. Connect the subviews with the buttons. Clicking menu buttons changes the subview.
        enterButton.setOnAction((event) -> {
            layout.setCenter(inputView.getView());
                });
        
        practiceButton.setOnAction((event) -> {
            layout.setCenter(practiceView.getView());        
        });
        
        //create the main view and add the high level layout
        Scene view = new Scene(layout, 400, 300);
        
        // show application
        stage.setScene(view);
        stage.show();
        
    }
    
    
    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }
    
}
