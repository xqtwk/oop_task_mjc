package main;

abstract class AbstractPurchase implements Comparable{
    protected Product product;
    protected int purchasedUnits;

    public AbstractPurchase() {}

    public static void main(String[] args) {
        Euro euro = new Euro(50,110);
        Product product = new Product("gg", euro);
        //AbstractPurchase abstractPurchase = new AbstractPurchase(product, 1){};
        EveryUnitDiscountedPurchase everyUnitDiscountedPurchase = new EveryUnitDiscountedPurchase(product, 10);
        System.out.println(everyUnitDiscountedPurchase.toString());
    }

    //public AbstractPurchase() {}

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
        return product.getPrice().getEuro() * purchasedUnits;
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
        super(product, purchasedUnits);
    }

    @Override
    public int getCost() {
            //product.setPrice(new Euro(10,10000));
        //int result = product.getPrice().getEuro() * 100;
        return product.getPrice().getEuro() * purchasedUnits*99;
    }
}

class GreaterThanConstantDiscountedPurchase extends AbstractPurchase {

}

class AdditionForTransportExpensesPurchase extends AbstractPurchase {

}
