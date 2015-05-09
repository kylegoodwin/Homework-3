import java.awt.Color;
import java.awt.Graphics;

public interface Shape {

	void draw(Graphics g);

	int getX();

	int getY();

	Color getColor();

	int getSize();

	public boolean addLevel();

	public boolean removeLevel();

	public int countLevels();
	
	Shape createChildShape(int index);
	
	void setParent(Shape s);
	
	void setSouth(Shape s);
	
	void setNorth(Shape s);
	
	void setEast(Shape s);
	
	void setWest(Shape s);

	


}
