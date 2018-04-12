package de.sag.EagleEye.logic.main;

import de.sag.EagleEye.logic.employee.Developer;
import de.sag.EagleEye.logic.employee.Employee;
import de.sag.EagleEye.logic.project.Project;
import de.sag.EagleEye.logic.project.Sprint;
import de.sag.EagleEye.logic.project.Task;

public class Main {

	public static void main(String agrs[]) {

		Project testProject = new Project();
		Sprint testSprint = new Sprint();
		Task test1Task = new Task(1.5);
		Task test2Task = new Task(3.5);
		Employee testEmployee = new Developer();

		test1Task.setEmployee(testEmployee);
		testSprint.addTask(test1Task);
		
		test2Task.setEmployee(testEmployee);
		testSprint.addTask(test2Task);
		
		
		testProject.addSprint(testSprint);

		for (Sprint s : testProject.getSprints()) {
			System.out.println(s.getWorkload());
		}

	}

}
