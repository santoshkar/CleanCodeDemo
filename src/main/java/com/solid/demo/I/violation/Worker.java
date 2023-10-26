package com.solid.demo.I.violation;
interface Worker {
    void work();
    void eat();
    void sleep();
}

class Manager implements Worker {

    @Override
    public void work() {}

    @Override
    public void eat() {}

    @Override
    public void sleep() {}
}

class Developer implements Worker {

    @Override
    public void work() {}

    @Override
    public void eat() {}

    @Override
    public void sleep() {}
}
