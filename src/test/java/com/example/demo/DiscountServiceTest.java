package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiscountServiceTest {
    final DiscountService discountService = new DiscountService();

    @Test
    void testApplyDiscountWithAssertEquals(){
        Double resultDiscount = discountService.applyDiscount(100.0, 10.0);
        assertEquals(90.0, resultDiscount);
    }

    @Test
    void testApplyDiscountWithThrows(){
        assertThrows(IllegalArgumentException.class, ()->{
            discountService.applyDiscount(100.0, 10.0);
        });
    }
}
