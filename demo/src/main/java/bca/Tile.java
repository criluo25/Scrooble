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
    // this is the stackpane
    private static final int tileSize = 40;
    private int row;
    private int col;
    private Text letter;
    private Board board;
    private Label label;
    private boolean isInLetterRow;

    public Tile(int row, int col, Board board) {
        this(row, col, board, false);
    }

    public Tile(int row, int col, Board board, boolean isInLetterRow) {
        this.row = row;
        this.col = col;
        this.board = board;
        this.letter = new Text();
        this.label = new Label();
        this.isInLetterRow = isInLetterRow;

        Rectangle border = new Rectangle(tileSize, tileSize);
        border.setFill(Color.BURLYWOOD);
        border.setStroke(Color.BLACK);

        getChildren().addAll(border, letter, label);
        setStyle("-fx-border-color: black; -fx-background-color: white;");

        if (isInLetterRow) {
            System.out.println("Letter tile initialized.");
            this.setOnMouseClicked(this::handleLetterRowClick);
        } else {
            this.setOnMouseClicked(this::handleGridClick);
        }
    }

    private void handleLetterRowClick(MouseEvent event) {
        System.out.println("Letter tile clicked.");
        if (!letter.getText().isEmpty()) {
            App.setSelectedLetter(this);
        }
    }

    private void handleGridClick(MouseEvent event) {
        System.out.println("Grid tile clicked.");
        if (App.getSelectedLetter() != null) {
            Tile selectedTile = App.getSelectedLetter();
            placeTile(selectedTile.getLetter().charAt(0));
            selectedTile.clearTile();
            App.setSelectedLetter(null);
        }
    }

    public void placeTile(char tile) {
        letter.setText(String.valueOf(tile));
    }

    public String getLetter() {
        return letter.getText();
    }

    public void clearTile() {
        letter.setText("");
    }
}
