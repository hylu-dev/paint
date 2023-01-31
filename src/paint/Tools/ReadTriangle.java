package ca.utoronto.utm.paint;

/**
 * Reads and creates a Triangle from mouse events
 * @author Roy Lu
 *
 */
public class ReadTriangle implements ReadInterface{
	
	private ToolTriangle triangle;
	private PaintModel model;
	private Point pivot;
	private Point p1;
	private Point p2;
	private Point p3;

	
	/**
	 * Constructor for creating a triangle
	 * @author Roy Lu
	 * @param p The PaintModel that will take the triangle object
	 */
	public ReadTriangle(PaintModel p) {
		model = p;
	}
	
	/**
	 * Takes the starting point of the triangle
	 * @author Roy Lu
	 */
	@Override
	public void mousePressed(Point p) {
		pivot = p;
		this.p1 = p;
		this.p2 = p;
		this.p3 = p;
		triangle = new ToolTriangle(p1, p2, p3);
		model.addCommand(this.triangle);
	}
	
	@Override
	public void mouseReleased(Point p) {
	}
	
	/**
	 * Gives visual feedback of triangle drawing size when dragging
	 * @author Roy Lu
	 * 
	 */
	@Override
	public void mouseDragged(Point p) {
		this.triangle.setPoint2(new Point(p.getX() + (p.getX()-pivot.getX()), pivot.getY()));
		this.triangle.setPoint3(new Point((int)(p.getX()), p.getY()));
		model.removeCommand();
		model.addCommand(this.triangle);
	}

	@Override
	public void mouseMoved(Point p) {
	}

	@Override
	public void mouseRight() {
	}

}
