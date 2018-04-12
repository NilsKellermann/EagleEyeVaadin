package de.sag.EagleEye.logic.stateProject;

import de.sag.EagleEye.logic.project.Project;

public class ProjectState implements InterfaceProjectState {

	@Override
	public void setState(Project s) {
		s.setProjectState(this);
	}

}
