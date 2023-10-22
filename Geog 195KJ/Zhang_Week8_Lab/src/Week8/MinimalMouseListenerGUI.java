package Week8;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MinimalMouseListenerGUI extends JPanel implements MouseListener, MouseMotionListener, ActionListener, Serializable {

	// These variables will store the mouse coordinates
	private int x=0,y=0;
	private Polyline poly=new Polyline();
	private static BufferedImage campus;
	
	private ArrayList<PointOfInterest> highlightPoint=new ArrayList();
	private ArrayList<PointOfInterest> POI=new ArrayList();
	private ArrayList<Point> point=new ArrayList();
	private JTextField poinameTextField;
	private boolean POIstate=false;
	private JMenuItem digitize,POImode,reset,save,load,loadweb;   
	
	
	
	
	public MinimalMouseListenerGUI() throws IOException {
		// Feel free to ignore, this just calls the constructor of JPanel to enable  DoubleBuffering to avoid flickering.
		super(true); 
		// Set the (preferred) size of the panel
		setPreferredSize(new Dimension(699,500));
		// Load the image (this time we do not handle the exception but throw it somewhere else ;-))
		campus = ImageIO.read(new File("L:\\Geog 195KJ\\Zhang_Week7_Practice\\src\\Week7\\campus.png"));
		//Windows users need something like this:
		// "C:\\Users\\You\\GEOG288KJ\\src\\...\\campus.png"
		
		// You always need a frame to place other components such as panels or menus
		
		JPanel rootpanel = new JPanel();
		JPanel controls = new JPanel();
		JMenuBar menuBar = new JMenuBar();;
		JMenu menu = new JMenu("Main");;
		digitize = new JMenuItem("Digitize");
		POImode = new JMenuItem("POI mode");
		reset = new JMenuItem("Reset");
		save = new JMenuItem("Save");
		load = new JMenuItem("Load");
		loadweb = new JMenuItem("Load from Web");
		JFrame frame = new JFrame("A tiny POI app");
		rootpanel.setLayout(new BoxLayout(rootpanel, BoxLayout.Y_AXIS));
		
		// Exit on close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
  
		// I need more panels here to ensure that I do not scale the button and text field as well.
		frame.add(rootpanel); //Add the rootpanel to frame
		rootpanel.add(controls); // Place the controls panel at the top of the rootpanel
		rootpanel.add(this);  // Place the gui (drawing) panel at the bottom of the rootpanel
		
		//Add the button and the text field.
		digitize.addActionListener(this);
		POImode.addActionListener(this);
		reset.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		loadweb.addActionListener(this);
		
		//Add the menu bar to be displayed
		menuBar.add(menu);
        
		//Add the menu item to be displayed
		menu.add(digitize);
		menu.add(POImode);
		menu.add(reset);
		menu.add(save);
		menu.add(load);
		menu.add(loadweb);
		frame.setJMenuBar(menuBar);
		
		
		
		
        /*
		 * Register the gui to listen to mouse events
		 */
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		// Add an instance of the MinimalDrawingGUI to the frame.
		frame.add(this);
		
		// Add the text field and the button to the JPanel (our GUI).
		
		// Set the size, arrange components, and display the frame.
		frame.pack();
		frame.setVisible(true);

	}
	
	//Action performer of three different buttons
	public void actionPerformed(ActionEvent e) {  //Hit the button, switch to POI mode
		//Digitizing action
		if(e.getSource()==digitize)
			POIstate=false;
		//Add POI action
		if(e.getSource()==POImode)
			POIstate=true;
		//Reset action
		if(e.getSource()==reset)
		{
			point.clear();
		    POI.clear();
		    highlightPoint.clear();
		    poly.getPolyline().clear();
		    poly.getPolylineX().clear();
		    poly.getPolylineY().clear();
		    repaint();
		}
		//Save action
		if(e.getSource()==save)
				try{
					
					FileOutputStream fout = new FileOutputStream("./points");
					ObjectOutputStream oout = new ObjectOutputStream(fout);
					Iterator<PointOfInterest> it = POI.iterator();
					while (it.hasNext()){
						PointOfInterest aPOI = it.next();
						oout.writeObject(aPOI);
					}
					fout.close();
					oout.close();
					
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
		//Load Action        
		if(e.getSource()==load)
				try{
					
					FileInputStream fin = new FileInputStream("./points");
					ObjectInputStream oin = new ObjectInputStream(fin);
					PointOfInterest aPoint = (PointOfInterest) oin.readObject();
					POI.add(aPoint);
					while (aPoint != null){
						aPoint = (PointOfInterest)oin.readObject();
						POI.add(aPoint);}
					repaint();
					}catch(Exception ex)
					{
						System.out.println(ex.getMessage());
					}
		//Load POI from the web
		if(e.getSource()==loadweb)
		{
			StringBuffer text = new StringBuffer();
		     int tempx=0; int tempy=0; String tempname ="";
			try{
				URL poiurl = new URL("http://geog.ucsb.edu/~jano/POI/CampusPOI.txt");
				InputStreamReader inStream = new InputStreamReader(poiurl.openStream());
				BufferedReader bufRead = new BufferedReader(inStream);
			    int aChar = bufRead.read();
			    text.append((char)aChar);
			    while (aChar !=-1){
			    	aChar = bufRead.read();
			    	text.append((char)aChar);
			    	}
			     bufRead.close();
			     inStream.close();
			     String[] poidata=text.toString().split("\t");
			     for(int i=0;i<poidata.length-2;i+=3){
			    	
			    		 tempx=Integer.valueOf(poidata[i]);
			    	
			    		 tempy=Integer.valueOf(poidata[i+1]);
			    	
			    		 tempname=poidata[i+2];
			    	 POI.add(new PointOfInterest(new Point(tempx,tempy),tempname));
			     }
			    repaint();
	       }catch(Exception ex){
			System.out.println(ex.getMessage());
		}}
		 
	}
	//Pop up the POI name text box
	public String getName() {
		Object[] possibilities=null;
		JFrame frame = new JFrame("POI Name");
		String s=(String)JOptionPane.showInputDialog(
				frame,
				"Set POI Name",
				"Customized Dialog",
				JOptionPane.PLAIN_MESSAGE,
				null,
				possibilities,
				"");
		return s;
	}
	
	//Initialize the paint component
	public void paintComponent(Graphics g) {
        super.paintComponent(g);    
        g.drawImage(campus, 0, 0, this);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON); 


        g2d.setColor(Color.black);
        //Draw text showing the current mouse position.
        
        g2d.drawString("Mouse coordinates: "+x+", "+y,15, 460);  //Paint the mouse coordinate
        String s = String.format("%.2f", poly.Perimeter());  
        g2d.drawString("Length : "+s,15,480);   //Paint the total length of the polyline
        //Paint Polyline
        Iterator<Point> iter=poly.getPolyline().iterator();
        while(iter.hasNext()){
        	Point tp = iter.next();
        	int r=0;
        	int gl=0;
        	int b=0;
        	Color color=new Color(r,gl,b);  //Draw the black polyline
        	g2d.setColor(color);
            g2d.drawPolyline(poly.getPolylineArrayX(), poly.getPolylineArrayY(), poly.getLength());

            g2d.setColor(Color.red); //set point color to red
            g2d.fillOval(tp.getX()-5,tp.getY()-5,10,10); //draw the vertexs
            }
        //Paint the name of POI
        Iterator<PointOfInterest> iter2=highlightPoint.iterator();
        while(iter2.hasNext()){
        	PointOfInterest hp = iter2.next(); 
        	int r=0;  //set blue color
        	int gl=0;
        	int b=255;
        	Color color=new Color(r,gl,b);
        	g2d.setColor(color);
            g2d.drawString(hp.getName(), hp.getPoint().getX()+15, hp.getPoint().getY()+15); //Paint the name of POI
          }
        //Paint the POI
        Iterator<PointOfInterest> iter3=POI.iterator();
        while(iter3.hasNext()){
        	PointOfInterest hp = iter3.next(); 
        	int r=0;  //set blue color
        	int gl=0;
        	int b=255;
        	Color color=new Color(r,gl,b);
        	g2d.setColor(color);
        	g2d.fillOval(hp.getPoint().getX()-15,hp.getPoint().getY()-15,30,30); //Paint the highlighted point
        	
          }
	}

	public static void main(String[] args) throws IOException{
		
		MinimalMouseListenerGUI gui = new MinimalMouseListenerGUI();
		
		}
        
	//Event of adding the POI 
	public void mouseClicked(MouseEvent arg0) {
		
		
		x = arg0.getX();  
		y = arg0.getY();
		if(x>0 && x<699 && y>50 && y<500)  //Make sure add POI and digitizing on the map
		if (POIstate)
		{
		   Point pt=new Point(x,y);
		   POI.add(new PointOfInterest(pt,getName())); //Add the name and POI to the arraylist of POI
		}
        repaint();}
		
	

	
	public void mouseEntered(MouseEvent arg0) {
		
		
	}

	
	public void mouseExited(MouseEvent arg0) {
		
		
	}

	//Digitizing the polyline path
	public void mousePressed(MouseEvent arg0) {
		if(!POIstate){
		Point p=new Point(x,y);
		   poly.addPoint(p);  //add point to the Arraylist polyline
		   point.add(p);  //add point to the Arraylist point
		   for (int i=0; i<POI.size();i++)  //Add the clicked POI to the arraylist of highlighted point
		   {
			//If the vertex of polyline has been digitized 30 pixels near the point, give the name of POI
			PointBuffer pf=new PointBuffer(POI.get(i).getPoint(),30);
			if (pf.isInside(p))
				highlightPoint.add(new PointOfInterest(POI.get(i).getPoint(),POI.get(i).getName()));
			    
		}
	    }
		repaint();
	}
	

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
    
	//Dragging the POI point
	public void mouseDragged(MouseEvent arg0) {
		// Save the mouse coordinates in the member variables x and y
		if (POIstate){
	    x = arg0.getX();
		y = arg0.getY();
		
		Point p=new Point(x,y);
		for (int i=0; i<POI.size(); i++)
		{
			PointBuffer pf=new PointBuffer(POI.get(i).getPoint(),30);
			if (pf.isInside(p))
				POI.set(i, new PointOfInterest(new Point(x,y),POI.get(i).getName()));
		}
		
		repaint();}
	}


	//Get the mouse moved coordinate
	public void mouseMoved(MouseEvent arg0) {	
		x =  arg0.getX();
		y =  arg0.getY();
		
		repaint();
	}
}
