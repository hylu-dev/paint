package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

/**
 * 
 * A line beginning with one point and ending with another
 * 
 *
 */
public class Line implements ToolCommand{
	
	private Point point1;
	private Point point2;
	
	/**
	 * 
	 * Constructor for an unspecified line 
	 * 
	 * @param point1 the beginning of the line
	 * @param point2 the end of the line
	 */
	public Line() {
		this.point1 = new Point(0, 0);
		this.point2 = new Point(0, 0);
	}
	
	/**
	 * 
	 * Constructor for a line 
	 * 
	 * @param point1 the beginning of the line
	 * @param point2 the end of the line
	 */
	public Line(Point point1, Point point2) {
		this.point1 = point1;
		this.point2 = point2;
	}
	
	/**
	 * gets the first point
	 * 
	 * @return the first point
	 */
	public Point getStart() {
		return this.point1;
	}
	
	/**
	 * gets the second point
	 * 
	 * @return the second point
	 */
	public Point getEnd() {
		return this.point2;
	}
	
	/**
	 * sets the first point to a new point
	 * 
	 * @param p a new point
	 */
	public void setStart(Point p) {
		this.point1 = p;
	}
	
	/**
	 * sets the second point to a new point
	 * 
	 * @param p a new point
	 */
	public void setEnd(Point p) {
		this.point2 = p;
	}

	@Override
	public void draw(GraphicsContext g) {
		g.strokeLine((double)this.point1.getX(), (double)this.point1.getY(), (double)this.point2.getX(), (double)this.point2.getY());
	}
}
