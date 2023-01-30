package ca.utoronto.utm.paint;
/**
 * Reads and creates a circle from mouse events
 * 
 *
 */
public class ReadCircle implements ReadInterface{
	ToolCircle circle;
	PaintModel model;

	
	/**
	 * Creates the basis for reading and creating a circle
	 * 
	 * @param c The circle that is being built
	 * @param p The PaintModel that will take the circle object
	 */
	public ReadCircle(PaintModel p) {
		model = p;
	}
	
	/**
	 * Takes the point at which the circle is centred
	 */
	@Override
	public void mousePressed(Point centre) {
		int radius = 0;
		circle = new ToolCircle(centre, radius);
		model.addCommand(this.circle);
	}
	
	/**
	 * Takes the point at which the circle's edge should be, and creates the circle
	 */
	@Override
	public void mouseReleased(Point p) {
		int radius = (int) Math.sqrt((Math.pow((int) circle.getCentre().getX() - (int) p.getX(), 2)+
				Math.pow(((int) circle.getCentre().getY() - (int) p.getY()), 2)));
		this.circle.setRadius(radius);
		model.removeCommand();
		model.addCommand(this.circle);
		//System.out.println(model.getCommands());
	}

	/**
	 * Takes the point at which the circle's edge should be every time the mouse is dragged, and creates the circle
	 */
	@Override
	public void mouseDragged(Point p) {
		int radius = (int) Math.sqrt((Math.pow((int) circle.getCentre().getX() - (int) p.getX(), 2)+
				Math.pow(((int) circle.getCentre().getY() - (int) p.getY()), 2)));
		this.circle.setRadius(radius);
		model.removeCommand();
		model.addCommand(this.circle);
	}

	@Override
	public void mouseMoved(Point p) {
	}

	@Override
	public void mouseRight() {
	}

}
