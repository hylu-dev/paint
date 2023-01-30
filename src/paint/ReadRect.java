package ca.utoronto.utm.paint;

/**
 * 
 * Creates a rectangle based on mouse location
 *
 */
public class ReadRect implements ReadInterface{   
    private ToolRectangle rect;
    private PaintModel model;
    private int pivX;
    private int pivY;
    
    /**
     * Constructor for Square
     * @param p Takes the square to be drawn
     */
    public ReadRect(PaintModel p) {
        model = p;
    }
   
    /**
     * When a mouse button is pressed, create a new rectangle and set the point clicked as a pivot point
     */
    @Override
    public void mousePressed(Point p) {
    	int length = 0;
        int width = 0;
        this.rect = new ToolRectangle(p, length, width);
        pivX = (int) p.getX();
        pivY = (int) p.getY();
        model.addCommand(this.rect);
    }

    /**
     * Creates the final rectangle when released based on mouse location and its distance from the pivot point
     */
    @Override
    public void mouseReleased(Point p) {
        int length = (int) p.getX() - pivX;
        int width = (int) p.getY() - pivY;
        this.rect.getCorner().setX(pivX);
        this.rect.getCorner().setY(pivY);
        if (length < 0) {
            this.rect.getCorner().setX(pivX+length);
            this.rect.setLength(-length);
        } else {
            this.rect.setLength(length);
        }
        if (width < 0) {
            this.rect.getCorner().setY(pivY+width);
            this.rect.setWidth(-width);
        } else {
            this.rect.setWidth(width);
        }
        model.removeCommand();
        model.addCommand(this.rect);
    }


    /**
     * Creates a rectangle each time the mouse is dragged based on mouse location and its distance from the pivot point
     */
    @Override
    public void mouseDragged(Point p) {
        int length = (int) p.getX() - pivX;
        int width = (int) p.getY() - pivY;
        this.rect.getCorner().setX(pivX);
        this.rect.getCorner().setY(pivY);
        if (length <= 0) {
            this.rect.getCorner().setX(pivX+length);
            this.rect.setLength(-length);
        } else {
            this.rect.setLength(length);
        }
        if (width <= 0) {
            this.rect.getCorner().setY(pivY+width);
            this.rect.setWidth(-width);
        } else {
            this.rect.setWidth(width);
        }
        model.removeCommand();
        model.addCommand(this.rect);
       
    }

	@Override
	public void mouseMoved(Point p) {
	}

	@Override
	public void mouseRight() {
	}
	
}


	
