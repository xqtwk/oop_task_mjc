package main;

public class EveryUnitDiscountedPurchase extends AbstractPurchase {

    public EveryUnitDiscountedPurchase(Product product, int purchasedUnits) {
        super(product, purchasedUnits);
        this.product = product;
        this.purchasedUnits = purchasedUnits;
    }

    @Override
    public Euro getCost() {
        // discount for each is 50
        return new Euro((product.getPrice().getCents() - 50) * purchasedUnits);
    }
}
