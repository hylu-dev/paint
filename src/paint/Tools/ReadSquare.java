package ca.utoronto.utm.paint;

/**
 * 
 * Creates a square based on mouse location
 *
 */
public class ReadSquare implements ReadInterface {
   
    private ToolRectangle square;
    private PaintModel model;
    double strokeWeight = 1;


    int pivX;
    int pivY;
   
    /**
     * Constructor for Square
     * @param p Takes the square to be drawn
     */
    public ReadSquare(PaintModel p) {
        model = p;
    }

    /**
     * When a mouse button is pressed, create a new square and set the point clicked as a pivot point
     */
    @Override
    public void mousePressed(Point p) {
        int length = 0;
        int width = 0;
        this.square = new ToolRectangle(p, length, width);
        pivX = p.getX();
        pivY = p.getY();
        model.addCommand(this.square);
    }

    /**
     * Creates the final square when released based on mouse location and its distance from the pivot point
     */
    @Override
    public void mouseReleased(Point p) {
    	int length = (int) p.getX() - pivX;
        int width = (int) p.getY() - pivY;
        this.square.getCorner().setX(pivX);
        this.square.getCorner().setY(pivY);
        if (length < 0 && width < 0) {
        	if (length > width) {
        		this.square.getCorner().setX(pivX+length);
            	this.square.getCorner().setY(pivY+length);
            	this.square.setLength(-length);
            	this.square.setWidth(-length);
        	} else {
        		this.square.getCorner().setX(pivX+width);
            	this.square.getCorner().setY(pivY+width);
            	this.square.setLength(-width);
            	this.square.setWidth(-width);
        	}
        } else if (width > 0 && length < 0) {
        	if (-length > width) {
        		this.square.getCorner().setX(pivX-width);
            	this.square.setLength(width);
            	this.square.setWidth(width);
        	} else {
        		this.square.getCorner().setX(pivX+length);
            	this.square.setLength(-length);
            	this.square.setWidth(-length);
        	}
        } else if (length > 0 && width < 0) {
        	if (-width > length) {
        		this.square.getCorner().setY(pivY-length);
            	this.square.setLength(length);
            	this.square.setWidth(length);
        	} else {
        		this.square.getCorner().setY(pivY+width);
            	this.square.setLength(-width);
            	this.square.setWidth(-width);
        	}
        } else {
        	if (width > length) {
        		this.square.setWidth(length);
            	this.square.setLength(length);
        	} else {
        		this.square.setLength(width);
            	this.square.setWidth(width);
        	}
        }
        model.removeCommand();
        model.addCommand(this.square);

    }

    /**
     * Creates the square when the mouse is dragged based on mouse location and its distance from the pivot point
     */
    @Override
    public void mouseDragged(Point p) {
        int length = (int) p.getX() - pivX;
        int width = (int) p.getY() - pivY;
        this.square.getCorner().setX(pivX);
        this.square.getCorner().setY(pivY);
        		
        if (length < 0 && width < 0) {
        	if (length > width) {
        		this.square.getCorner().setX(pivX+length);
            	this.square.getCorner().setY(pivY+length);
            	this.square.setLength(-length);
            	this.square.setWidth(-length);
        	} else {
        		this.square.getCorner().setX(pivX+width);
            	this.square.getCorner().setY(pivY+width);
            	this.square.setLength(-width);
            	this.square.setWidth(-width);
        	}
        } else if (width > 0 && length < 0) {
        	if (-length > width) {
        		this.square.getCorner().setX(pivX-width);
            	this.square.setLength(width);
            	this.square.setWidth(width);
        	} else {
        		this.square.getCorner().setX(pivX+length);
            	this.square.setLength(-length);
            	this.square.setWidth(-length);
        	}
        } else if (length > 0 && width < 0) {
        	if (-width > length) {
        		this.square.getCorner().setY(pivY-length);
            	this.square.setLength(length);
            	this.square.setWidth(length);
        	} else {
        		this.square.getCorner().setY(pivY+width);
            	this.square.setLength(-width);
            	this.square.setWidth(-width);
        	}
        } else {
        	if (width > length) {
        		this.square.setWidth(length);
            	this.square.setLength(length);
        	} else {
        		this.square.setLength(width);
            	this.square.setWidth(width);
        	}
        }
        model.removeCommand();
        model.addCommand(this.square);
       
    }


	@Override
	public void mouseMoved(Point p) {
	}


	@Override
	public void mouseRight() {
	}
}

