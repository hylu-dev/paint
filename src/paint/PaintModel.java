package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

/**
 * A model that holds all commands to a paint program send them to be drawn when needed
 * 
 *
 */
public class PaintModel extends Observable {

	private ArrayList<Command> commands = new ArrayList<Command>();

	/**
	 * getter for the ArrayList of commands
	 * 
	 * @return Arraylist of commands
	 */
	public ArrayList<Command> getCommands() {
		return commands;
	}
	
	/**
	 * Adds a command to the commands ArrayList
	 * 
	 * @param s a command to be added
	 */
	public void addCommand(Command s) {
		this.commands.add(s);
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Adds a command to a specified index in the command ArrayList
	 * 
	 * @param s a command to be added
	 * @param index the location to add the command
	 */
	public void addCommand(Command s, int index) {
		this.commands.add(index, s);;
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Removes a command from the commands ArrayList
	 * 
	 */
	public void removeCommand() {
		this.commands.remove(this.commands.size() - 1);
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 *  Removes a command from a specified index in the commands ArrayList
	 * 
	 * @param index the location to remove the command
	 */
	public void removeCommand(int index) {
		this.commands.remove(index);
		this.setChanged();
		this.notifyObservers();
		//System.out.println(commands);
	}
}
