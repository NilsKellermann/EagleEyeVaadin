package de.sag.EagleEye.logic.project;

import de.sag.EagleEye.logic.employee.Employee;
import de.sag.EagleEye.logic.visitor.ProjectVisitor;

public class Task {

	private double workload;
	private Employee emp;

	public Task() {
		this.workload = 0.0;
	}

	public Task(double workload, Employee emp) {
		this.setWorkload(workload);
		this.setEmp(emp);
	}

	public Task(double workload) {
		this(workload, new Employee());
	}

	public Task(Employee emp) {
		this(0.0, emp);
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
	public Employee getEmp() {
		return emp;
	}

	/**
	 * @param emp
	 *            the emp to set
	 */
	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public void accept(ProjectVisitor pv) {
		pv.visit(this);
	}

}
