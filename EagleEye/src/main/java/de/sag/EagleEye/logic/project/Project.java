package de.sag.EagleEye.logic.project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {

	private String name;
	private LocalDate startDate;
	private LocalDate endDate;

	List<Sprint> sprints;

	public Project() {
		this.sprints = new ArrayList<Sprint>();
	}

	public Project(ArrayList<Sprint> sprints) {
		this.sprints = sprints;
	}

	public void addSprint(Sprint s) {
		sprints.add(s);
	}
	
	public List<Sprint> getSprints() {
		return sprints;
	}

	public void removeTask(Sprint s) {
		sprints.remove(s);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the startDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

}
