package de.sag.EagleEye.logic.employee;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

	private List<Employee> employeeList;

	public Manager(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Manager() {
		this.employeeList = new ArrayList<Employee>();
	}

	public void addEmployee(Employee emp) {
		this.employeeList.add(emp);
	}

}
