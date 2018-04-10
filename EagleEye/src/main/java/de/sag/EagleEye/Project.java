package de.sag.EagleEye;

import com.vaadin.event.MouseEvents;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;

public class Project extends VerticalLayout implements View {
	protected static final String NAME = "Project";

	public Project() {
		// setSizeFull();

		// Button buttonSprints = new Button("Sprints", new Button.ClickListener() {
		// @Override
		// public void buttonClick(ClickEvent event) {
		// Gui.getCurrent().getNavigator().navigateTo(Sprint.NAME);
		// }
		// });
		Button buttonHome = new Button("Home", VaadinIcons.ARROW_LEFT);
		buttonHome.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Gui.getCurrent().getNavigator().navigateTo(Home.NAME);
			}
		});

		Label labelProject = new Label("<h1><b>SAP Project</b></h1>", ContentMode.HTML);

		Image imageScrum = new Image(null, new ThemeResource("img\\SCRUM.png"));
		imageScrum.addClickListener(new MouseEvents.ClickListener() {
			@Override
			public void click(MouseEvents.ClickEvent event) {
				Gui.getCurrent().getNavigator().navigateTo(Sprint.NAME);
			}
		});
		imageScrum.setWidth(75, Unit.PERCENTAGE);
		imageScrum.setStyleName("image");

		addComponent(buttonHome);
		addComponent(labelProject);
		addComponent(imageScrum);
		setComponentAlignment(imageScrum, Alignment.MIDDLE_CENTER);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("This is the Project View!");
	}
}
