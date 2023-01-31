package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * A command for drawing triangle
 * @author Roy Lu
 */
public class ToolTriangle implements ToolCommand{
	
	private Point p1;
	private Point p2;
	private Point p3;

	/**
	 * Constructor for a triangle command
	 * @author Roy Lu
	 */
	public ToolTriangle() {
	}
	
	/**
	 * Constructor for a triangle command with set points
	 * @author Roy Lu
	 * @param p1 first point of the triangle
	 * @param p2 second point of the triangle
	 * @param p3 third point of the triangle
	 */
	public ToolTriangle(Point p1, Point p2, Point p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	/**
	 * getter for the first point
	 * @author Roy Lu
	 * @return first point
	 */
	public Point getPoint1() {
		return this.p1;
	}
	
	/**
	 * getter for the second point
	 * @author Roy Lu
	 * @return second point
	 */
	public Point getPoint2() {
		return this.p2;
	}
	
	/**
	 * getter for the third point
	 * @author Roy Lu
	 * @return third point
	 */
	public Point getPoint3() {
		return this.p3;
	}
	
	/**
	 * setter for the first point
	 * @author Roy Lu
	 * @param p point to set
	 */
	public void setPoint1(Point p) {
		this.p1 = p;
	}
	
	/**
	 * setter for the second point
	 * @author Roy Lu
	 * @param p point to set
	 */
	public void setPoint2(Point p) {
		this.p2 = p;
	}
	
	/**
	 * setter for the third point
	 * @author Roy Lu
	 * @param p point to set
	 */
	public void setPoint3(Point p) {
		this.p3 = p;
	}
	
	/**
	 * draws a triangle onto graphics context
	 * @author Roy Lu
	 */
	@Override
	public void draw(GraphicsContext g) {
		double[] xPoints = new double[3];
		double[] yPoints = new double[3];
		xPoints[0] = this.p1.getX();
		xPoints[1] = this.p2.getX();
		xPoints[2] = this.p3.getX();
		yPoints[0] = this.p1.getY();
		yPoints[1] = this.p2.getY();
		yPoints[2] = this.p3.getY();
		g.strokePolygon(xPoints, yPoints, 3);
		g.fillPolygon(xPoints, yPoints, 3);
	}
}
