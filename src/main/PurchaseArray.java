package main;

import java.util.Arrays;


public class PurchaseArray {
    private final AbstractPurchase[] purchases;

    public PurchaseArray(AbstractPurchase[] purchases) {
        this.purchases = purchases;
    }

    public void printArr(){
        for(AbstractPurchase purchase : purchases) {
            System.out.println(purchase);
        }
    }
    public void printByIndex(int index) {
        System.out.println(purchases[index]);
    }

    public void sort(){
        Arrays.sort(purchases);
    }

    public String getMinimalCost(){
        // new array, so the original doesn't gets sorted
        AbstractPurchase[] array = purchases.clone();
        Arrays.sort(array);
        return "Minimum cost = " + array[array.length-1].getCost();
    }

    public int search(int value) {
        return Arrays.binarySearch(purchases,
                new AdditionForTransportExpensesPurchase(new Product("product", new Euro(value)), 1, new Euro(0)));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PurchaseArray) || (obj == null)) {
            return false;
        }

        PurchaseArray another = (PurchaseArray) obj;

        return  Arrays.equals(this.purchases, another.purchases);
    }

}
