package com.solid.demo.ocp.violation;
public class DiscountCalculator {
    public double calculateDiscount(double totalPrice, String discountType) {
        if (discountType.equals("percentage")) {
            return totalPrice * 0.2; // 20% discount
        } else if (discountType.equals("fixed")) {
            return 50; // $50 fixed discount
        } else {
            throw new IllegalArgumentException("Invalid discount type");
        }
    }
}
