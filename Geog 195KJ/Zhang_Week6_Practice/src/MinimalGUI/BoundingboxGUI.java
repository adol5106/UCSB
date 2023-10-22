package MinimalGUI;

import java.awt.Dimension;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BoundingboxGUI extends JPanel implements ActionListener {

	private Polygon triangle;      //Define all shapes and geometries
	private Polygon diamond;
	private PointBuffer circle;
	private Point pt;
	private Polyline pl;
	private ArrayList<Geometry> geometries;
		
	public BoundingboxGUI(){
	super(true); 
	setPreferredSize(new Dimension(1000,1000));
	Polygon triangle = new Polygon();   //Create a new triangle
    triangle.addPoint(new Point(100, 100));   //Add four points to the triangle
    triangle.addPoint(new Point(200, 400));
    triangle.addPoint(new Point(400, 300));
    triangle.addPoint(new Point(100, 100));
    this.triangle=triangle;
    Polygon diamond = new Polygon();   //Create a new diamond
    diamond.addPoint(new Point(650,100));  //Add five points to the diamond
    diamond.addPoint(new Point(550,250));
    diamond.addPoint(new Point(650,400));
    diamond.addPoint(new Point(750,250));
    diamond.addPoint(new Point(650,100));
    this.diamond=diamond;
    Point pt=new Point(200,600);   //Create a new point
    Polyline pl=new Polyline();   //Create a new polyline
    pl.addPoint(new Point(400,420));  //Add six points to the polyline
    pl.addPoint(new Point(500,450));
    pl.addPoint(new Point(500,500));
    pl.addPoint(new Point(700,450));
    pl.addPoint(new Point(800,550));
    pl.addPoint(new Point(950,800));
    pl.addPoint(new Point(530,560));
    this.pl=pl;
    PointBuffer circle = new PointBuffer(new Point(300,650),200);   //Create a circle
    this.circle=circle;
    
	geometries=new ArrayList<Geometry>();  //Add those shapes into geometry
	geometries.add(triangle);
	geometries.add(diamond);
	geometries.add(circle);
	geometries.add(pl);
	geometries.add(pt);
    }
	
	public Polyline getPl() {    //Get polyline
		return pl;
	}

	public void setPl(Polyline pl) {   //Set Polyline
		this.pl = pl;
	}
	public Point getPt() {  //Get point
		return pt;
	}

	public void setPt(Point pt) {  //Set point
		this.pt = pt;
	}
	//When clicking the bottom, add boundingboxes of all shapes into geometries
	public void actionPerformed(ActionEvent e) {    
             
		     for (int i=0;i<5;i++)
             {   geometries.get(i).setBoundingbox();
            	 geometries.add(getBoundingBox(geometries.get(i).getLowerleft(),geometries.get(i).getUpperright()));
             }
            	 
		     repaint();
            }
	
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);    // Paints all other stuff, e..g., background.
        
        // Cast to a Graphics2D object to support affine transformations
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.red);
 
        //for(int i=0;i<geometries.size();i++){
        Iterator<Geometry> iter=geometries.iterator();
        while(iter.hasNext()){
        	Geometry geom = iter.next();
        	//Draw all shapes on the screen
        	if (geom instanceof Polygon)
                g2d.drawPolygon(geom.getPolygonArrayX(), geom.getPolygonArrayY(), geom.getLength());
        	else if (geom instanceof PointBuffer)
        		g2d.drawOval((int)geom.getCentre().getX(), (int)geom.getCentre().getY(), geom.getRadius(), geom.getRadius());
        	else if (geom instanceof Polyline)
                g2d.drawPolyline(geom.getPolylineArrayX(), geom.getPolylineArrayY(), geom.getLength());
        	else if (geom instanceof Point)
        		g2d.fillOval((int)((Point) geom).getX(), (int)((Point) geom).getY(), 5, 5);
        }
	}
	
	public static void main(String[] args) {

		BoundingboxGUI gui = new BoundingboxGUI();

		
		// frame
		JFrame frame = new JFrame("The BoundingBox!");
		
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
		JButton snapButton = new JButton("Do Bounding Box!");
		
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
	//Make boundingbox polygon by using the lowerleft point and upperright of the bounding box 
   public Polygon getBoundingBox(Point ll, Point ur)    
   {    Polygon boundingBoxPoly = new Polygon();
	    boundingBoxPoly.addPoint(ll);
	    boundingBoxPoly.addPoint(new Point(ur.getX(),ll.getY()));
	    boundingBoxPoly.addPoint(ur);
	    boundingBoxPoly.addPoint(new Point(ll.getX(),ur.getY()));
	    boundingBoxPoly.addPoint(ll);
	    return boundingBoxPoly;
   }
}
