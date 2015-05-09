import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;

import javax.swing.JPanel;

/**
 * Creates a panel which shapes can be added to for display in the graphics
 * window
 * 
 * @author Abdullahi Abdinur,Kyle Goodwin
 * 
 */
public class ShapePanel extends JPanel implements DrawingView {

	private DrawingModel model;

	/**
	 * Updates the window with the latest graphics
	 */
	public void update(DrawingModel m) {
		this.model = m;
		repaint();
	}

	/**
	 * Override the paintComponet method to display new kinds of graphics
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;

		// Turn Antialiasing on
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		if (model != null) {
			List<Shape> shapes = model.getShapes();
			for (Shape s : shapes) {
				s.draw(g2D);
				

			}

		}
	}

}
