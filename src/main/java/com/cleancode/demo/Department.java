package com.cleancode.demo;

import java.util.List;

public abstract class Department {

	private int id;

	public abstract List<Employee> getEmployees();

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
