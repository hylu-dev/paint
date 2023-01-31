package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

/**
 * A command designed to clear a graphics context
 * 
 */
public class CommandClear implements Command {
	
	private double width;
	private double height;
	
	/**
	 * 
	 */
	@Override
	public void draw(GraphicsContext g) {
		g.clearRect(0, 0, width, height);
	}
	
	/**
	 * 
	 * @param width
	 * @param height
	 */
	public void setSize(double width, double height) {
		this.width = width;
		this.height = height;
	}

}
