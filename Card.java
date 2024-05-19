package toBeCompleted.stage1;

public class Card {
    public Suit suit;
    public Rank rank;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    public int value() {
        return rank.value * 10 + suit.value;
    } 

    public int compareTo(Card other) {
        return this.value() - other.value();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card other = (Card) obj;
        return (this.rank.equals(other.rank) && this.suit.equals(other.suit));
    }
    
    

    @Override
    public String toString() {
        return rank.symbol + "" + suit.symbol;
    }
}
