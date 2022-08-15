package test;

import main.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchasesTest {
    private int testUnitsOne = 1;
    private int testUnitsTwo = 10;
    private int testUnitsThree = 100;
    private int testUnitsFour= 16;
    @Test
    void EveryUnitDiscountedPurchaseTest() {
        assertEquals(400,new EveryUnitDiscountedPurchase(new Product("apple", new Euro(500)), testUnitsOne, new Euro(5)).getCost().getCents());
        assertEquals(4900,new EveryUnitDiscountedPurchase(new Product("apple", new Euro(500)), testUnitsTwo, new Euro(8)).getCost().getCents());
        assertEquals(48800,new EveryUnitDiscountedPurchase(new Product("apple", new Euro(500)), testUnitsThree, new Euro(12)).getCost().getCents());
    }
    @Test
    void GreaterThanConstantDiscountedPurchaseTest() {
        assertEquals(500,new GreaterThanConstantDiscountedPurchase(new Product("apple", new Euro(500)), testUnitsOne, 55).getCost().getCents());
        assertEquals(5000,new GreaterThanConstantDiscountedPurchase(new Product("apple", new Euro(500)), testUnitsTwo, 8.75).getCost().getCents());
        assertEquals(43800,new GreaterThanConstantDiscountedPurchase(new Product("apple", new Euro(500)), testUnitsThree, 12.22).getCost().getCents());
        assertEquals(7200,new GreaterThanConstantDiscountedPurchase(new Product("apple", new Euro(500)), testUnitsFour, 9.37).getCost().getCents());
    }
    @Test
    void AdditionForTransportExpensesPurchaseTest() {
        assertEquals(500,new AdditionForTransportExpensesPurchase(new Product("apple", new Euro(500)), testUnitsOne, new Euro(5)).getCost().getCents());
        assertEquals(5000,new AdditionForTransportExpensesPurchase(new Product("apple", new Euro(500)), testUnitsTwo,new Euro(33)).getCost().getCents());
        assertEquals(50000,new AdditionForTransportExpensesPurchase(new Product("apple", new Euro(500)), testUnitsThree, new Euro(44)).getCost().getCents());
    }
}