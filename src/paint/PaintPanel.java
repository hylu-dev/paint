package ca.utoronto.utm.paint;

import javafx.event.EventHandler;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

/**
 * A panel that contains the drawable canvas and can draw with the mouse
 *
 */
class PaintPanel extends StackPane implements Observer, EventHandler<MouseEvent> {

	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	private int mouseX;
	private int mouseY;

	private ResizableCanvas canvas;
	
	private ReadInterface readface;
	private DrawCommand drawcom;
	GraphicsContext g;

	/**
	 * Constructor for a paint panel for drawing
	 * 
	 * @param model holds and sends drawing commands for the paint panel
	 * @param view
	 */
	public PaintPanel(PaintModel model, View view) {

		this.canvas = new ResizableCanvas(width, height);
		this.getChildren().add(this.canvas);

		this.setStyle("-fx-background-color: white");
		this.g = this.canvas.getGraphicsContext2D();
		
		this.addEventHandler(MouseEvent.ANY, this);
		this.model = model;
		this.model.addObserver(this);

		this.view = view;
		
		DrawCommand drawcom = new DrawColor();
		drawcom.setValue(Color.BLACK);
		model.addCommand(drawcom);
		drawcom = new DrawFill();
		drawcom.setValue(Color.TRANSPARENT);
		model.addCommand(drawcom);
		drawcom = new DrawWeight();
		drawcom.setValue(5.0);
		model.addCommand(drawcom);
	}

	/**
	 * Refreshes the canvas and applies all the drawing commands in order
	 * 
	 */
	public void repaint() {
		g.clearRect(0, 0, this.width, this.height);
		g.setLineCap(StrokeLineCap.ROUND);

		for (Command command : model.getCommands()) {
			command.draw(g);
		}
	}

	/**
	 * Calls for the canvas to be refreshed
	 * 
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.repaint();
	}
	
	/**
	 * Converts a color to a hex color
	 * 
	 * @param c color to convert
	 */
	public static String getHex(Color c) {
		int r = (int) Math.round(c.getRed()*255);
		int g = (int) Math.round(c.getGreen()*255);
		int b = (int) Math.round(c.getBlue()*255);
		return String.format("#%02X%02X%02X", r, g, b);
	}
	
	/**
	 * Getter for the width of the screen
	 * 
	 * @return screen width
	 */
	public double getScreenWidth() {
		return width;
	}
	
	/**
	 * Getter for the height of the screen
	 * 
	 * @return screen height
	 */
	public double getScreenHeight() {
		return height;
	}

	/**
	 * Changes the read interface that the mouse uses to draw
	 * 
	 * @param d read interface to set
	 */
	public void setReadInterface(ReadInterface d) {
		readface = d;
	}
	
	/**
	 * Getter for the read interface
	 * 
	 * @return the read interface
	 */
	public ReadInterface getReadInterface() {
		return readface;
	}

	/**
	 * Getter for the paint model
	 * 
	 * @return the paint model
	 */
	public PaintModel getModel() {
		return model;
	}
	
	/**
	 * getter for the canvas
	 * 
	 * @return the canvas
	 */
	public ResizableCanvas getCanvas() {
		return this.canvas;
	}

	/**
	 * Interprets which mouse events are being called
	 * 
	 */
	@Override
	public void handle(MouseEvent event) {
		view.getDisplayInfoPanel().getCanvasLabel().setText("Canvas Size: " + (int)canvas.getWidth()+ "x" + (int)canvas.getHeight());
		if (event.getX() > 0 && event.getY() > 0 && event.getX() <(int)canvas.getWidth() 
				&& event.getY() < (int)canvas.getHeight()) {
			view.getDisplayInfoPanel().getLabel().setText("X: " + (int)event.getX() + "Y: " +(int)event.getY());
		}
		else {
			view.getDisplayInfoPanel().getLabel().setText("");
		}
		if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			mouseDragged(event);
			this.repaint();
		} else if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
			mousePressed(event);
			this.repaint();
		} else if (event.getEventType() == MouseEvent.MOUSE_MOVED) {
			mouseMoved(event);
			this.repaint();
		} else if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
			mouseClicked(event);
			this.repaint();
		} else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
			mouseReleased(event);
			this.repaint();
		} else if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
			mouseEntered(event);
			this.repaint();
		} else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
			mouseExited(event);
			this.repaint();
		}
	}

	/**
	 * For the current readface, signals it to perform it's strategy for moving the mouse
	 * 
	 * @param e the mouse event
	 */
	private void mouseMoved(MouseEvent e) {
		readface.mouseMoved(new Point((int) e.getX(), (int) e.getY()));
	}
	
	/**
	 * For the current readface, signals it to perform it's strategy for dragging the mouse
	 * 
	 * @param e the mouse event
	 */
	private void mouseDragged(MouseEvent e) {
		readface.mouseDragged(new Point((int) e.getX(), (int) e.getY()));
	}


	/**
	 * For the current readface, signals it to perform it's strategy for clicking the mouse
	 * 
	 * @param e the mouse event
	 */
	private void mouseClicked(MouseEvent e) {
	}
	
	
	/**
	 * For the current readface, signals it to perform it's strategy for pressing the mouse
	 * 
	 * @param e the mouse event
	 */
	private void mousePressed(MouseEvent e) {
		if (e.isSecondaryButtonDown()) {
			readface.mouseRight();
			return;
		}
		readface.mousePressed(new Point((int) e.getX(), (int) e.getY()));
	}
	
	/**
	 * For the current readface, signals it to perform it's strategy for releasing the mouse
	 * 
	 * @param e the mouse event
	 */
	private void mouseReleased(MouseEvent e) {
		readface.mouseReleased(new Point((int) e.getX(), (int) e.getY()));
	}

	/**
	 * getter for the horizontal position of the mouse
	 * 
	 * @return the mouse x position
	 */
	public int getMouseX() {
		return this.mouseX;
	}
	
	/**
	 * getter for the vertical position of the mouse
	 * 
	 * @return the mouse y position
	 */
	public int getMouseY() {
		return this.mouseY;
	}
	
	/**
	 * For the current readface, signals it to perform it's strategy for entering with the mouse
	 * 
	 * @param e the mouse event
	 */
	private void mouseEntered(MouseEvent e) {
	}
	
	/**
	 * For the current readface, signals it to perform it's strategy for exiting the mouse
	 * 
	 * @param e the mouse event
	 */
	private void mouseExited(MouseEvent e) {
	}
}
