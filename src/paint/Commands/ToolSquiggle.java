package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;

/**
 * 
 *
 *The tool command for squiggle
 *
 */
public class ToolSquiggle implements ToolCommand{

	private ArrayList<Point> Points = new ArrayList<Point>();
	
	/**
	 * Draws the lines used to make up the squiggle function
	 */
	@Override
	public void draw(GraphicsContext g) {
		for(int i =0; i < this.Points.size() -1; i++) {
			Point p1 = this.Points.get(i);
			Point p2 = this.Points.get(i+1);
			g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
	}
	
	/**
	 * 
	 * Adds points into the Points arraylist
	 * 
	 * @param p The point to be added
	 */
	public void addPoints(Point p) {
		Points.add(p);
	}
}
