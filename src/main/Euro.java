package main;

public class Euro implements Comparable<Euro> {
    private int cents;

    public Euro() {}

    public Euro(int cents) {
        this.cents = cents;
    }

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents = cents;
    }

    @Override
    public int compareTo(Euro o) {
        return this.cents - o.cents;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Euro) || (obj == null)) {
            return false;
        }

        Euro other = (Euro) obj;

        return this.cents == other.cents;
    }
}
