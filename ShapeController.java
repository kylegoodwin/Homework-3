import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

/**
 * A shape controller will listen to the mouse of a user and respond to clicks
 * on the window
 * 
 * @author Abdullahi Abdinur, Kyle Goodwin
 * 
 */
public class ShapeController extends MouseAdapter implements ActionListener {
	private DrawingModel model;
	private int x,y;

	public ShapeController(DrawingModel model) {
		this.model = model;
	}

	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			x = e.getX();
			y = e.getY();
			model.addLevel(x,y);
		}
		if (SwingUtilities.isRightMouseButton(e)) {
			x = e.getX();
			y = e.getY();
			model.removeLevel(x,y);
		}

	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Add a level")){
			
			model.addLevel();
		}
		else{
			model.removeLevel();
		}
		
	}
}
