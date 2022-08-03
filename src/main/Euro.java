package main;

class Euro implements Comparable<Euro> {
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
}
