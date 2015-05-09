import java.awt.Color;
import java.awt.Graphics;

/**
 * Creates a plus in the graphics window, represented by 2 lines
 * 
 * @author Abdullahi Abdinur, Kyle Goodwin
 * 
 */
public class Plus extends AbstractShape {

	private int counter;

	// Constucts a new shape withe the given parameters
	public Plus(int x, int y, Color color, int size) {
		super(x, y, color, size);
		this.parent = parent;

	}

	// Adds the plus to the graphics window
	public void draw(Graphics g) {
		// draw a plus centered at (x,y) with the given size
		// Use 2 lines to draw the plus
		g.setColor(getColor());
		g.drawLine(getX(), getY() + getSize(), getX(), getY() - getSize());
		g.drawLine(getX() + getSize(), getY(), getX() - getSize(), getY());

		// if (north != null ) {
		//
		// if(north != parent){
		// north.draw(g);
		// }
		// if(south != parent){
		// south.draw(g);
		// }
		// if(east != parent){
		// east.draw(g);
		// }
		// if(west != parent){
		// west.draw(g);
		// }
		//
		// }
		if (north != null && north != parent) {
			north.draw(g);
		}
		if (south != null && south != parent) {
			south.draw(g);
		}
		// south.draw(g);
		// south.draw(g);
		// east.draw(g);
		// west.draw(g);
		// }else{
		// north.draw(g);
		// east.draw(g);
		// west.draw(g);
		// }

	}

	// Return the name, the coordinates of the center of the shape,
	// its current full size.
	public String toString() {
		return this.getClass() + "(" + getX() + ", " + getY() + ")" + " "
				+ getSize();
	}

	public int countLevels() {
		return counter;
		// if (north == null && east == null && west == null && south == null) {
		// return 1;
		// } else if (north != parent) {
		// return 1 + north.countLevels();
		// } else if (south != parent) {
		// return 1 + south.countLevels();
		// } else {
		// throw new IllegalArgumentException();
		// }
	}

	// @Override
	// public boolean addLevel() {
	// counter ++;
	// int size = getSize() / 2;
	// if (north == null) {
	// if (size > 5) {
	//
	// Plus p = this;
	//
	// north = new Plus(getX(), getY() - getSize(), this.getColor(),
	// getSize() / 2,p);
	// south = new Plus(getX(), getY() + getSize(), this.getColor(),
	// getSize() / 2,p);
	// east = new Plus(getX()- getSize(), getY() , this.getColor(),
	// getSize() / 2,p);
	// west = new Plus(getX() + getSize(), getY() , this.getColor(),
	// getSize() / 2,p);
	//
	// north.setParent(this);
	// // south.setParent(this);
	// // east.setParent(this);
	// // west.setParent(this);
	//
	//
	// } else {
	// return false;
	// }
	// }
	//
	// else if (north != null && size > 5) {
	//
	// north.addLevel();
	// south.addLevel();
	// west.addLevel();
	// east.addLevel();
	//
	// }
	// return true;
	// }

	@Override
	public boolean removeLevel() {
		if (counter == 1) {
			north = null;
			south = null;
			west = null;
			east = null;
			return false;
		} else if (counter == 0) {
			return false;
		} else {

			north.removeLevel();
			south.removeLevel();
			east.removeLevel();
			west.removeLevel();
			counter--;
		}

		return true;

	}

	// create a child shape based on the index of the element
	// N,S,E,W
	@Override
	public Shape createChildShape(int index) {
		// TODO Auto-generated method stub
		if (index == 0) {
			return new Plus(getX(), getY() - getSize(), this.getColor(),
					getSize() / 2);
		}

		if (index == 1) {
			return new Plus(getX(), getY() + getSize(), this.getColor(),
					getSize() / 2);
		}

		if (index == 2) {
			return new Plus(getX() + getSize(), getY(), this.getColor(),
					getSize() / 2);
		}

		return new Plus(getX(), getY() - getSize(), this.getColor(),
				getSize() / 2);
	}

}
