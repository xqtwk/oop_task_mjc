package main;


import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {

        PurchaseArray products = new PurchaseArray(new AbstractPurchase[]{
            new EveryUnitDiscountedPurchase(new Product("apple", new Euro(500)), 50),
            new GreaterThanConstantDiscountedPurchase(new Product("pineapple", new Euro(997)),50),
            new AdditionForTransportExpensesPurchase(new Product("carrot", new Euro(666)),50),
            new EveryUnitDiscountedPurchase(new Product("pear", new Euro(1482)),10),
            new GreaterThanConstantDiscountedPurchase(new Product("ice cream", new Euro(1111)),12),
            new AdditionForTransportExpensesPurchase(new Product("meat", new Euro(111155)),3)
        });

        // NAME;UNIT PRICE;AMOUNT;TOTAL COST
        products.printArr();
        System.out.println();
        products.sort();
        products.printArr();
        System.out.println(products.getMinimalCost());
        // somewhy it can only find with cost of 33325 (or index 2)
        int cost = 33325;
        if (products.search(cost) < 0) {
            System.out.println("Purchase not found");
        } else {
            products.printByIndex(products.search(cost));
        }
    }
}
