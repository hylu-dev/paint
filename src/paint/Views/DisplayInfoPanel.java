package ca.utoronto.utm.paint;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * A panel to that displays cursor location and canvas size
 *
 */
public class DisplayInfoPanel extends GridPane{
	
    final Label show = new Label("X,Y");
    final Label canvasSize = new Label("Canvas Size");
	
    /**
     * Constructor for a info display
     * 
     */
	public DisplayInfoPanel() {
		show.setStyle("-fx-background-color: #555555; -fx-text-fill: #DDDDDD; -fx-text-fill: #DDDDDD; -fx-font: 16px \"Arial\"");
		canvasSize.setStyle("-fx-background-color: #555555; -fx-text-fill: #DDDDDD; -fx-text-fill: #DDDDDD; -fx-font: 16px \"Arial\"");
		this.setHgap(50);
		this.add(show, 0, 1, 3, 1);
		this.add(canvasSize,4,1,10,1);

	}
	
	/**
	 * Getter for the cursor label
	 * 
	 * @return cursor label
	 */
	public Label getLabel() {
		return this.show;
	}
	
	/**
	 * Getter for the canvas size label
	 * 
	 * @return canvas label
	 */
	public Label getCanvasLabel() {
		return this.canvasSize;
	}
}
	

