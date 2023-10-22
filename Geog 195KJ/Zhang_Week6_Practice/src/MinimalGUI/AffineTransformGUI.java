package MinimalGUI;


import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AffineTransformGUI extends JPanel implements ActionListener {
	
	private AffineTransform at;
	
	public AffineTransformGUI() {
		super(true);	
		at = new AffineTransform();
		setPreferredSize(new Dimension(500,500));		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		at.translate(5,5);
		//at.rotate(Math.PI/2);
		at.scale(1.1,1.1);
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
		// This is not your polygon class but the one from Java AWT (only use it for rendering)
        Polygon poly = new Polygon();
        poly.addPoint(100, 100);
        poly.addPoint(150, 150);
        poly.addPoint(200, 150);
        g2d.draw(at.createTransformedShape(poly));

        Polygon poly2 = new Polygon();
        poly2.addPoint(100, 100);
        poly2.addPoint(150, 150);
        poly2.addPoint(200, 150);
		g.drawPolygon(poly2);
	}
	
	public static void main(String[] args) {
		
		AffineTransformGUI gui = new AffineTransformGUI();
		JFrame frame = new JFrame("AffineTransform");
		JPanel rootpanel = new JPanel();
		JPanel controls = new JPanel();
		rootpanel.setLayout(new BoxLayout(rootpanel, BoxLayout.Y_AXIS));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JButton tButton = new JButton("Do AffineTransform!");
		
		tButton.addActionListener(gui);
		
		frame.add(rootpanel); 
		rootpanel.add(controls);
		rootpanel.add(gui); 
		controls.add(tButton);
		
		frame.pack();
		frame.setVisible(true);
		
		
	}
}
