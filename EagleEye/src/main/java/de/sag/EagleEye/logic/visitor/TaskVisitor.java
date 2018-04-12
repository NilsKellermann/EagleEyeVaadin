package de.sag.EagleEye.logic.visitor;

import de.sag.EagleEye.logic.project.Task;

public class TaskVisitor implements Visitor {

	public double visitWorkload(Task t) {
		return t.getWorkload();
	}
}
