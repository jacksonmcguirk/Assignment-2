package toBeCompleted.stage3;

import java.util.ArrayList;
import toBeCompleted.stage1.*;
import toBeCompleted.stage2.*;

@SuppressWarnings("unused")
public class Hand {
    public String player;
    public ArrayList<Card> cardsInHand;

    /**
     * Constructor 1 for Hand
     * Initializes the hand with n cards drawn from the deck
     * @param player. Assign "TBD" to instance variable if parameter is null
     * @param n
     * @param deck
     */
    public Hand(String player, int n, Deck deck) {
        this.player = player == null ? "TBD" : player;
        this.cardsInHand = new ArrayList<>();
        for (int i = 0; i < n && !deck.isEmpty(); i++) {
            this.cardsInHand.add(deck.drawCard());
        }
    }

    /**
     * Constructor 2 for Hand
     * @param player. Assign "TBD" to instance variable if parameter is null
     * @param cards ArrayList of cards to be copied into the instance variable
     */
    public Hand(String player, ArrayList<Card> cards) {
        this.player = player == null ? "TBD" : player;
        this.cardsInHand = new ArrayList<>(cards);
    }

    /**
     * Add a card to the hand
     * @param card
     * @return false if card is null, true otherwise
     */
    public boolean addCard(Card card) {
        if (card == null) {
            return false;
        }
        this.cardsInHand.add(card);
        return true;
    }

