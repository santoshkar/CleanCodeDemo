package com.example.demo;

import java.util.List;

public abstract class Department {

	private long id;
	
	public abstract List<Employee> getEmployees();
		

	public void setId(long id){
		this.id = id;
	}
	
	public long getId(){
		return id;
	}
}
