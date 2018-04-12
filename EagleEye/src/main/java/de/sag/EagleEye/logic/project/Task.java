package de.sag.EagleEye.logic.project;

import de.sag.EagleEye.logic.employee.Employee;
import de.sag.EagleEye.logic.visitor.ProjectVisitor;

public class Task {

	private double workload;
	private Employee emp;
	private String description;

	public Task() {
		this.workload = 0.0;
	}

	public Task(double workload, Employee emp, String description) {
		this.setWorkload(workload);
		this.setEmployee(emp);
		this.setDescription(description);
	}

	public Task(double workload, Employee emp) {
		this(workload, emp, "no description");

	}

	/**
	 * @return the workload
	 */
	public double getWorkload() {
		return workload;
	}

	/**
	 * @param workload
	 *            the workload to set
	 */
	public void setWorkload(double workload) {
		this.workload = workload;
	}

	/**
	 * @return the emp
	 */
	public Employee getEmployee() {
		return emp;
	}

	/**
	 * @param emp
	 *            the emp to set
	 */
	public void setEmployee(Employee emp) {
		this.emp = emp;
	}

	public void accept(ProjectVisitor pv) {
		pv.visit(this);
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
