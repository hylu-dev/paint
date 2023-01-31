package ca.utoronto.utm.paint;


import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 * A strategy for getting color from a graphics context
 *
 */
public class ReadEyeDrop implements ReadInterface{
    private View view;
    private WritableImage img;
    private PixelReader pr;
    private int x;
    private int y;
    private String type;
    private Color eyeDropColor;
	public ReadEyeDrop(View v, String type) {
		this.view = v;
		this.type = type;
		this.img = new WritableImage((int)view.getPaintPanel().getWidth(), (int)view.getPaintPanel().getHeight());
		System.out.print("PRINTED");
	}

	/**
	 * When pressed, capture the color of the area of the cursor
	 * 
	 */
	@Override
	public void mousePressed(Point p) {
		x = p.getX();
		y= p.getY();
		WritableImage snap = (view.getPaintPanel().snapshot(null, img));
		pr = snap.getPixelReader();
		int color = pr.getArgb((int)x, (int) y);
        int red = (color >> 16) & 0xff;
        int green = (color >> 8) & 0xff;
        int blue = color & 0xff;
		eyeDropColor = Color.rgb(red, green, blue);
	}

	/**
	 * Set either the stroke or the fill to the captured color on release
	 * 
	 */
	@Override
	public void mouseReleased(Point p) {
		
		
        
		//System.out.println("IM PRESSED" + eyeDropColor);
		switch (type) {
		case "stroke":
			DrawCommand drawcom = new DrawColor();
			drawcom.setValue((Color)eyeDropColor);
			view.getPaintModel().addCommand(drawcom);
			break;
		case "fill":
			DrawCommand fillcom = new DrawFill();
			fillcom.setValue((Color)eyeDropColor);
			if (this.view.getShapePropertyPanel().getCheckFill()) {
				view.getPaintModel().addCommand(fillcom);
			}
			break;
		default:
			break;
		}
		
	}

	/**
	 * 
	 */
	@Override
	public void mouseMoved(Point p) {

	}

	/**
	 * 
	 */
	@Override
	public void mouseDragged(Point p) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	@Override
	public void mouseRight() {
		// TODO Auto-generated method stub
		
	}

}
