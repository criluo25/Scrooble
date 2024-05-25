package bca;

import java.util.ArrayList;

public class Alphabet {
    // 1 point: E ×12, A ×9, I ×9, O ×8, N ×6, R ×6, T ×6, L ×4, S ×4, U ×4
    // 2 points: D ×4, G ×3
    // 3 points: B ×2, C ×2, M ×2, P ×2
    // 4 points: F ×2, H ×2, V ×2, W ×2, Y ×2
    // 5 points: K ×1
    // 8 points: J ×1, X ×1
    // 10 points: Q ×1, Z ×1

    ArrayList<Character> letters;
    
    public Alphabet() {
        fill();

    }

    private void fill() {
        add('E', 12);
        add('A', 9);
        add('I', 9);
        add('O', 8);
        add('N', 6);
        add('R', 6);
        add('T', 6);
        add('L', 4);
        add('S', 4);
        add('U', 4);
        add('D', 4);
        add('G', 3);
        add('B', 2);
        add('C', 2);
        add('M', 2);
        add('P', 2);
        add('F', 2);
        add('H', 2);
        add('V', 2);
        add('W', 2);
        add('Y', 2);
        add('K', 1);
        add('J', 1);
        add('X', 1);
        add('Q', 1);
        add('Z', 1);
    }

    private void add(char c, int n) {
        for (int i = 0; i < n; i++) letters.add(c);
    }
}