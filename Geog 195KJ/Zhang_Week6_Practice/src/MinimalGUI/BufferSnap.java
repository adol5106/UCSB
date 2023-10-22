package MinimalGUI;

import java.awt.Dimension;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


import java.awt.RenderingHints;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class BufferSnap extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 7526472295622776147L;
	
	private  Polygon pg ;    //member variable polygon
	private  PointBuffer pf;   //member variable pointbuffer
	public static  BufferSnap gui;  //member variable 
	
	public BufferSnap(){
	super(true); 
	setPreferredSize(new Dimension(500,500));  //Set the frame
	
	Polygon pg = new Polygon();   //Create a new polygon
    pg.addPoint(new Point(100, 100));   //Add five points to the polygon
    pg.addPoint(new Point(100, 400));
    pg.addPoint(new Point(400, 400));
    pg.addPoint(new Point(400, 100));
    pg.addPoint(new Point(125, 100));
    setPg(pg);
	PointBuffer newPf=new PointBuffer(getPg().getPolygon().get(0),30); //Initialize the point buffer
	setPf(newPf);  //Set the point buffer

}
	
	public PointBuffer getPf() {  //Get the point buffer
		return pf;
	}

	public void setPf(PointBuffer pf) { //Initialize the point buffer
		this.pf = pf;
	}

	public Polygon getPg() { //Get Polygon
		return pg;
	}

	public void setPg(Polygon pg) {  //Initialize the polygon
		this.pg = pg;
	}
	//If the last point of the polygon is inside of the point buffer of the first point, we will add the last point which is same as the first point for snapping.
	public void actionPerformed(ActionEvent e) {  

		if (getPf().isInside(getPg().getPolygon().get(getPg().getPolygon().size()-1)))
			{pg.addPoint(new Point(getPg().getPolygonX().get(0),getPg().getPolygonY().get(0)));
             gui.repaint();
		     }
	}

	public void paintComponent(Graphics g) {
        super.paintComponent(g);    // Paints all other stuff, e..g., background.
        
        // Cast to a Graphics2D object to support affine transformations
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.red);    //Set red color
        g2d.drawPolyline(pg.getPolygonArrayX(), pg.getPolygonArrayY(), pg.getLength());  //Draw the polygon

	
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		gui = new BufferSnap();  //Create a new GUI
		
		

		// frame
		JFrame frame = new JFrame("The Buffer Snapping!");
		
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
		
		
		// Create button
		// Try to understand why I do not have to put the gui. in front of the scaleButton.
		JButton snapButton = new JButton("Snapping!");
		
		// Register the scale button to listen for clicks. Each click will call your actionPerformed method
		snapButton.addActionListener(gui);
		
		// I need more panels here to ensure that I do not scale the button and text field as well.
		frame.add(rootpanel); //Add the rootpanel to frame
		rootpanel.add(controls); // Place the controls panel at the top of the rootpanel
		rootpanel.add(gui);  // Place the gui (drawing) panel at the bottom of the rootpanel
		
		//Add the button and the text field.
		
		controls.add(snapButton);
		
		
		// Set the size, arrange components, and display the frame.
		frame.pack();
		frame.setVisible(true);
		}

}      
      
