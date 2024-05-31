package bca;
import java.util.*;

public class Player {
    private ArrayList<Character> hand;
    private Alphabet alphabet;

    public Player() {
        alphabet = Game.getAlphabet();
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