    /**
     * @param card
     * @return false if card is null or not in the hand, true otherwise
     * IMPORTANT: contains method of ArrayList checks for existence of a reference
     * that refers to the SAME instance as the parameter, but the tests are creating
     * clones, so you will need to figure out how to check the contents, rather than reference.
     * In short, do not use the contains method
     */
    public boolean hasCard(Card card) {
        if (card == null) {
            return false;
        }
        for (Card c : this.cardsInHand) {
            if (c.rank.equals(card.rank) && c.suit.equals(card.suit)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove a card from the hand
     * @return the card removed, null if the hand is empty
     */
    public Card removeRandomCard() {
        if (this.cardsInHand.isEmpty()) return null;
        return this.cardsInHand.remove((int) (Math.random() * this.cardsInHand.size()));
    }

    /**
     * Steal a card from another hand. Card should be removed from the other hand
     * @param other
     * @return the card stolen, null if the other hand is empty
     */
    public Card stealCardFrom(Hand other) {
        if (other == null || other.cardsInHand.isEmpty()) return null;
        Card stolen = other.removeRandomCard();
        this.cardsInHand.add(stolen);
        return stolen;
    }

    /**
     * Remove a card from the hand with a specific suit, if any
     * @param suitName
     * @return the card removed, null if the hand is empty or no card with the suit is found
     */
    public Card removeCardBySuit(String suitName) {
        for (Card card : this.cardsInHand) {
            if (card.suit.name.equalsIgnoreCase(suitName)) {
                this.cardsInHand.remove(card);
                return card;
            }
        }
        return null;
    }

    /**
     * @return the maximum number of cards in the hand that have the same suit.
     * For example, if the hand has 5 cards of hearts, 7 of diamonds and 3 of clubs, 
     * the method should return 7.
     * See test cases for examples.
     */
    public int sameSuitCards() {
        int heartsCount = 0;
        int diamondsCount = 0;
        int clubsCount = 0;
        int spadesCount = 0;

        for (Card card : this.cardsInHand) {
            switch (card.suit.name) {
                case "Hearts":
                    heartsCount++;
                    break;
                case "Diamonds":
                    diamondsCount++;
                    break;
                case "Clubs":
                    clubsCount++;
                    break;
                case "Spades":
                    spadesCount++;
                    break;
            }
        }

        return Math.max(Math.max(heartsCount, diamondsCount), Math.max(clubsCount, spadesCount));
    }

    /**
     * @return true if there are at least 3 cards in the hand and 
     * all cards in the hand have the same suit, false otherwise
     * See test cases for examples.
     */
    public boolean allSameSuit() {
        if (this.cardsInHand.size() < 3) return false;
        String suitName = this.cardsInHand.get(0).suit.name;
        for (Card card : this.cardsInHand) {
            if (!card.suit.name.equals(suitName)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Arrange the cards in the hand in ascending order of their values
     * In case of tie (when two cards have the same values), the card that originally occurred first
     * should occur first after the sorting is done.
     */
    public void arrange() {
        int n = this.cardsInHand.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (this.cardsInHand.get(j).rank.value > this.cardsInHand.get(j + 1).rank.value) {
                    // Swap cards[j] and cards[j + 1]
                    Card temp = this.cardsInHand.get(j);
                    this.cardsInHand.set(j, this.cardsInHand.get(j + 1));
                    this.cardsInHand.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * @return the length of the longest "sequence" of cards in the hand.
     * A sequence is defined as a series of cards, each with rank one more than the previous one.
     * IMPORTANT: Ace can be treated as rank 1 or 14 for this purpose.
     */
    public int sequenceLength() {
        ArrayList<Integer> values = new ArrayList<>();
        for (Card card : this.cardsInHand) {
            values.add(card.rank.value);
            if (card.rank.value == 14) { // Ace can be 1
                values.add(1);
            }
        }

        // Sort values using bubble sort
        int n = values.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (values.get(j) > values.get(j + 1)) {
                    int temp = values.get(j);
                    values.set(j, values.get(j + 1));
                    values.set(j + 1, temp);
                }
            }
        }

        int maxLength = 1;
        int currentLength = 1;
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) == values.get(i - 1) + 1) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else if (values.get(i) != values.get(i - 1)) {
                currentLength = 1;
            }
        }

        // Ensure we don't mistakenly count the Ace as both 1 and 14 in the same sequence
        if (maxLength == 14) {
            maxLength = 13;
        }

        return maxLength;
    }

    /**
     * @return true if the hand has at least 3 cards, and all cards form a complete sequence, false otherwise.
     * IMPORTANT: the cards don't need to be arranged in order to be considered a sequence.
     * Ace can be treated as rank 1 or 14 for this purpose.
     */
    public boolean sequence() {
        if (this.cardsInHand.size() < 3) {
            return false;
        }

        ArrayList<Integer> values = new ArrayList<>();
        for (Card card : this.cardsInHand) {
            values.add(card.rank.value);
            if (card.rank.value == 14) { // Ace can be 1
                values.add(1);
            }
        }

        // Sort values using bubble sort
        int n = values.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (values.get(j) > values.get(j + 1)) {
                    int temp = values.get(j);
                    values.set(j, values.get(j + 1));
                    values.set(j + 1, temp);
                }
            }
        }

        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) != values.get(i - 1) + 1) {
                return false;
            }
        }

        return true;
    }

    /**
     * @return true if the calling object has neither all same suit cards, 
     * nor a perfect sequence of cards; false otherwise
     */
    public boolean agreeToSwap() {
        return !allSameSuit() && !sequence();
    }

    /**
     * Swap a card from this hand with a random card from another hand, if both parties agree
     * (determined using agreeToSwap method)
     * @param idx index of the card in this hand to be swapped
     * @param other the other hand
     * @return true if the swap is successful, false otherwise
     */
    public boolean swap(int idx, Hand other) {
        if (this.agreeToSwap() && other.agreeToSwap()) {
            Card thisCard = this.cardsInHand.get(idx);
            Card otherCard = other.removeRandomCard();
            this.cardsInHand.set(idx, otherCard);
            other.addCard(thisCard);
            return true;
        }
        return false;
    }

    /**
     * @return the total value of the cards in the hand.
     */
    public int value() {
        int totalValue = 0;
        for (Card card : this.cardsInHand) {
            totalValue += card.rank.value;
        }
        return totalValue;
    }


    //DO NOT MODIFY
    public String toString() {
        if(cardsInHand.size() == 0) {
            return "Empty hand";
        }
        String special = "";
        if(allSameSuit() && sequence()) {
            special = "Same suit sequence";
        }
        else if(allSameSuit()) {
            special = "Same suit";
        }
        else if(sequence()) {
            special = "Sequence";
        }
        String result = "===================\n"+player+"'s "+cardsInHand.size()+"-card hand:\n";
        if(!special.isEmpty()) {
            result+=special+"\n";
        }
        for(Card card : cardsInHand) {
            result += card + ", ";
        }
        result = result.substring(0, result.length() - 2);
        result+="\nTotal value: "+value();
        return result+"\n===================\n";
    }

    //DO NOT MODIFY
    public String toStringCompact() {
        String s = this.player + ": ";
        if(allSameSuit()) {
            s += "SAME SUIT ";
        }
        if(sequence()) {
            s += "SEQUENCE ";
        }
        for(Card c: cardsInHand) {
            s += c.rank.symbol +"" + c.suit.symbol;
        }
        return s + " ("+value()+")";
    }
}
