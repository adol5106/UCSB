package MinimalGUI;

import java.awt.BorderLayout;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScaleGUI extends JPanel implements ActionListener {

	//member variables
	private JTextField scaleTextField; // This has to be a member variable to give me access to the stored text
	private double scaleFactor=1; // I will store the scale factor here
	
	//constructor
	public ScaleGUI() {
		super(true);	//calls constructor of JPanel to enable DoubleBuffering to avoid flickering
		
		setPreferredSize(new Dimension(500,500));		
	}
	

	/*
	 *  This is the new and interesting part. Our class implements the ActionListener interface 
	 *  and, hence, has to provide an implementation for public void actionPerformed(ActionEvent arg0).
	 *  Java will ensure that this method gets called if the button (see below) is clicked.
	 */
	public void actionPerformed(ActionEvent arg0) {
		/*
		 * Get the text from the text field, try to decode the text into an integer, set
		 * this integer as the new radius for the buffer, and, finally, repaint the GUI.
		 * You will get a NumberFormatException if the text field does not contain a number, we 
		 * will discuss exceptions next time.
		 */
		scaleFactor =(Double.valueOf(scaleTextField.getText()));
		repaint();
	}
	
	// Java calls this method
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// cast to a Graphics2D object to support affine transformations
		Graphics2D g2d = (Graphics2D) g;
		
		//Turn on Antialiasing (just to hide the ugly stair pixels)
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        /*
         *  Scale the panel. Keep in mind, you cannot use this if you just 
         *  want to scale a single object. Please check the AffineTransfoprmation
         *  for such cases. This tutorial is a good starting point:
         *  http://java.sun.com/developer/technicalArticles/GUI/java2d/java2dpart1.html
         */
        g2d.scale(scaleFactor,scaleFactor);

		// This is not your polygon class but the one from Java AWT
        Polygon poly = new Polygon();
        poly.addPoint(100, 100);
        poly.addPoint(300, 300);
        poly.addPoint(100, 200);
        g2d.drawPolygon(poly);
	}
	
	public static void main(String[] args) {
		
		/*
		 * This is difficult to understand for new programmers. 
		 * I am creating an instance of the RotationGUI class within the class 
		 * because I will just create a single instance.
		 */
		ScaleGUI gui = new ScaleGUI();
		
		// frame
		JFrame frame = new JFrame("Scale a Triangle");
		
		// A root panel to store the controls (button and textfield) and the drawing panel
		JPanel rootpanel = new JPanel();
		JPanel controls = new JPanel();
		
		// You do not need this, I just set a Layout manager to have a top-down layout (instead of left-right)
		rootpanel.setLayout(new BoxLayout(rootpanel, BoxLayout.Y_AXIS));
		
		// Exit on close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * In contrast to the button I will need the text field later to access the scale value
		 */
		gui.scaleTextField = new JTextField("Scale factor");
		
		// Create button
		// Try to understand why I do not have to put the gui. in front of the scaleButton.
		JButton scaleButton = new JButton("Scale!");
		
		// Register the scale button to listen for clicks. Each click will call your actionPerformed method
		scaleButton.addActionListener(gui);
		
		// I need more panels here to ensure that I do not scale the button and text field as well.
		frame.add(rootpanel); //Add the rootpanel to frame
		rootpanel.add(controls); // Place the controls panel at the top of the rootpanel
		rootpanel.add(gui);  // Place the gui (drawing) panel at the bottom of the rootpanel
		
		//Add the button and the text field.
		controls.add(gui.scaleTextField);
		controls.add(scaleButton);
		
		// Set the size, arrange components, and display the frame.
		frame.pack();
		frame.setVisible(true);
		
		
	}
}
