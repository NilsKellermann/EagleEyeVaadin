package de.sag.EagleEye.logic.employee;

public abstract class Employee {

	double hourlyWage;
	String name;

	public Employee(String name, double hourlyWage) {
		this.name = name;
		this.hourlyWage = hourlyWage;
	}

	public Employee(String name) {
		this(name, 8.50);
		this.name = name;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public double getHourlyWage() {
		return hourlyWage;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
