package ca.utoronto.utm.paint;

/**
 * 
 * Allows a polyline to be drawn according to mouse inputs
 *
 */
public class ReadPolyLine implements ReadInterface {
	
	private Point point;
	private Line line;
	private PaintModel model;
	/**
	 * 
	 * Constructor for a polyline
	 * 
	 * @param polyline a polyline to be used
	 * @param model takes the polyline to be drawn
	 */
	public ReadPolyLine(PaintModel model) {
		this.model = model;
	}
	
	/**
	 * When the mouse is pressed a new a point into the polyline
	 * 
	 */
	@Override
	public void mousePressed(Point p) {
		this.point = p;
		this.line = new Line(this.point, p);
		model.addCommand(this.line);
	}
	
	@Override
	public void mouseReleased(Point p) {
	}

	/**
	 * Give feedback on next line segment when dragging
	 * 
	 */
	@Override
	public void mouseDragged(Point p) {
		if (this.point == null) {
			return;
		}
		this.line.setStart(this.point);
		this.line.setEnd(p);
		model.addCommand(this.line);
		model.removeCommand();
	}
	
	/**
	 * Give feedback on next line segment when moving
	 * 
	 */
	@Override
	public void mouseMoved(Point p) {
		if (this.point == null) {
			return;
		}
		this.line.setStart(this.point);
		this.line.setEnd(p);
		model.addCommand(this.line);
		model.removeCommand();
	}

	/**
	 * Cancels adding new segments to the current polyline separates from next added point
	 * 
	 */
	@Override
	public void mouseRight() {
		if (this.point != null) {
			model.removeCommand();
			this.point = null;
		}
	}

}
