package MinimalGUI;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuGUI extends JPanel implements ActionListener {

	//member variables
	private double scaleFactor=1, rotationFactor=0, minX=0, minY=0; // Variables required to display the objects
	private JMenuItem zoomMenuItem,rotateMenuItem,resetMenuItem; // Menu items
	
	//constructor
	public MenuGUI() {
		super(true);	//calls constructor of JPanel to enable DoubleBuffering to avoid flickering
		createGUI(); // Just to make the code more readable
	}
	

	private void createGUI() {
		
		// Create menu bar, menu, and menu items
		JMenuBar menuBar = new JMenuBar();;
		JMenu menu = new JMenu("Main");;
		zoomMenuItem = new JMenuItem("Zoom");
		rotateMenuItem = new JMenuItem("Rotate");
		resetMenuItem = new JMenuItem("Reset");
		
		// Add listener to the menu items; each click will trigger the actionPerformed method
		zoomMenuItem.addActionListener(this);
		rotateMenuItem.addActionListener(this);
		resetMenuItem.addActionListener(this);
		
		menuBar.add(menu);

		menu.add(zoomMenuItem);
		menu.add(rotateMenuItem);
		menu.add(resetMenuItem);
	
		// frame
		JFrame frame = new JFrame("Scale a Triangle");
		
		// Exit on close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setJMenuBar(menuBar);
		frame.add(this);
		
		// Set the size, arrange components, and display the frame.
		frame.setPreferredSize(new Dimension(500,500));	
		frame.pack();
		frame.setVisible(true);
	}


	/*
	 *  This is the new and interesting part. Our class implements the ActionListener interface 
	 *  and, hence, has to provide an implementation for public void actionPerformed(ActionEvent arg0).
	 *  Java will ensure that this method gets called if the button (see below) is clicked.
	 */
	public void actionPerformed(ActionEvent event) {
		
		// which menu item was pressed?
		if(event.getSource()== zoomMenuItem)
			scaleFactor+=0.1;
		if(event.getSource()== rotateMenuItem)
			rotationFactor+=0.1;
		if(event.getSource()== resetMenuItem){
			rotationFactor=0;
			scaleFactor=1;
		}
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
        g2d.rotate(rotationFactor);
        g2d.translate(minX,minY); // this will work for the scale but not for rotation.
        
		// This is not your polygon class but the one from Java AWT
        Polygon poly = new Polygon();
        poly.addPoint(140, 100);
        poly.addPoint(300, 300);
        poly.addPoint(100, 200);
        
        //Construct the bounding box; again use YOUR classes as models 
        // and the AWT classes as graphical representations
        Rectangle2D bb = poly.getBounds2D();
        minX = -bb.getMinX()+20;
        minY = -bb.getMinY()+20;
        g2d.drawPolygon(poly);
        g2d.setColor(Color.red);
        g2d.draw(bb);
	}
	
	public static void main(String[] args) {
		
		// Construct one GUI
		MenuGUI gui = new MenuGUI();	
		
	}
}
