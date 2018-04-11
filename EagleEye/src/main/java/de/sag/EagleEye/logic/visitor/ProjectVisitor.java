package de.sag.EagleEye.logic.visitor;

import de.sag.EagleEye.logic.project.Task;

public class ProjectVisitor implements Visitor {

	public double visit(Task t) {
		return t.getWorkload();
	}
}
