package bca;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    private static final int boardSize = 15;
    // private static final int tileSize = 15;
    // private static final int
    private Alphabet alphabet;
    private Player player;
    private static Tile selectedLetter;

    @Override
    public void start(Stage stage) {
        alphabet = new Alphabet();
        player = new Player(new Game(), alphabet);
        GridPane gridPane = new GridPane();
        BorderPane borderPane = new BorderPane();
        Board board = new Board();
        

        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                Tile tilePane = new Tile(row, col, board);
                gridPane.add(tilePane, col, row);
            }
        }

        gridPane.setPrefSize(GridPane.USE_COMPUTED_SIZE, GridPane.USE_COMPUTED_SIZE);
        gridPane.setAlignment(Pos.CENTER);
        StackPane stackPane = new StackPane(gridPane);
        stackPane.setAlignment(Pos.CENTER);
        borderPane.setPadding(new Insets(10, 10, 10, 10));
        borderPane.setCenter(stackPane);

        GridPane letterRow = createLetterRow();
        letterRow.setAlignment(Pos.CENTER);
        borderPane.setBottom(letterRow);

        Scene scene = new Scene(borderPane, 600, 600);
        stage.setScene(scene);
        stage.setTitle("Scrooble");
        stage.show();
    }

    private GridPane createLetterRow() {
        GridPane letterRow = new GridPane();
        ArrayList<Letter> letters = alphabet.get(7);

        for (int i = 0; i < 7; i++) {
            Tile tile = new Tile(0, i, new Board(), true);
            tile.placeTile(letters.get(i).letter());
            letterRow.add(tile, i, 0);
        }

        return letterRow;
    }

    public static void setSelectedLetter(Tile tile) {
        selectedLetter = tile;
    }

    public static Tile getSelectedLetter() {
        return selectedLetter;
    }

    public static void main(String[] args) {
        launch(args);
    }

}