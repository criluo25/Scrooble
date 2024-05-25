package bca;

import javafx.print.Collation;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Tile extends StackPane {
    //this is the stackpane
    private static final int tileSize = 40;
    private int row;
    private int col;
    private Text letter;
    private Board board;
    private Label label;

    public Tile (int row, int col, Board board) {
        this.row = row;
        this.col = col;
        this.board = board;
        this.letter = new Text();
        this.label = new Label();
        getChildren().add(label);
        setStyle("-fx-border-color: black; -fx-background-color: white;");

        Rectangle border = new Rectangle(tileSize, tileSize);
        border.setFill(Color.BURLYWOOD);
        border.setStroke(Color.BLACK);

        setOnMouseClicked((MouseEvent event) -> {
            // Request focus on the tile when it is clicked
            this.requestFocus();
        });

        setOnKeyPressed((KeyEvent event) -> {
            String character = event.getText();
            if (character.matches("[a-zA-Z]")) {
                placeTile(character.toUpperCase().charAt(0));
            }
        });

        getChildren().addAll(border, letter);
    }

public void placeTile(char tile) {
    letter.setText(String.valueOf(tile));
}
}
