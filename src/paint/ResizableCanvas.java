/**
 * 
 */
package ca.utoronto.utm.paint;

import javafx.scene.canvas.Canvas;

/**
 * A canvas that resizes itself
 * 
 *
 */
public class ResizableCanvas extends Canvas {
	
	private double width;
	private double height;
	
	/**
	 * Constructor for resizable canvas up to the given dimensions
	 * 
	 * @param width to be able to resize to
	 * @param height to be able to resize to
	 */
	public ResizableCanvas(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double minHeight(double width) {
	    return 0;
	}

	@Override
	public double maxHeight(double width) {
	    return this.height*2;
	}
	
	@Override
	public double minWidth(double height) {
	    return 0;
	}
	
	@Override
	public double maxWidth(double height) {
	    return this.width*2;
	}
	
	@Override
	public double prefWidth(double width) {
	    return this.width/2;
	}
	
	@Override
	public double prefHeight(double width) {
	    return this.height/2;
	}

	@Override
	public boolean isResizable() {
		return true;
	}
	
	@Override
	public void resize(double width, double height)
	{
	    super.setWidth(width);
	    super.setHeight(height);
	}
}
