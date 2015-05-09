import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * This class creates a window and brings together the model and view
 * and allows the related objects to interact. 
 * 
 * @author Abdullahi Abdinur, Kyle Goodwin
 *
 */
public class MainClass {

	public static final int WIDTH = 500;
	public static final int HEIGHT = 400;
	public static void main(String[] args) {

		// Create a graphics view and put it in a window
		JFrame frame = new JFrame("Shapes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setSize(500, 400);
		DrawingModel model = new DrawingModel();

		// place a label at the top of the window.
		ShapePanel panel = new ShapePanel();
		frame.add(panel);
		model.addView(panel);
		frame.setVisible(true);
		
		//test Button group
		
		
		
		// add a text view.
		TextViewer text = new TextViewer(model);
		text.display();
		
		// add a controller.
		ShapeController controller = new ShapeController(model);
		frame.addMouseListener(controller);
		
		// test button 
		JButton button = new JButton("Add a level");
		JButton button2 = new JButton("Remove a level");
		JPanel panel1 = new JPanel();
		panel1.add(button);
		panel1.add(button2);
		frame.add(panel1,BorderLayout.SOUTH);
		button.addActionListener(controller);
		button2.addActionListener(controller);
		frame.setVisible(true);
		
		
		
		
		
	}
}
