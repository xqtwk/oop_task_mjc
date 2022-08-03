package main;

public class AdditionForTransportExpensesPurchase extends AbstractPurchase {
    // addition is 25
    private final int addition = 25;

    public AdditionForTransportExpensesPurchase(Product product, int purchasedUnits) {
        super(product, purchasedUnits);
        this.product = product;
        this.purchasedUnits = purchasedUnits;
    }

    @Override
    public Euro getCost() {
        return new Euro(product.getPrice().getCents() * purchasedUnits + addition);
    }
}
