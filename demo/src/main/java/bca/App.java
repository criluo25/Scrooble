package bca;

import javafx.application.Application;
import javafx.collections.ArrayChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    private static final int boardSize = 15;
    // private static final int tileSize = 
    // private static final int

    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        Board board = new Board();
        

        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                Tile tilePane = new Tile(row, col, board);
                gridPane.add(tilePane, col, row);
            }
        }

        Scene scene = new Scene(gridPane, 600, 600);
        stage.setScene(scene);
        stage.setTitle("Scrooble");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}