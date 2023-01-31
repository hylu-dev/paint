package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * A command designed to set a stroke color onto a graphics context
 * @author Roy Lu
 */
public class DrawColor implements DrawCommand{
	Color color;
	
	/**
	 * Sets the line color
	 * @author Roy Lu
	 */
	@Override
	public void draw(GraphicsContext g) {
		g.setStroke(color);
	}
	
	/**
	 * Sets the color for this command
	 * @author Roy Lu
	 */
	@Override
	public void setValue(Object o) {
		color = (Color)o;
	}
}
