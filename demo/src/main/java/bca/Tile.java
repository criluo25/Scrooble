package bca;

import javafx.print.Collation;
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

    public Tile (int row, int col, Board board) {
        this.row = row;
        this.col = col;
        this.board = board;
        this.letter = new Text();

        Rectangle border = new Rectangle(tileSize, tileSize);
        border.setFill(Color.BURLYWOOD);
        border.setStroke(Color.BLACK);

        setOnMouseClicked(event -> placeTile('A'));

        getChildren().addAll(border, letter);
    }

    public void placeTile (char tile) {
        letter.setText(String.valueOf(tile));
        board.placeTile(row, col, tile);
    }
}
