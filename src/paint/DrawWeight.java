package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

/**
 * A command designed to set a line thickness onto a graphics context
 * 
 *
 */
public class DrawWeight implements DrawCommand{
	
	private double strokeWeight;
	
	/**
	 * Sets the fill color
	 */
	@Override
	public void draw(GraphicsContext g) {
		g.setLineWidth(this.strokeWeight);
	}

	/**
	 * Sets the color for this command
	 */
	@Override
	public void setValue(Object o) {
		this.strokeWeight = (double) o;
	}
}
