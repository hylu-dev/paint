package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;

/**
 * 
 *
 *The tool command for Polyshape
 *
 */
public class ToolPolyShape implements ToolCommand{

	private ArrayList<Point> Points = new ArrayList<Point>();
	private double[] AllX = new double[1000];
	private double[] AllY = new double[1000];
	
	/**
	 * Draws a polyshape based on the points given
	 */
	@Override
	public void draw(GraphicsContext g) {
		for(int i = 0; i < this.Points.size()-1; i++) {
			int pX = this.Points.get(i).getX();
			int pY = this.Points.get(i).getY();
			AllX[i+1] = pX;
			AllY[i+1] = pY;
		}
		g.strokePolygon(AllX, AllY, this.Points.size());
		g.fillPolygon(AllX, AllY, this.Points.size());
	}
	
	/**
	 * 
	 * Adds points into the Points arraylist
	 * Sets the first point of the polyshape to the inital point
	 * 
	 * @param p The point to be added
	 */
	public void addPoints(Point p) {
		Points.add(p);
		AllX[0] = p.getX();
		AllY[0] = p.getY();
	}
}
