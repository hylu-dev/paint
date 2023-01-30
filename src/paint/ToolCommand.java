package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * Provides the interface for drawing shapes, used in every drawable class.
 *
 */
public interface ToolCommand extends Command{
	
	/**
	 * Draws the shape/object onto the GraphicsContext g
	 * 
	 * @param g The GraphicsContext that is being drawn onto
	 */
	public void draw(GraphicsContext g);
}
