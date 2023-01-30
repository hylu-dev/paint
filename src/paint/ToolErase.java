package ca.utoronto.utm.paint;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;

/**
 * A tool command for a rectangle
 *
 */
public class ToolErase implements ToolCommand {
	
	private ArrayList<Point> erasePoints = new ArrayList<Point>();
	private int tolerance = 2;
	
	/**
	 * Constructor for an eraser command
	 * 
	 */
	public ToolErase() {
	}
	
	/**
	 * Adds new points to connect the erase rectangles into a stroke
	 * 
	 * @param p the point to add
	 */
	public void addErasePoints(Point p) {
		erasePoints.add(p);
	}
	
	/**
	 * Iterates through all points and erases by connecting clearRects between all of the points
	 * 
	 */
	@Override
	public void draw(GraphicsContext g) {
		if (this.erasePoints.size() < 2) {
			return;
		}
		// adds additional points to ensure an even series of clearRect's
		for (int i = 0; i < this.erasePoints.size() - 1; i++) {
			Point p1 = this.erasePoints.get(i);
			Point p2 = this.erasePoints.get(i+1);
			double dX = Math.pow(p1.getX() - p2.getX(), 2);
			double dY = Math.pow(p1.getY() - p2.getY(), 2);
			double dist = Math.sqrt(dX + dY);
			if (dist > this.tolerance) {
				this.erasePoints.add(i+1, new Point((p1.getX() + p2.getX())/2, (p1.getY() + p2.getY())/2));
			}
		}
			
		for (int i = 0; i < this.erasePoints.size() - 1; i++) {
			Point p1 = this.erasePoints.get(i);
			Point p2 = this.erasePoints.get(i + 1);
			int width = 20;
			int height = 20;
			g.clearRect(p1.getX() - 10,p2.getY() - 10, width, height);
		}
		
	}

}
