package main;

public class GreaterThanConstantDiscountedPurchase extends AbstractPurchase {
    // discount is 8.795
    private final double discount = 8.795;
    private final int exceedQuantity = 15;

    public GreaterThanConstantDiscountedPurchase(Product product) {
        this.product = product;
    }

    public GreaterThanConstantDiscountedPurchase(Product product, int purchasedUnits) {
        super(product, purchasedUnits);
        this.product = product;
        this.purchasedUnits = purchasedUnits;
    }

    @Override
    public Euro getCost() {
        //quantity to exceed is 15
        if (purchasedUnits > exceedQuantity) {
            return new Euro((int) Math.floor(product.getPrice().getCents() * purchasedUnits * (1 - discount / 100)));
        } else {
            return new Euro(product.getPrice().getCents() * purchasedUnits);
        }
    }
}
