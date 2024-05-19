package toBeCompleted.stage4;

import toBeCompleted.stage3.*;

public class HandNodeA {
    public Hand hand;
    public HandNodeA next;

    /**
     * Constructor for HandNodeA
     * @param hand
     * @param next
     */
    public HandNodeA(Hand hand, HandNodeA next) {
        this.hand = hand;
        this.next = next;
    }

    /**
     * @return the number of hands in the linked list.
     */
    public int size() {
        if (this.next == null) {
            return 1;
        }
        return 1 + this.next.size();
    }

    /**
     * @param idx
     * @return the hand at the given index in the linked list, null if index is out of bounds.
     * (first hand is at index 0)
     */
    public Hand get(int idx) {
        if (idx == 0) {
            return this.hand;
        }
        if (this.next == null) {
            return null;
        }
        return this.next.get(idx - 1);
    }

    /**
     * @return the FIRST hand starting at the calling object
     * that is a "sequence" OR has all cards of the same suit.
     * NOTE: This is a simplified implementation, and not really
     * a fair evaluation of who should actually win - that is an advanced 
     * algorithm, tackled by winnerAdvanced.
     */
    public Hand winner() {
        HandNodeA current = this;
        while (current != null) {
            if (current.hand.allSameSuit()) {
                return current.hand;
            }
            current = current.next;
        }
        current = this;
        while (current != null) {
            if (current.hand.sequence()) {
                return current.hand;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * @return the correct winner according to following rules:
     * 
     * 1. Sequence + Same Suit trumps Same Suit
     * 2. Same Suit trumps Sequence
     * 3. Sequence trumps value
     * 
     * In case of tie, use value as a resolver.
     * If there is still a tie, the hand that appears first in the list is the winner.
     */
    public Hand winnerAdvanced() {
        HandNodeA current = this;
        Hand bestHand = null;

        while (current != null) {
            if (bestHand == null) {
                bestHand = current.hand;
            } else {
                boolean bestIsSequence = bestHand.sequence();
                boolean bestIsSameSuit = bestHand.allSameSuit();
                boolean bestIsSequenceAndSameSuit = bestIsSequence && bestIsSameSuit;

                boolean currentIsSequence = current.hand.sequence();
                boolean currentIsSameSuit = current.hand.allSameSuit();
                boolean currentIsSequenceAndSameSuit = currentIsSequence && currentIsSameSuit;

                if (currentIsSequenceAndSameSuit && !bestIsSequenceAndSameSuit) {
                    bestHand = current.hand;
                } else if (currentIsSameSuit && !currentIsSequenceAndSameSuit && !bestIsSequenceAndSameSuit) {
                    if (bestIsSameSuit && !bestIsSequenceAndSameSuit) {
                        if (current.hand.value() > bestHand.value()) {
                            bestHand = current.hand;
                        }
                    } else if (!bestIsSequence) {
                        bestHand = current.hand;
                    }
                } else if (currentIsSequence && !currentIsSameSuit && !bestIsSameSuit && !bestIsSequenceAndSameSuit) {
                    if (bestIsSequence && !bestIsSameSuit) {
                        if (current.hand.value() > bestHand.value()) {
                            bestHand = current.hand;
                        }
                    } else {
                        bestHand = current.hand;
                    }
                } else if (current.hand.value() > bestHand.value()) {
                    bestHand = current.hand;
                }
            }
            current = current.next;
        }

        return bestHand;
    }

    //DO NOT MODIFY
    public String toString() {
        if(next == null) {
            return hand.toString();
        }
        return hand.toString() + " \n" + next.toString();
    }

    //DO NOT MODIFY
    public String toStringCompact() {
        if(next == null) {
            return hand.toStringCompact();
        }
        return hand.toStringCompact() + " -> " + next.toStringCompact();
    }
}
