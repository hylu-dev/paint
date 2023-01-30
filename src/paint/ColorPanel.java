
package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;


import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * 
 * A color selector panel that changes shape fills to the selected color
 *
 */
public class ColorPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view; // So we can talk to our parent or other components of the view
	private double red = 0;
	private double blue = 0;
	private double green = 0;
	private double opacity = 1;
	private Slider rSlider;
	private Slider gSlider;
	private Slider bSlider;
	private Slider oSlider;
	private Text rText;
	private Text gText;
	private Text bText;
	private Text oText;
	
	public ColorPanel(View view) {

		this.view = view;
		GridPane gridPane = new GridPane();
		
		double n = (double)1;
		double[] reds = {n/9, n/9, n/9, n/30, n/20, n/20, n/40, n/20, n/10};
		double[] blues = {n/40, n/20, n/10, n/9, n/9, n/9, n/40, n/20, n/20};
		double[] greens = {n/40, n/20, n/20, n/40, n/20, n/10, n/9, n/9, n/9};
		
		// creates gradient grid
		for (int col = 0; col < 9; col++) {
			for (int row = 0; row < 9; row++) {
				Circle graphic = new Circle(0,0,5);
				Color color = new Color(reds[col]*row, blues[col]*row, greens[col]*row, 1);
				// puts grayscale on first row
				if (row == 0) {
					color = new Color((double)col/8, (double)col/8, (double)col/8, 1);
				}
				Button button = new Button();
				button.setStyle("-fx-background-color: " + PaintPanel.getHex(color) + "; -fx-background-radius: 0");
				button.setMinSize(30, 30);
				button.setMaxSize(30, 30);
				button.setTooltip(new Tooltip(color.toString()));
				button.setOnAction(this);
				gridPane.add(button, col, row);
			}
		};
		this.add(gridPane, 0, 0);
		
		gridPane = new GridPane();
		rSlider = new Slider(0, 1, red);
		rText = new Text("Red: " + red);
		rText.setFill(Color.LIGHTGREY);
		gridPane.add(rSlider, 0, 0);
		gridPane.add(rText, 1, 0);
		
		gSlider = new Slider(0, 1, green);
		gText = new Text("Green: " + green);
		gText.setFill(Color.LIGHTGREY);
		gridPane.add(gSlider, 0, 1);
		gridPane.add(gText, 1, 1);
		
		bSlider = new Slider(0, 1, blue);
		bText = new Text("Blue: " + blue);
		bText.setFill(Color.LIGHTGREY);
		gridPane.add(bSlider, 0, 2);
		gridPane.add(bText, 1, 2);
		
		oSlider = new Slider(0, 1, opacity);
		oText = new Text("Opacity: " + opacity*255);
		oText.setFill(Color.LIGHTGREY);
		gridPane.add(oSlider, 0, 3);
		gridPane.add(oText, 1, 3);
		
		Button setter = new Button("Set New Color");
		setter.setStyle("-fx-background-color: #555555; -fx-text-fill: #DDDDDD; -fx-text-fill: #DDDDDD; -fx-font: 16px \"Arial\"");
		setter.setTooltip(new Tooltip("Applies Slider Color Settings"));
		setter.setOnAction(this);
		gridPane.add(setter, 0, 4);
		
		this.add(new Label(""), 0, 1);
		this.add(gridPane, 0, 2);
	}
	
	/**
	 * Gets the current color set
	 * 
	 * @return a new color with the current rgb opacity settings
	 */
	public Color getValue() {
		return new Color(red, green, blue, opacity);
	}

	@Override
	public void handle(ActionEvent event) {
		if (((Button)event.getSource()).getText() != "Set New Color") {
			String e = ((Button) event.getSource()).getTooltip().getText();
			rSlider.setValue(Color.valueOf(e).getRed());
			gSlider.setValue(Color.valueOf(e).getGreen());
			bSlider.setValue(Color.valueOf(e).getBlue());
		}
		red = rSlider.getValue();
		blue = bSlider.getValue();
		green = gSlider.getValue();
		opacity = oSlider.getValue();
		rText.setText("Red: " + Float.toString((float)red*255));
		gText.setText("Green: " + Float.toString((float)green*255));
		bText.setText("Blue: " + Float.toString((float)blue*255));
		oText.setText("Opacity: " + Float.toString((float)opacity*255));
		
		DrawCommand drawcom = new DrawColor();
		drawcom.setValue(new Color(red, green, blue, opacity));
		this.view.getPaintModel().addCommand(drawcom);
	}
	
}
