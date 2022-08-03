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
        assertEquals(450,new EveryUnitDiscountedPurchase(new Product("apple", new Euro(500)), testUnitsOne).getCost().getCents());
        assertEquals(4500,new EveryUnitDiscountedPurchase(new Product("apple", new Euro(500)), testUnitsTwo).getCost().getCents());
        assertEquals(45000,new EveryUnitDiscountedPurchase(new Product("apple", new Euro(500)), testUnitsThree).getCost().getCents());
    }
    @Test
    void GreaterThanConstantDiscountedPurchaseTest() {
        assertEquals(500,new GreaterThanConstantDiscountedPurchase(new Product("apple", new Euro(500)), testUnitsOne).getCost().getCents());
        assertEquals(5000,new GreaterThanConstantDiscountedPurchase(new Product("apple", new Euro(500)), testUnitsTwo).getCost().getCents());
        assertEquals(45602,new GreaterThanConstantDiscountedPurchase(new Product("apple", new Euro(500)), testUnitsThree).getCost().getCents());
        assertEquals(7296,new GreaterThanConstantDiscountedPurchase(new Product("apple", new Euro(500)), testUnitsFour).getCost().getCents());
    }
    @Test
    void AdditionForTransportExpensesPurchaseTest() {
        assertEquals(525,new AdditionForTransportExpensesPurchase(new Product("apple", new Euro(500)), testUnitsOne).getCost().getCents());
        assertEquals(5025,new AdditionForTransportExpensesPurchase(new Product("apple", new Euro(500)), testUnitsTwo).getCost().getCents());
        assertEquals(50025,new AdditionForTransportExpensesPurchase(new Product("apple", new Euro(500)), testUnitsThree).getCost().getCents());
    }
}