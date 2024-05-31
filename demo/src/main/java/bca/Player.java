package bca;
import java.util.*;

public class Player {
    private ArrayList<Character> hand;

    public Player() {
        hand = Game.getAlphabet().get(7);
    }
}