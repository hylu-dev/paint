package ca.utoronto.utm.paint;

/**
 * 
 *Creates a line follows the mouse when dragged
 *
 */
public class ReadSquiggles implements ReadInterface {
	
	private ToolSquiggle Squiggle;
	private PaintModel model;
	
	/**
	 * 
	 * Constructor for Squiggles
	 * 
	 * @param m The squiggle to be drawn
	 */
	public ReadSquiggles(PaintModel m) {
		this.model = m;
	}
	
	/**
	 * Creates a new Squiggle command
	 */
	@Override
	public void mousePressed(Point p) {
		this.Squiggle = new ToolSquiggle();
		model.addCommand(this.Squiggle);
	}
	
	@Override
	public void mouseReleased(Point p) {
	}
	
	/**
	 * Each time the mouse is dragged, add a new point to the Squiggle command that follows the mouse
	 */
	@Override
	public void mouseDragged(Point p) {
		this.Squiggle.addPoints(p);
		
		model.removeCommand();
		model.addCommand(this.Squiggle);
	}

	@Override
	public void mouseMoved(Point p) {
	}

	@Override
	public void mouseRight() {
	}
	
}
