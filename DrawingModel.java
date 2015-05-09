import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * The model holds the data of the polygon.
 * 
 * @authors Abdullahi Abdinur,Kyle Goodwin.
 * 
 */
public class DrawingModel {
	// data of the polygon.
	private ArrayList<Shape> shapes = new ArrayList<Shape>();//
	private ArrayList<DrawingView> drawingList = new ArrayList<DrawingView>();

	/**
	 * Adds a view to the list of views in the model.
	 * 
	 */
	public DrawingModel() {
		drawShapes();

	}

	/**
	 * Add all the shapes you want to display in the graphics window.
	 */
	public void drawShapes() {
		addPlus(100, 100, Color.BLACK, 50);
		addDiamond(200, 300, Color.GREEN, 50);

	}

	/**
	 * Adds a view to the list of views in the model.
	 */
	public void addView(DrawingView v) {
		drawingList.add(v);
		v.update(this);
	}

	/**
	 * Update all of the views following a change in the model.
	 */
	public void updateAll() {
		for (DrawingView v : drawingList) {
			v.update(this);
		}
	}

	/**
	 * Adds a plus in the list of shapes.
	 */
	public void addPlus(int x, int y, Color color, int size) {
		Plus plus = new Plus(x, y, color, size);
		shapes.add(plus);
		updateAll();
	}

	/**
	 * Adds a filled diamond in the list of shapes.
	 */
	public void addDiamond(int x, int y, Color color, int size) {
		FilledDiamond diamond = new FilledDiamond(x, y, color, size);
		shapes.add(diamond);
		updateAll();
	}

	/**
	 * returns all the shapes to the client.
	 */
	public List<Shape> getShapes() {
		return shapes;
	}

	// add a level from an action listener.
	public void addLevel(int x, int y) {
		for (Shape s : getShapes()) {
			if ((x <= s.getX() + s.getSize() && x >= s.getX() - s.getSize())
					&& (y <= s.getY() + s.getSize() && y >= s.getY()
							- s.getSize())) {
				boolean success = s.addLevel();
				if (!success) {
					JOptionPane.showMessageDialog(null,
							"Can't add a level", "Box viewer",
							JOptionPane.INFORMATION_MESSAGE);
				} 
			}
		}
		updateAll();

	}
	
	// add a level
	public void addLevel(){
		for (Shape s : getShapes()) {
			
			boolean success = s.addLevel();
//			System.out.println(success);
			if (!success) {
				JOptionPane.showMessageDialog(null,
						"Can't remove an inner box", "DrawingModel ",
						JOptionPane.INFORMATION_MESSAGE);
			} 

			
		}
		updateAll();
	}
	
	// remove a level
	public void removeLevel(){
		for (Shape s : getShapes()) {
			
				s.removeLevel();

			
		}
		updateAll();
	}

	// remove a level from a mouse click.
	public void removeLevel(int x, int y) {
		for (Shape s : getShapes()) {
			if ((x <= s.getX() + s.getSize() && x >= s.getX() - s.getSize())
					&& (y <= s.getY() + s.getSize() && y >= s.getY()
							- s.getSize())) {
				s.removeLevel();

			}
		}
		updateAll();
		
	}

}
