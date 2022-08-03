package main;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase>{
    protected Product product;
    protected int purchasedUnits;

    public AbstractPurchase() {}

    public AbstractPurchase(Product product, int purchasedUnits) {
        this.product = product;
        this.purchasedUnits = purchasedUnits;
    }

    public int getPurchasedUnits() {
        return purchasedUnits;
    }

    public void setPurchasedUnits(int purchasedUnits) {
        this.purchasedUnits = purchasedUnits;
    }

    public Euro getCost() {
        return new Euro(product.getPrice().getCents() * purchasedUnits);
    }

    @Override
    public String toString() {
        return product + ";" + purchasedUnits + ";" + this.getCost().getCents();
    }

    @Override
    public int compareTo(AbstractPurchase o) {
     //   return 0;
        return o.getCost().compareTo(this.getCost());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractPurchase) || (obj == null)) {
            return false;
        }

        AbstractPurchase another = (AbstractPurchase) obj;

        return this.product.equals(another.product) && this.purchasedUnits == another.purchasedUnits;
    }
}

