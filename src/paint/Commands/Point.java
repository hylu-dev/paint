package ca.utoronto.utm.paint;

/**
 * 
 * Is a point that consist of an X and Y location
 *
 */
public class Point {
	int x, y;

	Point() {
	}
	
	/**
	 * Constructor for Point
	 * @param x The horizontal position
	 * @param y The vertical position
	 */
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Outputs the X value of the point
	 * @return Return the X value
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets a X value to the point
	 * @param x The value to be set as the new horizontal value
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Outputs the Y value of the point
	 * @return Return the Y value
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets a Y value to the point
	 * @param x The value to be set as the new vertical value
	 */
	public void setY(int y) {
		this.y = y;
	}

}
