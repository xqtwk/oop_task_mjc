package main;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {

        PurchaseArray products = new PurchaseArray(new AbstractPurchase[]{
            new EveryUnitDiscountedPurchase(new Product("apple", new Euro(183)), 50),
            new GreaterThanConstantDiscountedPurchase(new Product("pineapple", new Euro(997)),8),
            new AdditionForTransportExpensesPurchase(new Product("carrot", new Euro(666)),44),
            new EveryUnitDiscountedPurchase(new Product("pear", new Euro(1482)),10),
            new GreaterThanConstantDiscountedPurchase(new Product("ice cream", new Euro(1111)),12),
            new AdditionForTransportExpensesPurchase(new Product("meat", new Euro(111155)),3)
        });
        // NAME;PRICE;AMOUNT;TOTAL COST
        products.printArr();
        System.out.println("\n");
        products.sort();
        products.printArr();
    }
}
