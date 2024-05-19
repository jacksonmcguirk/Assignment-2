    /**
     * Constructor for Deck
     * Initializes the deck with 52 cards.
     * 13 ranks and 4 suits.
     * 
     * The four suits are:
     * Hearts (color = "red", symbol = '♥', value = 1),
     * Diamonds (color = "red", symbol = '♦', value = 2),
     * Clubs (color = "black", symbol = '♣', value = 3),
     * Spades (color = "black", symbol = '♠', value = 4)
     * 
     * The 13 ranks are:
     * 
     * name = "2", symbol = '2', value = 2
     * name = "3", symbol = '3', value = 3
     * name = "4", symbol = '4', value = 4
     * name = "5", symbol = '5', value = 5
     * name = "6", symbol = '6', value = 6
     * name = "7", symbol = '7', value = 7
     * name = "8", symbol = '8', value = 8
     * name = "9", symbol = '9', value = 9
     * name = "10", symbol = 'X', value = 10
     * name = "Jack", symbol = 'J', value = 11
     * name = "Queen", symbol = 'Q', value = 12
     * name = "King", symbol = 'K', value = 13
     * name = "Ace", symbol = 'A', value = 14
     * 
     * Besides ArrayList and the classes from stage 1,
     * the constructor should not import any other library/class,
     * even from within the project.
     */








package toBeCompleted.stage2;

import java.util.ArrayList;
import java.util.Collections;
import toBeCompleted.stage1.*;

public class Deck {
    public ArrayList<Card> cards;

    /**
     * Constructor for Deck
     * Initializes the deck with 52 cards.
     * 13 ranks and 4 suits.
     */
    public Deck() {
        cards = new ArrayList<>();
        Suit[] suits = {
            new Suit("Hearts", '♥', "red", 1),
            new Suit("Diamonds", '♦', "red", 2),
            new Suit("Clubs", '♣', "black", 3),
            new Suit("Spades", '♠', "black", 4)
        };
        Rank[] ranks = {
            new Rank("2", '2', 2),
            new Rank("3", '3', 3),
            new Rank("4", '4', 4),
            new Rank("5", '5', 5),
            new Rank("6", '6', 6),
            new Rank("7", '7', 7),
            new Rank("8", '8', 8),
            new Rank("9", '9', 9),
            new Rank("10", 'X', 10),
            new Rank("Jack", 'J', 11),
            new Rank("Queen", 'Q', 12),
            new Rank("King", 'K', 13),
            new Rank("Ace", 'A', 14)
        };

        // Loop through each suit, then each rank
        for (Suit suit : suits) {
            for (Rank rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    /**
     * Shuffles the deck using Collections.shuffle for better randomness
     * and compliance with most testing scenarios that assume efficient shuffling.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }
    // will be for future references.
    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

    /**
     * Draws a card from the top of the deck (end of the list).
     * @return Card drawn from the deck, null if deck is empty
     */
    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(cards.size() - 1);
        }
        return null;
    }

  //DO NOT MODIFY
  public String toString() {
    String result = "[";
    for(Card card : cards) {
        result += card + ", ";
    }
    return result.substring(0, result.length() - 2)+"]";
}
}








