package de.sag.EagleEye;

import java.io.File;

import com.vaadin.event.MouseEvents;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinService;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class Home extends VerticalLayout implements View {
	protected static final String NAME = "Home";

	public Home() {

		Button buttonSignout = new Button("Sign out", VaadinIcons.SIGN_OUT);
		Button buttonOffice = new Button("Office", VaadinIcons.USERS);
		buttonOffice.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Gui.getCurrent().getNavigator().navigateTo(Office.NAME);
			}
		});

		Button buttonProfil = new Button("Profil", VaadinIcons.USER);
		Button buttonArchive = new Button("Archive", VaadinIcons.ARCHIVE);

		Image imageProjectSap = new Image(null, new ThemeResource("img\\SAP.png"));
		imageProjectSap.addClickListener(new MouseEvents.ClickListener() {
			@Override
			public void click(MouseEvents.ClickEvent event) {
				Gui.getCurrent().getNavigator().navigateTo(Project.NAME);
			}
		});
		imageProjectSap.setWidth(75, Unit.PERCENTAGE);
		imageProjectSap.setStyleName("image");

		Image imageProjectGrey = new Image(null, new ThemeResource("img\\GREY.jpeg"));
		imageProjectGrey.addClickListener(new MouseEvents.ClickListener() {
			@Override
			public void click(MouseEvents.ClickEvent event) {

			}
		});
		imageProjectGrey.setWidth(75, Unit.PERCENTAGE);

		GridLayout grid = new GridLayout(3, 3);
		grid.setWidth(100, Sizeable.UNITS_PERCENTAGE);
		grid.setHeight(100, Sizeable.UNITS_PERCENTAGE);
		grid.addComponent(imageProjectSap, 0, 0);
		grid.setComponentAlignment(imageProjectSap, Alignment.TOP_LEFT);
		grid.addComponent(imageProjectGrey, 1, 0);
		grid.setComponentAlignment(imageProjectGrey, Alignment.TOP_LEFT);

		grid.setStyleName("grid-layout");
		addComponent(new HorizontalLayout(buttonSignout, buttonOffice, buttonProfil, buttonArchive));
		addComponent(grid);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("This is the Home View!");
	}

}
