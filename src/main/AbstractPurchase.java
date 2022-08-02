package main;

abstract class AbstractPurchase implements Comparable{
    protected Product product;
    protected int purchasedUnits;


    public static void main(String[] args) {
        Euro euro = new Euro(100);
        Product product = new Product("gg", euro);
        GreaterThanConstantDiscountedPurchase greaterThanConstantDiscountedPurchase = new GreaterThanConstantDiscountedPurchase(product, 15);
        System.out.println(greaterThanConstantDiscountedPurchase.toString());
        System.out.println(greaterThanConstantDiscountedPurchase.getCost());
    }

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

    public int getCost() {
        return product.getPrice().getCents() * purchasedUnits;
    }

    @Override
    public String toString() {
        return product +
                "; purchasedUnits=" + purchasedUnits;
    }

    public void compareTo(AbstractPurchase purchase) {

    }

}

class EveryUnitDiscountedPurchase extends AbstractPurchase {

    public EveryUnitDiscountedPurchase(Product product, int purchasedUnits) {
        this.product = product;
        this.purchasedUnits = purchasedUnits;
    }

    @Override
    public int getCost() {
        // discount for each is 50
        return (product.getPrice().getCents() - 50) * purchasedUnits;
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
    public int getCost() {
        //quantity to exceed is 15
        if (purchasedUnits > exceedQuantity) {
            return (int) Math.floor(product.getPrice().getCents() * purchasedUnits * (1 - discount / 100));
        } else {
            return product.getPrice().getCents()* purchasedUnits;
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
    public int getCost() {
        return product.getPrice().getCents() * purchasedUnits + addition;
    }
}
