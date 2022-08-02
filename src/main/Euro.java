package main;

class Euro {
    private int euro;
    private int cents;

    public Euro() {}

    public Euro(int euro, int cents) {
        while (cents >= 100) {
            cents -= 100;
            euro++;
        }
        this.euro = euro;
        this.cents = cents;
    }

    public int getEuro() {
        return euro;
    }

    public void setEuro(int euro) {
        this.euro = euro;
    }

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents = cents;
    }
}
