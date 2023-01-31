package ca.utoronto.utm.paint;

/**
 * 
 *Creates a polyshape depending on where the points are and how many there are
 *
 */
public class ReadPolyShape implements ReadInterface {
	
	private ToolPolyShape Polyshape = new ToolPolyShape();
	private PaintModel model;
	private boolean created;
	
	/**
	 * 
	 * Constructor for polyshape
	 * 
	 * @param m The polyshape to be drawn
	 */
	public ReadPolyShape(PaintModel m) {
		this.model = m;
		this.created = false;
	}
	
	/**
	 * Adds points to the polyshape tool
	 */
	@Override
	public void mousePressed(Point p) {
		if (!(this.model.getCommands().get(this.model.getCommands().size() - 1) instanceof ToolPolyShape)) {
			Polyshape = new ToolPolyShape();
			created = false;
		}
		this.Polyshape.addPoints(p);
		if(created) {
			model.removeCommand();
		}
		else {
			created = true;
		}
			model.addCommand(this.Polyshape);
	}
	
	@Override
	public void mouseReleased(Point p) {
	}
	
	@Override
	public void mouseDragged(Point p) {
	}

	@Override
	public void mouseMoved(Point p) {
	}

	@Override
	public void mouseRight() {
		Polyshape = new ToolPolyShape();
		created = false;
	}
	
}
