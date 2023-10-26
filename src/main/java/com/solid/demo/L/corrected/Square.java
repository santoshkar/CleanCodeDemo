package com.solid.demo.L.corrected;
class Square implements Shape {
    protected int side;

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}