package de.sag.EagleEye.logic.employee;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

	private List<Employee> employeeList;

	public Manager(String name, double hourlyWage, List<Employee> employeeList) {
		this(name, hourlyWage);
		this.employeeList = employeeList;
	}

	public Manager(String name, double hourlyWage) {
		super(name);
		this.employeeList = new ArrayList<Employee>();

	}

	public void addEmployee(Employee emp) {
		this.employeeList.add(emp);
	}

	public void removeEmployee(Employee emp) {
		this.employeeList.remove(emp);
	}

	public Employee getEmployee(int i) {
		return this.employeeList.get(i);
	}

}
