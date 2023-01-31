package ca.utoronto.utm.paint;

/**
 * A command designed to set a property onto a graphics context
 *
 */
public interface DrawCommand extends Command {
	abstract void setValue(Object o);
}