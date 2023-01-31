package ca.utoronto.utm.paint;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * An initializer that launches a paint program
 * @author Roy Lu, Yuting Liu, Coco Liang, Russell Lau
 */
public class Paint extends Application {

	PaintModel model; // Model
	View view; // View + Controller
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * 
	 */
	@Override
	public void start(Stage stage) throws Exception {
		this.model = new PaintModel();
		
		// View + Controller
		this.view = new View(model, stage);
	}
}
