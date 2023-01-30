package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * 
 * The tool command for rectangles
 *
 */
public class ToolRectangle implements ToolCommand{
	
	protected Point corner;
	protected int length;
	protected int width;

	/**
	 * The initial constructor for Rectangle
	 */
	public ToolRectangle() {
		this.corner = new Point(0,0);
		this.length = 0;
		this.width = 0;
	}
	
	/**
	 * The constructor for Rectangle
	 * @param c The initial corner
	 * @param l The length of the rectangle
	 * @param w The width of the rectangle
	 */
	public ToolRectangle(Point c, int l, int w) {
		this.corner = c;
		this.length = l;
		this.width = w;
	}
	
	/**
	 * Return the corner when prompted
	 * @return The corner and its content
	 */
	public Point getCorner() {
		return corner;
	}
	
	/**
	 * Set a new corner to the rectangle
	 * @param corner The corner to be set
	 */
	public void setCorner(Point corner) {
		this.corner = corner;
	}

	/**
	 * Outputs the length of the rectangle
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Outputs the width of the rectangle
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Set a new length to the rectangle
	 * @param length The length to be set
	 */
	public void setLength(int length) {
		this.length = length;
	}
	
	/**
	 * Set a new width to the rectangle
	 * @param width The width to be set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Draws the rectangle with the given length and width
	 */
	@Override
	public void draw(GraphicsContext g) {
		g.strokeRect(corner.getX(), corner.getY(), length, width);
		g.fillRect(corner.getX(), corner.getY(), length, width);
			
	}
}
