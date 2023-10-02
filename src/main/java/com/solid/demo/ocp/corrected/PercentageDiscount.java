package com.solid.demo.ocp.corrected;
public class PercentageDiscount implements Discount {

    @Override
    public double calculateDiscount(double totalPrice) {
        return totalPrice * 0.2; // 20% discount
    }
}

