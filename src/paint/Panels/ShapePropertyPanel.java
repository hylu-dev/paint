package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Panel that holds all property changing events towards a graphics context
 * @author Roy Lu
 */
public class ShapePropertyPanel extends GridPane {

	private DrawCommand drawcom;
	private CustomMenuItem customMenuItem;
	private Button strokeColor = new Button("Stroke Color");
	private Button fillColor = new Button("Fill Color");
	private CheckBox checkFill = new CheckBox ("Fill");
	private MenuButton menuStrokeWeight = new MenuButton();
	private Slider strokeWeight = new Slider(1, 50, 5);
	private ColorPanel colorPanel;
	private FillPanel fillPanel;
	
	/**
	 * Constructor for a property panel
	 * @author Roy Lu
	 * @param view for properties to be applied to
	 */
	public ShapePropertyPanel(View view) {
		colorPanel = new ColorPanel(view);
		fillPanel = new FillPanel(view);
		strokeColor.setStyle("-fx-background-color: #555555; -fx-text-fill: #DDDDDD; -fx-font: 16px \"Arial\"");
		fillColor.setStyle("-fx-background-color: #555555; -fx-text-fill: #DDDDDD; -fx-text-fill: #DDDDDD; -fx-font: 16px \"Arial\"");
		checkFill.setStyle("-fx-background-color: #555555; -fx-text-fill: #DDDDDD; -fx-text-fill: #DDDDDD; -fx-font: 16px \"Arial\"");
		Label label = new Label("Stroke Weight");
		label.setStyle("-fx-background-color: #555555; -fx-text-fill: #DDDDDD; -fx-text-fill: #DDDDDD; -fx-font: 16px \"Arial\"");
		menuStrokeWeight.setStyle("-fx-background-color: #555555;");
		menuStrokeWeight.setGraphic(label);
		
		this.add(strokeColor, 0, 0);
		this.add(fillColor, 1, 0);
		this.add(menuStrokeWeight, 2, 0);
		this.add(new Label("  "), 3, 0);
		this.add(checkFill, 4, 0);

		strokeColor.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				final Stage dialog = new Stage();
				dialog.initModality(Modality.APPLICATION_MODAL);
                VBox dialogVbox = new VBox(20);
                dialogVbox.setStyle("-fx-background-color: #555555;");
                dialogVbox.getChildren().add(colorPanel);
                Scene dialogScene = new Scene(dialogVbox, 270, 400);
                dialog.setScene(dialogScene);
                dialog.show();
			}
		});	
		
		fillColor.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				fillPanel.isFill(checkFill.isSelected());
				final Stage dialog = new Stage();
				dialog.initModality(Modality.APPLICATION_MODAL);
                VBox dialogVbox = new VBox(20);
                dialogVbox.setStyle("-fx-background-color: #555555;");
                dialogVbox.getChildren().add(fillPanel);
                Scene dialogScene = new Scene(dialogVbox, 270, 400);
                dialog.setScene(dialogScene);
                dialog.show();
                // Gives no fill if checkFill unchecked
                
			}
		});	

		strokeWeight.setShowTickLabels(true);
		strokeWeight.setShowTickMarks(true);
		customMenuItem = new CustomMenuItem(strokeWeight, false);
		customMenuItem.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					drawcom = new DrawWeight();
					drawcom.setValue(strokeWeight.getValue());
					view.getPaintModel().addCommand(drawcom);
		}
	});
		menuStrokeWeight.getItems().add(customMenuItem);
		
		checkFill.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					drawcom = new DrawFill();
					if (!checkFill.isSelected()) {
					drawcom.setValue(Color.TRANSPARENT);
					}
					else {
						drawcom.setValue(fillPanel.getValue());
					}
					view.getPaintModel().addCommand(drawcom);
		}
	});
	}
	
	/**
	 * getter for whether checkFill is checked
	 * @author Roy Lu
	 * @return boolean of checkFill state
	 */
	public Boolean getCheckFill() {
		return checkFill.isSelected();
	}
	
}
