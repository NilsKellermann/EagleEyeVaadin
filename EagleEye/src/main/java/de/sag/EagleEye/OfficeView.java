package de.sag.EagleEye;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class OfficeView extends VerticalLayout implements View {
	protected static final String NAME = "Unit";

	public OfficeView() {
		Button buttonHome = new Button("Home", VaadinIcons.ARROW_LEFT);
		buttonHome.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Gui.getCurrent().getNavigator().navigateTo(HomeView.NAME);
			}
		});

		addComponent(buttonHome);

	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("This is the Office View!");
	}
}
