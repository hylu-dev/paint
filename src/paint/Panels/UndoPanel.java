package ca.utoronto.utm.paint;

import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * A panel for undoing and redoing commands sent to the canvas
 * @author Roy Lu
 */
public class UndoPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view; // So we can talk to our parent or other components of the view
	private Stack<Object> undoStack = new Stack<Object>();
	private int commandSize = 0;

	/**
	 * Panel that holds buttons for undoing commands from a model
	 * @author Roy Lu
	 * @param view to access model to undo
	 */
	public UndoPanel(View view) {
		this.view = view;
		view.getPaintPanel().setReadInterface(new ReadCircle(view.getPaintPanel().getModel()));
		Button undo = new Button("Undo");
		Button redo = new Button("Redo");
		undo.setStyle("-fx-background-color: #555555; -fx-text-fill: #DDDDDD; -fx-text-fill: #DDDDDD; -fx-font: 16px \"IMPACT\"");
		redo.setStyle("-fx-background-color: #555555; -fx-text-fill: #DDDDDD; -fx-text-fill: #DDDDDD; -fx-font: 16px \"IMPACT\"");
		undo.setOnAction(this);
		redo.setOnAction(this);
		this.add(undo, 0, 0);
		this.add(redo, 0, 1);
	}

	/**
	 * Undo's a command when undo is pressed and redo's a command when redo is pressed
	 * @author Roy Lu
	 */
	@Override
	public void handle(ActionEvent event) {
		String e = ((Button) event.getSource()).getText();
		if (e == "Undo") {
			//checks if current undo path is changed and empties undoStack as needed
			if (this.view.getPaintModel().getCommands().size() != commandSize) {
				this.undoStack.clear();
			}
			//removes the ToolCommand if not empty
			int i = this.view.getPaintModel().getCommands().size() - 1;
			while (i >= 0) {
				if (this.view.getPaintModel().getCommands().get(i) instanceof ToolCommand) {
					undoStack.add(i);
					undoStack.add(this.view.getPaintModel().getCommands().get(i));
					this.view.getPaintModel().removeCommand(i);
					break;
				}
				i -= 1;
			}
			//tracks current undoPath
			commandSize = this.view.getPaintModel().getCommands().size();
		}
		
		if (e == "Redo") {
			//checks if current undo path is changed and empties undoStack as needed
			if (this.view.getPaintModel().getCommands().size() != commandSize) {
				this.undoStack.clear();
			}
			if (!undoStack.isEmpty()) {
				this.view.getPaintModel().addCommand((Command)undoStack.pop(), (int)undoStack.pop());
			}
			//tracks current undoPath
			commandSize = this.view.getPaintModel().getCommands().size();
		}
	}
}
