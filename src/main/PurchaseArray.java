package main;

import java.util.Arrays;
import java.util.Comparator;


public class PurchaseArray {
    private final AbstractPurchase[] purchases;

    public PurchaseArray(AbstractPurchase[] purchases) {
        this.purchases = purchases;
    }

    public void printArr(){
        for(int i = 0; i < purchases.length; i++) {
            System.out.println(purchases[i]);
        }
    }

    public void sort(){
        Arrays.sort(purchases);
    }

}
