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

    private ArrayList<Letter> letters;
    
    public Alphabet() {
        fill();
    }

    public void shuffle() {
        for (int i = 0; i < letters.size()-1; i++) {
            int change = (int) (Math.random()*(letters.size()-i)) + i;
            Letter temp = letters.get(change);
            letters.set(change, letters.get(i));
            letters.set(i, temp);
        }
    }

    public ArrayList<Letter> get(int num) {
        ArrayList<Letter> temp = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            temp.add(letters.remove(letters.size()-1));
        }
        return temp;
    }

    public boolean isEmpty() {
        return letters.size() == 0;
    }

    private void fill() {
        add(new Letter(1,'E'), 12);
        add(new Letter(1,'A'), 9);
        add(new Letter(1,'I'), 9);
        add(new Letter(1,'O'), 8);
        add(new Letter(1,'N'), 6);
        add(new Letter(1,'R'), 6);
        add(new Letter(1,'T'), 6);
        add(new Letter(1,'L'), 4);
        add(new Letter(1,'S'), 4);
        add(new Letter(1,'U'), 4);
        add(new Letter(2,'D'), 4);
        add(new Letter(2,'G'), 3);
        add(new Letter(3,'B'), 2);
        add(new Letter(3,'C'), 2);
        add(new Letter(3,'M'), 2);
        add(new Letter(3,'P'), 2);
        add(new Letter(4,'F'), 2);
        add(new Letter(4,'H'), 2);
        add(new Letter(4,'V'), 2);
        add(new Letter(4,'W'), 2);
        add(new Letter(4,'Y'), 2);
        add(new Letter(5,'K'), 1);
        add(new Letter(8,'J'), 1);
        add(new Letter(8,'X'), 1);
        add(new Letter(10,'Q'), 1);
        add(new Letter(10,'Z'), 1);
    }

    private void add(Letter l, int n) {
        for (int i = 0; i < n; i++) letters.add(l);
    }
}