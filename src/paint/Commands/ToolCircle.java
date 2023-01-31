package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * 
 * The tool command for circle
 *
 */
public class ToolCircle implements ToolCommand{
	
	private Point centre;
	private int radius;
	
	/**
	 * The initial constructor of circle
	 */
	public ToolCircle() {
		this.centre = new Point(0,0);
		this.radius = 0;
	}

	/**
	 * The constructor of circle
	 * @param centre The center point of the circle
	 * @param radius The radius of the circle
	 */
	public ToolCircle(Point centre, int radius) {
		this.centre = centre;
		this.radius = radius;
	}
	
	/**
	 * Gets the center point
	 * @return The point in the center
	 */
	public Point getCentre() {
		return centre;
	}
	
	/**
	 * Set the center point to a new point
	 * @param centre The new point to set the circle's center to
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
	/**
	 * Outputs the radius of the circle
	 * @return The radius
	 */
	public int getRadius() {
		return radius;
	}
	
	/**
	 * Set the radius to the radius given
	 * @param radius The radius to be set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * Draws the circle given the radius and the center point
	 */
	@Override
	public void draw(GraphicsContext g) {
		g.strokeOval(centre.getX()-radius, centre.getY()-radius, radius*2, radius*2);
		g.fillOval(centre.getX()-radius, centre.getY()-radius, radius*2, radius*2);
	}


}
