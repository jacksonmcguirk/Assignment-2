package toBeCompleted.stage5;
 
import toBeCompleted.stage3.*;

/**
 * A doubly linked list of Hand objects
 */
public class HandNodeB {
    public Hand hand;
    
    public HandNodeB previous;
    public HandNodeB next;

    /**
     * Constructor for HandNodeB
     * @param hand
     * @param previous
     * @param next
     */
    public HandNodeB(Hand hand, HandNodeB previous, HandNodeB next) {
        //TODO
    }

    /**
     * 
     * @return number of items in the list in which the calling object sits.
     * IMPORTANT: the calling object might NOT be the last (or the first) item in the list.
     */
    public int size() {
        return 0; //TODO
    }

    /**
     * 
     * @param idx
     * @return the object at the given index in the linked list in which the calling object sits, 
     * null if index is out of bounds.
     * (first item in the list is at index 0).
     * IMPORTANT: the calling object might NOT be the first (or the last) item in the list.
     */
    public HandNodeB get(int idx) {
        return null; //TODO
    }
    
    /**
     * 
     * @return the FIRST hand in the list in which the calling object sits,
     * that is a "sequence" OR has all cards of the same suit.
     * NOTE: This is a simplified implementation, and not really
     * a fair evaluation of who should actually win - that is an advanced 
     * algorithm, tackled by winnerAdvanced.
     * 
     * return null if none of the cards have a "sequence" or all cards are of the same suit
     */
    public Hand winner() {
        return null; //TODO
    }

    /**
     * 
     * @return a compact String representation of the list in which the calling object lies,
     * from first to last.
     * IMPORTANT: the calling object might NOT be the first (or the last) item in the list.
     */
    public String toStringCompact() {
        return ""; //TODO
    }

    /**
     * 
     * @return String representation of the list in which the calling object lies,
     * from first to last.
     * IMPORTANT: the calling object might NOT be the first (or the last) item in the list.
     */
    public String toString() {
        return ""; //TODO
    }

    /**
     * 
     * @return String representation of the list in which the calling object lies,
     * from last to first.
     * IMPORTANT: the calling object might NOT be the last (or the first) item in the list.
     */
    public String toStringReverse() {
        return ""; //TODO
    }

    /**
     * remove the hand at the given index from the list in which the calling object sits.
     * IMPORTANT: the calling object might NOT be the first item in the list.
     * (first hand is at index 0)
     * 
     * @param idx
     */
    public void playerQuits(int idx) {
        //TODO
    }

    /**
     * 
     * @return the correct winner in the ENTIRE LIST that the calling object is a part of,
     * according to following rules:
     * 
     * 1. Sequence + Same Suit trumps Same Suit
     * 2. Same Suit trumps Sequence
     * 3. Sequence trumps value
     * 
     * In case of tie, use value as a resolver.
     * If there is still a tie, the hand that appears first in the list is the winner.

     * 
     * IMPORTANT: The winner might be BEFORE the calling object too!!!
     */
    public Hand winnerAdvanced() {
        return null; //TODO
    }
}
