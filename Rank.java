package toBeCompleted.stage1;

public class Rank {
    public String name;
    public char symbol;
    public int value;

    public Rank(String name, char symbol, int value) {
        this.name = name;
        this.symbol = symbol;
        this.value = value;
    }

    public int compareTo(Rank other) {
        return this.value - other.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rank other = (Rank) obj;
        return this.value == other.value &&
               this.symbol == other.symbol &&
               (this.name != null ? this.name.equals(other.name) : other.name == null);
    }

    @Override
    public String toString() {
        return name;
    }
}
