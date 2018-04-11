package de.sag.EagleEye.logic.visitor;

import de.sag.EagleEye.logic.project.Task;

public interface Visitor {

	public double visit(Task t);

}
