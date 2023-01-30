package ca.utoronto.utm.paint;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


/**
 * Panel that allows the switching of readfaces to be used for drawing on a graphics context
 * 
 */
public class ToolChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view; // So we can talk to our parent or other components of the view
	private ToggleButton[] buttons;
	private ToggleGroup group;

	/**
	 * Constructor for a tool panel
	 * 
	 * @param view to change readface on
	 */
	public ToolChooserPanel(View view) {

		this.view = view;
		view.getPaintPanel().setReadInterface(new ReadCircle(view.getPaintPanel().getModel()));
		
		group = new ToggleGroup();

		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Triangle", "Squiggle", "Polyline", "Polyshape", "Eraser", "EyeDrop", "EyeDropFill"};
		buttons = new ToggleButton[buttonLabels.length];

		int row = 0;
		for (String path : buttonLabels) {
			Image img = new Image(getClass().getResource("icons/"+path+".png").toExternalForm(), true);
			ImageView imgView = new ImageView(img);
			imgView.setFitWidth(40);
			imgView.setFitHeight(40);
			buttons[row] = new ToggleButton();
			buttons[row].setGraphic(imgView);
			buttons[row].setTooltip(new Tooltip(path));
			buttons[row].setToggleGroup(group);
			buttons[row].setStyle("-fx-background-color: #555555;");
			this.add(buttons[row], 0, row);
			buttons[row].setOnAction(this);
			row++;
		}
		group.selectToggle(buttons[0]);
		buttons[0].setStyle("-fx-background-color: #333333;");
	}
	
	public void buttonFeedBack(ToggleButton b) {
		for (ToggleButton button : buttons) {
			button.setStyle("-fx-background-color: #555555;");
		}
		b.setStyle("-fx-background-color: #333333;");
	}
	
	/**
	 * Setter for the read interface depending on which button clicked
	 * 
	 */
	@Override
	public void handle(ActionEvent event) {
		ToggleButton e = ((ToggleButton) event.getSource());
		String command = e.getTooltip().getText();
		buttonFeedBack(e);
		this.view.getPaintPanel().setReadInterface(ReadInterface.create(command, view));
	}
	
	
}
