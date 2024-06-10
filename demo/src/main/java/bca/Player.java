package bca;
import java.io.Serializable;
import java.util.*;

public class Player implements Serializable {
    private ArrayList<Letter> hand;
    private Alphabet alphabet;

    public Player(ArrayList<Letter> letters) {
        hand = letters;
    }

    public ArrayList<Letter> getHand() {
        return hand;
    }

    public boolean refill(Alphabet alphabet) {
        while (hand.size() < 7) {
            if (alphabet.isEmpty()) return false;
            hand.addAll(alphabet.get(1));
        }
        return true;
    }
}