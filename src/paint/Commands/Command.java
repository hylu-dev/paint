package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

/**
 * A command designed to draw onto a graphics context
 *
 */
interface Command {
	abstract void draw(GraphicsContext g);
}
