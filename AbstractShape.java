import java.awt.Color;

/**
 * An outline for the new shapes which we create, also holds the position, size,
 * and color of the shapes.
 * 
 * @author Abdullahi Abdinur, Kyle Goodwin
 * 
 */

public abstract class AbstractShape implements Shape {

	private int x, y;
	private int size;
	private Color color;
	protected Shape north, south, east, west, parent;

	
	/**
	 * Constructs a new shape, and initializes the variables so that other
	 * objects can access them
	 * 
	 * @param x
	 *            the x position of the shape
	 * @param y
	 *            the y position of the shape
	 * @param color
	 *            the color of the shape
	 * @param size
	 *            the size of the shape
	 */
	public AbstractShape(int x, int y, Color color, int size) {

		this.x = x;
		this.y = y;
		this.color = color;
		this.size = size;
	}

	public boolean addLevel() {
		
		boolean bNorth = true;
		boolean bSouth = true;
		if (north == null) {
			// create a north shape.
			north= createChildShape(0);

			if (north != null) {
				north.setParent(this);
				north.setSouth(this);
			} else {
				bNorth = false;
			}
		} else if (north != parent) {
			bNorth = north.addLevel();
		}
		
		if (south == null) {
			// create a north shape.
			south= createChildShape(1);

			if (south != null) {
				south.setParent(this);
				 south.setNorth(this);
			} else {
				bSouth = false;
			}
		} else if (south != parent) {
			bSouth = south.addLevel();
		}
	
		
		
		return bNorth && bSouth;
	}

	// Returns the x position of the shape on the graphics window
	public int getX() {
		return x;
	}

	// Returns the y position of the shape on the graphics window
	public int getY() {
		return y;
	}

	// Returns the height of the shape
	public int getSize() {
		return size;
	}

	// Returns the color of the shape
	public Color getColor() {
		return color;
	}

	public void setParent(Shape s) {
		System.out.println(s);
		this.parent = s;

	}
	
	public void setSouth(Shape s){
		south= s;
	}
	
	public void setNorth(Shape s){
		north= s;
	}
	
	public void setWest(Shape s){
		west= s;
	}
	
	public void setEast(Shape s){
		east = s;
	}

	
}
