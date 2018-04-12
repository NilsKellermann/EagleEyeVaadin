package de.sag.EagleEye;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import de.sag.EagleEye.logic.employee.Employee;
import de.sag.EagleEye.logic.project.Sprint;
import de.sag.EagleEye.logic.project.Task;

public class SprintView extends VerticalLayout implements View {
	protected static final String NAME = "Sprint";

	public SprintView() {
		// Testhalber wird hier der Sprint erzeugt
		Sprint sp = new Sprint();
		Employee emp = new Employee("Harald Mustermann");

		Grid<Task> grid = new Grid<>();
		String gridID = grid.getId();

		setSizeFull();

		Button buttonProject = new Button("Project", VaadinIcons.ARROW_LEFT);
		buttonProject.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Gui.getCurrent().getNavigator().navigateTo(ProjectView.NAME);
			}
		});

		addComponent(buttonProject);

		TextField workloadField = new TextField("Enter workload here ...");
		Button buttonAddTask = new Button("Add Task");
		buttonAddTask.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				sp.addTask(new Task(Double.parseDouble(workloadField.getValue()), emp));
				grid.setItems(sp.getTasks());
				// Gui.getCurrent().

			}
		});

		grid.addColumn(Task::getDescription).setCaption("Description");
		grid.addColumn(Task::getWorkload).setCaption("Workload");
		grid.addColumn(Task::getEmployee).setCaption("Employee");

		HorizontalLayout hl = new HorizontalLayout(workloadField, buttonAddTask);

		addComponent(buttonProject);
		addComponent(hl);
		addComponent(grid);

		setComponentAlignment(buttonProject, Alignment.TOP_LEFT);
		setComponentAlignment(hl, Alignment.TOP_LEFT);
		setComponentAlignment(grid, Alignment.BOTTOM_CENTER);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("This is the Sprint View!");
	}
}
