package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * A command designed to set a fill color onto a graphics context
 * 
 *
 */
public class DrawFill implements DrawCommand{
	
	Color fill;
	
	/**
	 * Sets the fill color
	 */
	@Override
	public void draw(GraphicsContext g) {
		g.setFill(fill);
	}
	
	/**
	 * Sets the color for this command
	 */
	@Override
	public void setValue(Object o) {
		fill = (Color) o;
	}
}
