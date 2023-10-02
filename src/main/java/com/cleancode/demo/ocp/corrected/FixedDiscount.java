package com.cleancode.demo.ocp.corrected;
public class FixedDiscount implements Discount {

    @Override
    public double calculateDiscount(double totalPrice) {
        return 50; // $50 fixed discount
    }
}

