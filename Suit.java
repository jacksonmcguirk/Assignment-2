package toBeCompleted.stage1;

public class Suit {
    public String name;
    public char symbol;
    public String color;
    public int value;

    public Suit(String name, char symbol, String color, int value) {
        this.name = name;
        this.symbol = symbol;
        this.color = color;
        this.value = value;
    }

    public int compareTo(Suit other) {
        return this.value - other.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Suit other = (Suit) obj;
        return this.value == other.value &&
               this.symbol == other.symbol &&
               this.color.equals(other.color) &&
               (this.name != null ? this.name.equals(other.name) : other.name == null);
    }

    @Override
    public String toString() {
        return name;
    }
}
