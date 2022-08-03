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
        return product +
                ";" + purchasedUnits + ";" + this.getCost().getCents();
    }

    @Override
    public int compareTo(AbstractPurchase o) {
     //   return 0;
        return o.getCost().compareTo(this.getCost());
    }

}

class EveryUnitDiscountedPurchase extends AbstractPurchase {

    public EveryUnitDiscountedPurchase(Product product, int purchasedUnits) {
        this.product = product;
        this.purchasedUnits = purchasedUnits;
    }

    @Override
    public Euro getCost() {
        // discount for each is 50
        return new Euro((product.getPrice().getCents() - 50) * purchasedUnits);
    }
}

class GreaterThanConstantDiscountedPurchase extends AbstractPurchase {
    // discount is 8.795
    private final double discount = 8.795;
    private final int exceedQuantity = 15;
    public GreaterThanConstantDiscountedPurchase(Product product, int purchasedUnits) {
        this.product = product;
        this.purchasedUnits = purchasedUnits;
    }

    @Override
    public Euro getCost() {
        //quantity to exceed is 15
        if (purchasedUnits > exceedQuantity) {
            return new Euro((int) Math.floor(product.getPrice().getCents() * purchasedUnits * (1 - discount / 100)));
        } else {
            return new Euro(product.getPrice().getCents()* purchasedUnits);
        }
    }
}

class AdditionForTransportExpensesPurchase extends AbstractPurchase {
    // addition is 25
    private final int addition = 25;
    public AdditionForTransportExpensesPurchase(Product product, int purchasedUnits) {
        this.product = product;
        this.purchasedUnits = purchasedUnits;
    }

    @Override
    public Euro getCost() {
        return new Euro(product.getPrice().getCents() * purchasedUnits + addition);
    }
}
