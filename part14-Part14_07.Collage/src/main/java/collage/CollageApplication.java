package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {

        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        Image sourceImage = new Image("file:monalisa.png");    //OPEN IMAGE

        PixelReader imageReader = sourceImage.getPixelReader();  //PIXEL READER FOR ORIGINAL IMAGE

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();
        
        WritableImage targetImage = new WritableImage(width, height);  // NEW IMAGE
        PixelWriter imageWriter = targetImage.getPixelWriter(); //PIXEL WRITER FOR NEW IMAGE
        
        // create the 4 copies as a negative
        for (int x = 0; x < width / 2; x++) {
            for (int y = 0; y < height / 2; y++) {
   
                Color color = imageReader.getColor(x * 2, y * 2);   // avoids pixels, results in lower definition image, not a resized image
                      //NEGATIVE
                double red = 1.0 - color.getRed();
                double green = 1.0 - color.getGreen();
                double blue = 1.0 - color.getBlue();
                
                Color negative = new Color(red, green, blue, color.getOpacity());
                
                imageWriter.setColor(x, y, negative);                               //TOP LEFT
                imageWriter.setColor(x + width / 2, y, negative);                   //TOP RIGHT
                imageWriter.setColor(x, y + height / 2, negative);                  //BOTTOM LEFT
                imageWriter.setColor(x + width / 2, y + height / 2, negative);      //BOTTOM RIGHT
            }
        }
        
        
        ImageView image = new ImageView(targetImage);
        Pane pane = new Pane();
        pane.getChildren().add(image);
        
        
        
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
