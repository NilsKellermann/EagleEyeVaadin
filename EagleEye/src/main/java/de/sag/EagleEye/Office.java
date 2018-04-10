package de.sag.EagleEye;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;

public class Office extends VerticalLayout implements View {
	protected static final String NAME = "Unit";

	public Office() {
		Button buttonHome = new Button("Home", VaadinIcons.ARROW_LEFT);
		buttonHome.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Gui.getCurrent().getNavigator().navigateTo(Home.NAME);
			}
		});

		addComponent(buttonHome);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("This is the Office View!");
	}
}
