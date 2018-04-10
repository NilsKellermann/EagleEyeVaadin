package de.sag.EagleEye;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class Sprint extends VerticalLayout implements View {
	protected static final String NAME = "Sprint";

	public Sprint() {
		setSizeFull();

		Button buttonProject = new Button("Project", VaadinIcons.ARROW_LEFT);
		buttonProject.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Gui.getCurrent().getNavigator().navigateTo(Project.NAME);
			}
		});

		addComponent(buttonProject);
		setComponentAlignment(buttonProject, Alignment.TOP_LEFT);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("This is the Sprint View!");
	}
}
