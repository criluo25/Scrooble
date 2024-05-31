package bca;
import java.util.*;

public class Player {
    private ArrayList<Letter> hand;
    private Alphabet alphabet;

    public Player(Game game, Alphabet alph) {
        alphabet = alph;
        hand = alphabet.get(7);
    }

    public boolean refill() {
        while (hand.size() < 7) {
            if (alphabet.isEmpty()) return false;
            hand.addAll(alphabet.get(1));
        }
        return true;
    }
}