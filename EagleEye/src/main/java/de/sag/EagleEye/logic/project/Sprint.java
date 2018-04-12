package de.sag.EagleEye.logic.project;

import java.util.ArrayList;
import java.util.List;

import de.sag.EagleEye.logic.visitor.TaskVisitor;

public class Sprint {

	private TaskVisitor pv;


	private int number;
	private int days;
	private List<Task> tasks;

	public Sprint() {
		this.pv = new TaskVisitor();
		this.setTasks(new ArrayList<Task>());
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
			summe += pv.visitWorkload(t);
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



}
