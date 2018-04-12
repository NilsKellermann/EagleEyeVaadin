package de.sag.EagleEye.logic.stateTask;

import de.sag.EagleEye.logic.project.Task;

public class TaskState implements InterfaceTaskState {

	@Override
	public void setTaskState(Task s) {
		s.setTaskState(this);
	}
}
