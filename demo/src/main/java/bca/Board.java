package bca;

import java.io.Serializable;

public class Board implements Serializable {
    private static final long serialVersionUID = 1L;
    private char[][] tiles;

    public Board() {
        tiles = new char[15][15];
    }

    public boolean placeTile(int row, int col, char tile) {
        if (tiles[row][col] == '\0') {
            tiles[row][col] = tile;
            return true;
        }
        return false;
    }

    public char getTile(int row, int col) {
        return tiles[row][col];
    }
}
