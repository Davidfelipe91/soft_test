package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    public Double applyDiscount(Double price, Double percentage){
        if (percentage < 0  || percentage > 100){
            throw new IllegalArgumentException("The percentage must be between 0 and 100");
        }
        return  price - (price * percentage/100);
    };
}
