package de.sag.EagleEye;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
public class Gui extends UI {
	Navigator navigator;

	@Override
	protected void init(VaadinRequest request) {
		getPage().setTitle("Navigation Example");

		// Create a navigator to control the views
		navigator = new Navigator(this, this);

		// Create and register the views
		navigator.addView("", HomeView.class);
		navigator.addView(HomeView.NAME, HomeView.class);
		navigator.addView(ProjectView.NAME, ProjectView.class);
		navigator.addView(SprintView.NAME, SprintView.class);
		navigator.addView(OfficeView.NAME, OfficeView.class);
	}

	@WebServlet(urlPatterns = "/*", name = "GUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = Gui.class, productionMode = false)
	public static class GUIServlet extends VaadinServlet {
	}
}
