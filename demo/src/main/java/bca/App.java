package bca;

import javafx.application.Application;
import javafx.collections.ArrayChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    private static final int boardSize = 15;
    private static final int tileSize = 40;
    // private static final int

    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        BorderPane borderPane = new BorderPane();
        Board board = new Board();
        

        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                Rectangle tile = new Rectangle(tileSize, tileSize);
                tile.setFill(Color.BURLYWOOD);
                tile.setStroke(Color.BLACK);
                Tile tilePane = new Tile(row, col, board);
                gridPane.add(tilePane, col, row);
            }
        }

        gridPane.setPadding(new Insets(10, 10, 20, 10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        borderPane.setCenter(gridPane);
        Scene scene = new Scene(gridPane, 600, 600);
        stage.setScene(scene);
        stage.setTitle("Scrooble");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}