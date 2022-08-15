package main;

public class GreaterThanConstantDiscountedPurchase extends AbstractPurchase {
    private final double discount;
    private final static int EXCEED_QUANTITY = 15;

    public GreaterThanConstantDiscountedPurchase(Product product, int purchasedUnits, double discount) {
        super(product, purchasedUnits);
        this.discount = discount;
    }

    @Override
    public Euro getFinalCost(Euro baseCost) {
        //quantity to exceed is 15
        if (purchasedUnits > EXCEED_QUANTITY) {
            baseCost = baseCost.mul(1 - discount/100, RoundMethod.ROUND, 0);
        }
        return baseCost;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}
