package bca;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    private static final int boardSize = 15;
    private Player player;
    private static Tile selectedLetter;
    private Board board;
    private ObjectOutputStream out;

    @Override
    public void start(Stage stage) {
        try {
            System.out.println("Attempting to connect to the server...");
            try (Socket socket = new Socket("localhost", 54323)) {
                System.out.println("Connected to the server.");
                out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                List<Letter> letters = readLetters(in);
                player = new Player(new ArrayList<>(letters));
                board = (Board) in.readObject();

                GridPane gridPane = createBoardGrid();
                BorderPane borderPane = new BorderPane();

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

                GridPane letterRow = createLetterRow(letters);
                letterRow.setAlignment(Pos.CENTER);
                borderPane.setBottom(letterRow);
                Text title = new Text(50, 50, "Scrooble");
                title.setFont(new Font(20));
                Scene scene = new Scene(borderPane, 600, 600);
                stage.setScene(scene);
                stage.setTitle("Scrooble");
                stage.show();

                new Thread(() -> {
                    try {
                        while (true) {
                            board = (Board) in.readObject();
                            updateBoard(gridPane);
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }).start();
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<Letter> readLetters(ObjectInputStream in) throws IOException, ClassNotFoundException {
        Object obj = in.readObject();
        if (obj instanceof List<?>) {
            List<?> list = (List<?>) obj;
            List<Letter> letterList = new ArrayList<>();
            for (Object item : list) {
                if (item instanceof Letter) {
                    letterList.add((Letter) item);
                } else {
                    throw new ClassCastException("List contains non-Letter objects");
                }
            }
            return letterList;
        }
        throw new ClassCastException("Object is not an ArrayList");
    }

    private GridPane createBoardGrid() {
        GridPane gridPane = new GridPane();
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                Tile tilePane = new Tile(row, col, board);
                gridPane.add(tilePane, col, row);
            }
        }
        gridPane.setPrefSize(GridPane.USE_COMPUTED_SIZE, GridPane.USE_COMPUTED_SIZE);
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }

    private GridPane createLetterRow(List<Letter> letters) {
        GridPane letterRow = new GridPane();

        for (int i = 0; i < 7; i++) {
            Tile tile = new Tile(0, i, new Board(), true);
            tile.placeTile(letters.get(i).letter());
            letterRow.add(tile, i, 0);
        }

        return letterRow;
    }

    private void updateBoard(GridPane gridPane) {
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                Tile tile = (Tile) gridPane.getChildren().get(row * boardSize + col);
                char letter = board.getTile(row, col);
                if (letter != '\0') {
                    tile.placeTile(letter);
                }
            }
        }
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