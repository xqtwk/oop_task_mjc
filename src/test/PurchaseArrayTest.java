package test;

import main.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class PurchaseArrayTest {

    private PurchaseArray testArr = new PurchaseArray(new AbstractPurchase[]{
            new EveryUnitDiscountedPurchase(new Product("aaa", new Euro(500)), 50),
            new GreaterThanConstantDiscountedPurchase(new Product("bbb", new Euro(997)),8),
            new AdditionForTransportExpensesPurchase(new Product("ccc", new Euro(666)),44),
            new EveryUnitDiscountedPurchase(new Product("ddd", new Euro(1482)),10),
            new GreaterThanConstantDiscountedPurchase(new Product("eee", new Euro(1111)),12),
            new AdditionForTransportExpensesPurchase(new Product("ggg", new Euro(111155)),3)
    });
    private PurchaseArray mustComply = new PurchaseArray(new AbstractPurchase[]{
            new AdditionForTransportExpensesPurchase(new Product("ggg", new Euro(111155)),3),
            new AdditionForTransportExpensesPurchase(new Product("ccc", new Euro(666)),44),
            new EveryUnitDiscountedPurchase(new Product("aaa", new Euro(500)), 50),
            new EveryUnitDiscountedPurchase(new Product("ddd", new Euro(1482)),10),
            new GreaterThanConstantDiscountedPurchase(new Product("eee", new Euro(1111)),12),
            new GreaterThanConstantDiscountedPurchase(new Product("bbb", new Euro(997)),8)
    });
    @Test
    void validateSort() {
        testArr.sort();
        assertEquals(mustComply,testArr);
    }

    @Test
    void getMinimalCostTest() {
        testArr.sort();
        assertEquals("Minimum cost = " + 7976,testArr.getMinimalCost());
    }

    @Test
    void searchTestOne() {
        testArr.sort();
        assertEquals(2, testArr.search(22500));
    }

}