package ca.utoronto.utm.paint;

/**
 * The interface for reading drawable objects from MouseEvents
 * @author Yuting Liu
 */
public interface ReadInterface {
	/**
	 * Reads the point at where the mouse was pressed
	 * @param p The point at where the mouse was pressed
	 */
	public void mousePressed(Point p);
	
	/**
	 * Reads the point at where the mouse was released
	 * @param p The point at where the mouse was released
	 */
	public void mouseReleased(Point p);
	public void mouseMoved(Point p);
	public void mouseDragged(Point p);
	public void mouseRight();
	
	/**
	 * 
	 * @param command
	 * @param m
	 * @return
	 */
	static ReadInterface create(String command, View m) {
		switch(command) {
		case "Circle":
			return new ReadCircle(m.getPaintModel());
		case "Rectangle":
			return new ReadRect(m.getPaintModel());
		case "Square":
			return new ReadSquare(m.getPaintModel());
		case "Triangle":
			return new ReadTriangle(m.getPaintModel());
		case "Squiggle":
			return new ReadSquiggles(m.getPaintModel());
		case "Polyline":
			return new ReadPolyLine(m.getPaintModel());
		case "Polyshape":
			return new ReadPolyShape(m.getPaintModel());
		case "Eraser":
			return new ReadErase(m.getPaintModel());
		case "EyeDrop":
			return new ReadEyeDrop(m, "stroke");
		case "EyeDropFill":
			return new ReadEyeDrop(m, "fill");
		default:
			return null;
		}
	}
}
