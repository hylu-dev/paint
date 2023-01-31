package ca.utoronto.utm.paint;

/**
 * A strategy for erasing on onto a graphics context
 *
 */
public class ReadErase implements ReadInterface {
    private PaintModel model;
    private ToolErase eraser;
    private int width = 20;
    
    /**
     * A constructor for an eraser strategy
     * 
     * @param p a model to obtain add an erasing command
     */
    public ReadErase(PaintModel p) {
        model = p;
    }
   
    /**
     * creates a new erasing command on click
     * 
     */
	@Override
	public void mousePressed(Point p) {
		eraser = new ToolErase();
		model.addCommand(eraser);
	}

	@Override
	public void mouseReleased(Point p) {
	}

	/**
	 * when moving the mouse, a guide to show the erasing size
	 * 
	 */
	@Override
	public void mouseMoved(Point p) {
	}

	/**
	 * Keep erasing as long as the mouse is dragged
	 * 
	 */
	@Override
	public void mouseDragged(Point p) {
		eraser.addErasePoints(p);
		model.removeCommand();
		model.addCommand(eraser);
	}

	@Override
	public void mouseRight() {
	}

}
