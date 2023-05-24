package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class TicTacToeApplication extends Application {
    private char currentPlayer = 'X';
    private Button[][] buttons;
    private Font font = Font.font("Monospaced", 40);

    public static void main(String[] args) {
        launch(args);
    }

    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane borderPane = createBorderPane();

        Scene scene = new Scene(borderPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Toe"); // window title
        primaryStage.show();
    }

    private BorderPane createBorderPane() {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));
        
        Label turnLabel = new Label("Turn: " + currentPlayer);
        turnLabel.setFont(font);
        BorderPane.setAlignment(turnLabel, Pos.CENTER);
        borderPane.setTop(turnLabel);

        GridPane gridPane = createGridPane(turnLabel);
        borderPane.setCenter(gridPane);

        return borderPane;
    }

    private GridPane createGridPane(Label turnLabel) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        buttons = new Button[3][3];
        
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                
                Button button = new Button();
                button.setPrefSize(100, 100);
                button.setFont(font);
                
                //EVENT HANDLER
                button.setOnAction(e -> {

                    if (!isGameOver() && button.getText().isEmpty()) {
                        button.setText(Character.toString(currentPlayer));
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                        turnLabel.setText("Turn: " + currentPlayer);
                        
                        if (checkWin() || isBoardFull()) {
                            turnLabel.setText("The end!");
                            endGame();
                        }
                    }
                });
                
                buttons[row][col] = button;
                gridPane.add(button, col, row);
            }
        }
        return gridPane;
    }
    
    
    private boolean checkWin() {
        // check ROWS -- horizontal check
        for (int row = 0; row < 3; row++) {
            if (buttons[row][0].getText().equals(Character.toString(currentPlayer))
                    && buttons[row][1].getText().equals(Character.toString(currentPlayer))
                    && buttons[row][2].getText().equals(Character.toString(currentPlayer))) {
                return true;
            }
        }
        
        // check COLUMNS -- vertical check
        for (int col = 0; col < 3; col++) {
            if (buttons[0][col].getText().equals(Character.toString(currentPlayer))
                && buttons[1][col].getText().equals(Character.toString(currentPlayer))
                && buttons[2][col].getText().equals(Character.toString(currentPlayer))) {
                return true;
            }
        }
        
        
        // check DIAGONALS
        if (buttons[0][0].getText().equals(Character.toString(currentPlayer)) &&
            buttons[1][1].getText().equals(Character.toString(currentPlayer)) &&
            buttons[2][2].getText().equals(Character.toString(currentPlayer))) {
        return true;
        }

        if (buttons[0][2].getText().equals(Character.toString(currentPlayer)) &&
            buttons[1][1].getText().equals(Character.toString(currentPlayer)) &&
            buttons[2][0].getText().equals(Character.toString(currentPlayer))) {
            return true;
        }
        
        return false;
    } 
    
    
    private void endGame() {
    // disable all buttons
        for (Button[] row : buttons) {
            for (Button button : row) {
                button.setDisable(true);
            }
        }
    }


    private boolean isBoardFull(){
        for (Button[] row : buttons) {
            for (Button button : row) {
                if (button.getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean isGameOver() {
        return checkWin() || isBoardFull();
    }    
}