package com.solid.demo.S.violation;

import lombok.Data;

@Data
public class Employee {
	private String name;
	private String department;
	private double salary;
	// Getters and setters for name, department, and salary

	public void saveToDatabase(Employee employee) {}
	public void generatePaySlip(Employee employee) {}
	public void sendEmailNotification(Employee employee) {}
	public void printReport(Employee employee) {}
}
