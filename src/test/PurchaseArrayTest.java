package test;

import main.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class PurchaseArrayTest {
    private PurchaseArray testArr = new PurchaseArray(new AbstractPurchase[]{
            new EveryUnitDiscountedPurchase(new Product("apple", new Euro(500)),50, new Euro(40)),
            new GreaterThanConstantDiscountedPurchase(new Product("pineapple", new Euro(997)),50, 8.75),
            new AdditionForTransportExpensesPurchase(new Product("carrot", new Euro(666)),50, new Euro(12)),
            new EveryUnitDiscountedPurchase(new Product("pear", new Euro(1482)),10, new Euro(2)),
            new GreaterThanConstantDiscountedPurchase(new Product("ice cream", new Euro(1111)),12, 9.39),
            new AdditionForTransportExpensesPurchase(new Product("meat", new Euro(111155)),3, new Euro(1))
    });
    private PurchaseArray mustComply = new PurchaseArray(new AbstractPurchase[]{
            new AdditionForTransportExpensesPurchase(new Product("meat", new Euro(111155)),3, new Euro(1)),
            new GreaterThanConstantDiscountedPurchase(new Product("pineapple", new Euro(997)),50, 8.75),
            new AdditionForTransportExpensesPurchase(new Product("carrot", new Euro(666)),50, new Euro(12)),
            new EveryUnitDiscountedPurchase(new Product("apple", new Euro(500)),50, new Euro(40)),
            new EveryUnitDiscountedPurchase(new Product("pear", new Euro(1482)),10, new Euro(2)),
            new GreaterThanConstantDiscountedPurchase(new Product("ice cream", new Euro(1111)),12, 9.39)
    });
    @Test
    void validateSort() {
        testArr.sort();
        assertEquals(mustComply,testArr);
    }

    @Test
    void getMinimalCostTest() {
        testArr.sort();
        assertEquals("Minimum cost = " + 13300,testArr.getMinimalCost());
    }

    @Test
    void searchTestOne() {
        testArr.sort();
        assertEquals(2, testArr.search(33300));
    }

    @Test
    void searchTestTwo() {
        testArr.sort();
        assertEquals(-1, testArr.search(13567));
    }
    @Test
    void searchTestThree() {
        testArr.sort();
        assertEquals(-1, testArr.search(111));
    }
}