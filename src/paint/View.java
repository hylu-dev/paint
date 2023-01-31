package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * the visual representation of paint is made by displaying all the panels
 * @author Roy Lu, Yuting Liu, Coco Liang, Russell Lau
 */
public class View implements EventHandler<ActionEvent> {

	private PaintModel model;
	private PaintPanel paintPanel;
	private ToolChooserPanel toolChooserPanel;
	private ShapePropertyPanel shapePropertyPanel;
	private DisplayInfoPanel displayInfoPanel;
	private UndoPanel undoPanel;
	private BorderPane root;
	
	public View(PaintModel model, Stage stage) {
		
		this.model = model;
		initUI(stage);
	}

	/**
	 * Holds all the panels and other visuals onto a single panel
	 * 
	 * @param stage that holds all visuals
	 */
	private void initUI(Stage stage) {

		this.paintPanel = new PaintPanel(this.model, this);
		this.toolChooserPanel = new ToolChooserPanel(this);
		this.shapePropertyPanel = new ShapePropertyPanel(this);
		this.displayInfoPanel = new DisplayInfoPanel();
		this.undoPanel = new UndoPanel(this);
		root = new BorderPane();
		root.setStyle("-fx-background-color: #555555" );
		VBox vbox = new VBox();
		vbox.getChildren().addAll(createMenuBar(), this.shapePropertyPanel);
		root.setTop(vbox);
		vbox = new VBox();
		vbox.getChildren().addAll(this.undoPanel, this.toolChooserPanel);
		root.setLeft(vbox);
		root.setCenter(this.paintPanel);
		root.setBottom(this.displayInfoPanel);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Paint");
		stage.show();
	}

	/**
	 * getter for the paint panel
	 * 
	 * @return the paint panel
	 */
	public PaintPanel getPaintPanel() {
		return paintPanel;
	}
	
	/**
	 * getter for the paint model
	 * 
	 * @return the paint model
	 */
	public PaintModel getPaintModel() {
		return model;
	}

	/**
	 * getter for the shape chooser panel
	 * 
	 * @return the shape chooser panel
	 */
	public ToolChooserPanel getShapeChooserPanel() {
		return toolChooserPanel;
	}
	
	/**
	 * getter for the shape property panel
	 * 
	 * @return the shape property panel
	 */
	public ShapePropertyPanel getShapePropertyPanel() {
		return shapePropertyPanel;
	}
	
	/**
	 * getter for the display info panel
	 * 
	 * @return the display info panel
	 */
	public DisplayInfoPanel getDisplayInfoPanel() {
		return displayInfoPanel;
	}
	
	/**
	 * getter for the background
	 * 
	 * @return the background
	 */
	public Image getBackground() {
		return (Image) root.getBackground().getImages();
	}
	
	/**
	 * Creates a bar that holds editing and file functionality
	 * 
	 * @return the menu bar
	 */
	private MenuBar createMenuBar() {

		MenuBar menuBar = new MenuBar();
		Menu menu;
		MenuItem menuItem;
		menuBar.setStyle("-fx-background-color: #555555; -fx-text-fill: white;");

		// A menu for File
		Label label = new Label("File");
		label.setStyle("-fx-background-color: #555555; -fx-text-fill: #DDDDDD; -fx-text-fill: #DDDDDD; -fx-font: 16px \"Arial\"");
		menu = new Menu();
		menu.setGraphic(label);
		
		menuItem = new MenuItem("New");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Open");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Save");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menu.getItems().add(new SeparatorMenuItem());

		menuItem = new MenuItem("Exit");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);

		// Another menu for Edit

		label = new Label("Edit");
		label.setStyle("-fx-background-color: #555555; -fx-text-fill: #DDDDDD; -fx-text-fill: #DDDDDD; -fx-font: 16px \"Arial\"");
		menu = new Menu();
		menu.setGraphic(label);
		
		menuItem = new MenuItem("Clear Canvas");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);
		
		return menuBar;
	}

	/**
	 * prints the menubar commands or enacts them if implmented
	 * 
	 */
	@Override
	public void handle(ActionEvent event) {
		String e = ((MenuItem)event.getSource()).getText();
		if (e == "Clear Canvas") {
			
			CommandClear com = new CommandClear();
			com.setSize(this.paintPanel.getScreenWidth(), this.paintPanel.getScreenWidth());
			this.getPaintModel().addCommand(com);
		}
		//System.out.println(((MenuItem)event.getSource()).getText());
	}
}
