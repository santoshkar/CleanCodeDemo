package com.cleancode.demo.ocp.corrected;
public class DiscountCalculator {

    public double calculateDiscount(Discount discount, double totalPrice) {
        return discount.calculateDiscount(totalPrice);
    }
}
