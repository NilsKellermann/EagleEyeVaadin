package de.sag.EagleEye.logic.state;

import de.sag.EagleEye.logic.project.Sprint;

public class InProgressState implements State {

	@Override
	public void doSomething(Sprint s) {
		s.setProjectState(this);
	}

}
