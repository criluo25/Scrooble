package bca;

public class Board {
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
}
