import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * A class to draw a filledDiamond given the x, y, color and size.
 * 
 * @author open
 * 
 */
public class FilledDiamond extends AbstractShape {
	private int counter;

	/**
	 * creates a filledDiamond object given the x, y, color and size.
	 * 
	 * @param x
	 *            - x coordinate of the diamond.
	 * @param y
	 *            - y coordinate of the diamond.
	 * @param color
	 *            - color of the diamond.
	 * @param size
	 *            - size of the diamond.
	 */
	public FilledDiamond(int x, int y, Color color, int size) {
		super(x, y, color, size);
	}

	/**
	 * draws a diamond in the graphics window passed.
	 */
	public void draw(Graphics g) {
		g.setColor(getColor());
		Polygon p = new Polygon();
		p.addPoint(getX() - (int) ((getSize())), getY());
		p.addPoint(getX(), getY() - (int) ((getSize())));
		p.addPoint(getX() + (int) ((getSize())), getY());
		p.addPoint(getX(), getY() + (int) ((getSize())));
		g.fillPolygon(p);

		if (north != null && north != parent) {
			north.draw(g);
		}
		if (south != null && south != parent) {
			south.draw(g);
		}

		// if (south != null ){
		// if( south != parent ) {
		// south.draw(g);
		// }
		// }

	}

	// Return the name, the coordinates of the center of the shape,
	// its current full size.
	public String toString() {
		return this.getClass() + "(" + getX() + ", " + getY() + ")" + " "
				+ getSize();
	}

	// @Override
	// public boolean addLevel() {
	// counter++;
	// Color color = Color.green;
	// if(countLevels()%2 != 0){
	// color = Color.BLUE;
	// }
	// int size = getSize() / 2;
	// if (north == null) {
	// if (size > 1 && size > 1) {
	//
	// north = new FilledDiamond(getX(), getY() - getSize(),
	// color, getSize() / 2);
	// south = new FilledDiamond(getX(), getY() + getSize(), color,
	// getSize() / 2);
	// east = new FilledDiamond(getX()- getSize(), getY() , color,
	// getSize() / 2);
	// west = new FilledDiamond(getX() + getSize(), getY() , color,
	// getSize() / 2);
	//
	// north.setParent(this);
	//
	//
	// } else if (size < 1 && size < 1) {
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
	public int countLevels() {
		// TODO Auto-generated method stub
		return counter;
	}

	public boolean removeLevel() {
		System.out.println(counter);
		if (counter == 1) {
			north = null;
			south = null;
			west = null;
			east = null;
			return true;
		}

		else {

			north.removeLevel();
			south.removeLevel();
			east.removeLevel();
			west.removeLevel();
			counter--;
		}

		return true;

	}

	@Override
	public Shape createChildShape(int index) {
		// TODO Auto-generated method stub
		if (index == 0) {
			return new FilledDiamond(getX(), getY() - getSize(),
					this.getColor(), getSize() / 2);
		}

		if (index == 1) {
			return new FilledDiamond(getX(), getY() + getSize(),
					this.getColor(), getSize() / 2);
		}

		if (index == 2) {
			return new FilledDiamond(getX() + getSize(), getY(),
					this.getColor(), getSize() / 2);
		}

		return new FilledDiamond(getX() - getSize(), getY(), this.getColor(),
				getSize() / 2);
	}

}
