package com.solid.demo.I.corrected;
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}

class Manager implements Workable, Eatable, Sleepable {

	@Override
	public void sleep() {}

	@Override
	public void eat() {}

	@Override
	public void work() {}
    
}

class Developer implements Workable, Eatable, Sleepable {

	@Override
	public void sleep() {}
	@Override
	public void eat() {}

	@Override
	public void work() {}
}
