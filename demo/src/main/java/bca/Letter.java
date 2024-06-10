package bca;

import java.io.Serializable;

public class Letter implements Serializable {
    private static final long serialVersionUID = 1L;
    private int pointValue;
    private char letter;

    public Letter(int pv, char l) {
        pointValue = pv;
        letter = l;
    }

    public int pointValue() {
        return pointValue;
    }
    
    public char letter() {
        return letter;
    }
}