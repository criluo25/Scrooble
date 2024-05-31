package bca;

public class Letter {
    private int pointValue;
    private char letter;

    public Letter(int pv, char l) {
        pointValue = pv;
        letter = l;
    }

    public int pointValue() {
        return pointValue;
    }
    public int letter() {
        return letter;
    }
}