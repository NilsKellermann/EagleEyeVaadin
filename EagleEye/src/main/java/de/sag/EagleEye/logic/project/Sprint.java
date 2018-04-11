package de.sag.EagleEye.logic.project;

import java.util.ArrayList;
import java.util.List;

import de.sag.EagleEye.logic.state.State;
import de.sag.EagleEye.logic.state.StateActive;
import de.sag.EagleEye.logic.visitor.ProjectVisitor;

public class Sprint {

	private ProjectVisitor pv;

	private State ps;

	private int number;
	private int days;
	private List<Task> tasks;

	public Sprint() {
		this.pv = new ProjectVisitor();
		this.setTasks(new ArrayList<Task>());
		setProjectState(new StateActive());
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the days
	 */
	public int getDays() {
		return days;
	}

	public double getWorkload() {
		double summe = 0.0;
		for (Task t : tasks) {
			summe += pv.visit(t);
		}
		return summe;

	}

	/**
	 * Adds a task
	 * 
	 * @param t
	 *            the task to add
	 */
	public void addTask(Task t) {
		tasks.add(t);
	}

	/**
	 * Removes a Task
	 * 
	 * @param t
	 *            the task to add
	 */
	public void removeTask(Task t) {
		tasks.remove(t);
	}

	/**
	 * @param days
	 *            the days to set
	 */
	public void setDays(int days) {
		this.days = days;
	}

	/**
	 * @return the tasks
	 */
	public List<Task> getTasks() {
		return tasks;
	}

	/**
	 * @param tasks
	 *            the tasks to set
	 */
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	/**
	 * @return the ps
	 */
	public State getProjectState() {
		return ps;
	}

	/**
	 * @param ps
	 *            the ps to set
	 */
	public void setProjectState(State ps) {
		this.ps = ps;
	}

}
