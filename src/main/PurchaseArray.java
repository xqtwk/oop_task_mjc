package main;

import java.util.Arrays;
import java.util.Collections;
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
        return "Minimum cost = " + array[array.length-1].getCost().getCents();
    }

    public int search(int value) {
        /*
        SOMEWHY DOESN'T WORKS CORRECTLY
         */
        int[] costs = new int[purchases.length];
        for(int i = 0; i < purchases.length; i++){
            costs[i] = purchases[i].getCost().getCents();
        }
        return Arrays.binarySearch(costs, value);
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
