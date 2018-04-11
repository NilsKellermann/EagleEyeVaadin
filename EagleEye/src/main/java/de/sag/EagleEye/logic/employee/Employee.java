package de.sag.EagleEye.logic.employee;

import java.util.ArrayList;
import java.util.List;

import de.sag.EagleEye.logic.project.Task;

public class Employee {

	List<Task> tasks;

	double hourlyWage;

	public Employee() {
		this.tasks = new ArrayList<Task>();
		hourlyWage = 8.50;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public double getHourlyWage() {
		return hourlyWage;
	}

}
