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

import de.sag.EagleEye.logic.employee.Developer;
import de.sag.EagleEye.logic.employee.Employee;
import de.sag.EagleEye.logic.project.Sprint;
import de.sag.EagleEye.logic.project.Task;
import de.sag.EagleEye.logic.stateTask.TaskStateBacklog;

public class SprintView extends VerticalLayout implements View {
	protected static final String NAME = "Sprint";

	public SprintView() {
		// Testhalber wird hier der Sprint erzeugt
		Sprint sp = new Sprint();
		Employee emp = new Developer("Harald Mustermann");

		Grid<Task> grid = new Grid<Task>();

		// Grid<Task> gridKanban = new Grid<Task>();

		Grid<Task> gridKanbanBacklog = new Grid<Task>();
		Grid<Task> gridKanbanDocumentation = new Grid<Task>();
		Grid<Task> gridKanbanDone = new Grid<Task>();
		Grid<Task> gridKanbanInProgress = new Grid<Task>();
		Grid<Task> gridKanbanTest = new Grid<Task>();
		Grid<Task> gridKanbanObstacle = new Grid<Task>();

		setSizeFull();

		Button buttonProject = new Button("Project", VaadinIcons.ARROW_LEFT);
		buttonProject.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Gui.getCurrent().getNavigator().navigateTo(ProjectView.NAME);
			}
		});

		TextField workloadField = new TextField("Enter workload here ...");
		TextField descriptionField = new TextField("Enter description here ...");
		Button buttonAddTask = new Button("Add Task");
		buttonAddTask.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				sp.addTask(new Task(Double.parseDouble(workloadField.getValue()), emp, descriptionField.getValue()));

				gridKanbanBacklog.setItems(
						sp.getTasks().stream().filter((Task t) -> t.getTaskState() instanceof TaskStateBacklog));

				grid.setItems(sp.getTasks());
				// Gui.getCurrent().

			}
		});

		Button buttonRemoveSelected = new Button("Remove Task");
		buttonRemoveSelected.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				grid.getSelectedItems().forEach((Task t) -> sp.removeTask(t));
				grid.setItems(sp.getTasks());
			}
		});

		gridKanbanBacklog.addColumn(t -> t.getTaskState().toString()).setCaption("BACKLOG");
		gridKanbanInProgress.addColumn(t -> t.getTaskState().toString()).setCaption("IN PROGRESS");
		gridKanbanTest.addColumn(t -> t.getTaskState().toString()).setCaption("TEST");
		gridKanbanDocumentation.addColumn(t -> t.getTaskState().toString()).setCaption("DOCUMENTATION");
		gridKanbanDone.addColumn(t -> t.getTaskState().toString()).setCaption("DONE");
		gridKanbanObstacle.addColumn(t -> t.getTaskState().toString()).setCaption("OBSTACLE");

		HorizontalLayout hl = new HorizontalLayout(workloadField, descriptionField, buttonAddTask,
				buttonRemoveSelected);

		HorizontalLayout hlGrid = new HorizontalLayout(gridKanbanBacklog, gridKanbanInProgress, gridKanbanTest,
				gridKanbanDocumentation, gridKanbanDone, gridKanbanObstacle);
		hlGrid.setWidth("90%");

		addComponent(buttonProject);

		addComponent(buttonProject);
		addComponent(hl);
		addComponent(hlGrid);
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
