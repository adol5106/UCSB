package Week10;

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
	
	private ArrayList <Polyline> poly=new ArrayList();
	private Polyline tempolyline=new Polyline();
	private ArrayList <Polygon> pgon=new ArrayList();
	private Polygon temppolygon=new Polygon();
	private static BufferedImage campus;
	private ArrayList<PointOfInterest> highlightPoint=new ArrayList();
	private ArrayList<PointOfInterest> POI=new ArrayList();
	private JTextField poinameTextField;
	private boolean POIstate=false;
	private boolean Polygonstate=false;
	private JMenuItem digitizeline,digitizepolygon,POImode,reset,save,load,loadweb;
	

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
		digitizeline = new JMenuItem("Digitize Polyline");
		digitizepolygon = new JMenuItem("Digitize Polygon");
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
		digitizeline.addActionListener(this);
		digitizepolygon.addActionListener(this);
		POImode.addActionListener(this);
		reset.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		loadweb.addActionListener(this);
		
		//Add the menu bar to be displayed
		menuBar.add(menu);
        
		//Add the menu item to be displayed
		menu.add(digitizeline);
		menu.add(digitizepolygon);
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
		if(e.getSource()==digitizeline) {
			POIstate=false;
		    Polygonstate=false;}
		if(e.getSource()==digitizepolygon) {
			POIstate=false;
		    Polygonstate=true;}
		//Add POI action
		if(e.getSource()==POImode) {
			POIstate=true;
		    Polygonstate=false;}
		//Reset action
		if(e.getSource()==reset)
		{
		    POI.clear();
		    highlightPoint.clear();
		    poly.clear();
		    pgon.clear();
		    
		    POIstate=false;
		    Polygonstate=false;
		    repaint();
		}
		//Save action
		if(e.getSource()==save)
		{
			   //Save the POI points
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
					System.out.println(ex.getMessage());}
				//Save the polyline
		        try{
					FileOutputStream fout1 = new FileOutputStream("./polylines");
					ObjectOutputStream oout1 = new ObjectOutputStream(fout1);
					Iterator<Polyline> it2 = poly.iterator();
					while (it2.hasNext()){
						Polyline aPoly = it2.next();
						oout1.writeObject(aPoly);
					}
					fout1.close();
					oout1.close();}
		            catch(Exception ex){
						System.out.println(ex.getMessage());
					}
		        //Save the polygon
		        try{
					FileOutputStream fout2 = new FileOutputStream("./polygons");
					ObjectOutputStream oout2 = new ObjectOutputStream(fout2);
					Iterator<Polygon> it3 = pgon.iterator();
					while (it3.hasNext()){
						Polygon aPogn = it3.next();
						oout2.writeObject(aPogn);
					}
					fout2.close();
					oout2.close();}
		            catch(Exception ex){
					System.out.println(ex.getMessage());
				}
		}
		//Load Action        
		if(e.getSource()==load)
		 {
			   //Load the saved POI
				try{
					FileInputStream fin = new FileInputStream("./points");
					ObjectInputStream oin = new ObjectInputStream(fin);
					PointOfInterest aPoint = (PointOfInterest) oin.readObject();
					POI.add(aPoint);
					while (aPoint != null){
						aPoint = (PointOfInterest)oin.readObject();
						POI.add(aPoint);}
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
				//Load the saved polyline
		        try{
					FileInputStream fin1 = new FileInputStream("./polylines");
					ObjectInputStream oin1 = new ObjectInputStream(fin1);
					Polyline aPoly = (Polyline) oin1.readObject();
					poly.add(aPoly);
					while (aPoly != null){
						aPoly = (Polyline)oin1.readObject();
						poly.add(aPoly);}
		        }
		        catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
		        //Load the saved polygon
		        try{
					FileInputStream fin2 = new FileInputStream("./polygons");
					ObjectInputStream oin2 = new ObjectInputStream(fin2);
					Polygon aPogn = (Polygon) oin2.readObject();
					pgon.add(aPogn);
					while (aPogn != null){
						aPogn = (Polygon)oin2.readObject();
						pgon.add(aPogn);}
					}
		        catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
		        repaint();
	}	
					
	            	
		//Load POI from the web
		if(e.getSource()==loadweb)
		{
			StringBuffer text = new StringBuffer();
		    int tempx=0; int tempy=0; String tempname ="";
			try
			{
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
				"Set POI Name",
				JOptionPane.PLAIN_MESSAGE,
				null,
				possibilities,
				"");
		return s;
	}
	//Pop up the Polyline name text box
		public String getPolyName() {
			Object[] possibilities=null;
			JFrame frame = new JFrame("Polyline Name");
			String s=(String)JOptionPane.showInputDialog(
					frame,
					"Set Polyline Name",
					"Set Polyline Name",
					JOptionPane.PLAIN_MESSAGE,
					null,
					possibilities,
					"");
			return s;
		}
	//Pop up the Polygon name text box
		public String getPolygonName() {
			Object[] possibilities=null;
			JFrame frame = new JFrame("Polygon Name");
			String s=(String)JOptionPane.showInputDialog(
				   frame,
				   "Set Polygon Name",
				   "Set Polygon Name",
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
        g2d.drawString("Mouse coordinates: "+x+", "+y, 5, 460);  //Paint the mouse coordinate
        g2d.drawString("When you try to finish the polyline digitizing, please click the right mouse button!", 200, 460);
        g2d.drawString("When you try to finish the polygon digitizing, please add a vertex next to the first point of the polygon!", 160, 480);
        double sum=0;
        for(int i=0;i<poly.size();i++)
        {sum+=poly.get(i).Perimeter();}
        String s = String.format("%.2f", sum);  
        g2d.drawString("Length : "+s,5,480);   //Paint the total length of the polyline
        tempolyline.paintPolyline(g2d);
        //Paint Polyline
         for(int i=0;i<poly.size();i++){
        	 Polyline temp=poly.get(i);
        	 temp.paintPolyline(g2d);
        	
        }
        //Paint Polygon
        temppolygon.paintPolygon(g2d);
        Iterator<Polygon> iter4=pgon.iterator();
        while(iter4.hasNext()){
        	Polygon tpg = iter4.next();
        	tpg.paintPolygon(g2d);
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
            g2d.drawString(hp.getName(), (int)hp.getPoint().getX()+15, (int)hp.getPoint().getY()+15);//drawString(hp.getName(), hp.getPoint().getX()+15, hp.getPoint().getY()+15); //Paint the name of POI
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
        	g2d.fillOval((int)hp.getPoint().getX()-15,(int)hp.getPoint().getY()-15,30,30); //Paint the highlighted point
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
	  //Check the vertex being touched or not
	  boolean touchedAtLeastOne = false;
	  for(int j=0;j<poly.size();j++)
	  {
		  Polyline bufpoly=poly.get(j);
		  if (bufpoly.touchedstate(new Point(arg0.getX(),arg0.getY())))
		  {
			touchedAtLeastOne = true;  
		  }
		  
	  }
	  for(int j=0;j<pgon.size();j++)
	  {
		  Polygon bufpogn=pgon.get(j);
		  if (bufpogn.touchedstate(new Point(arg0.getX(),arg0.getY())))
		  {
			touchedAtLeastOne = true;  
		  }
	  }
	  if (touchedAtLeastOne) {
		  return;
	  }
	  if(!POIstate && !Polygonstate){
		//Start the polyline digitizing
		if(arg0.getButton()==MouseEvent.BUTTON1){
		Point p=new Point(x,y);
		tempolyline.addPoint(p);  //add point to the Arraylist polyline
		for (int i=0; i<POI.size();i++)  //Add the clicked POI to the arraylist of highlighted point
		   {
			//If the vertex of polyline has been digitized 30 pixels near the point, give the name of POI
			PointBuffer pf=new PointBuffer(POI.get(i).getPoint(),30);
			if (pf.isInside(p))
				highlightPoint.add(new PointOfInterest(POI.get(i).getPoint(),POI.get(i).getName()));
			}
		
		}
		//End the polyline digitizing
		else if(arg0.getButton()==MouseEvent.BUTTON3){
			tempolyline.setname(getPolyName());
			poly.add(tempolyline);
			tempolyline=new Polyline();
			repaint();
		}
		}
	    //Do the polygon digitizing
		else if(!POIstate && Polygonstate)
		{   
			Point p=new Point(x,y);
			temppolygon.addPoint(p);
			Point pinit=temppolygon.getPolygon().get(0);
			PointBuffer pgf=new PointBuffer(pinit,50);
			//End the polygon digitizing
			if (temppolygon.getPolygon().size()>2 ) {
				boolean isInside = pgf.isInside(p);
			    if (isInside){
				    temppolygon.addPoint(pinit);
				    temppolygon.setname(getPolygonName());
				    pgon.add(temppolygon);
				    temppolygon=new Polygon();
			    }
			}
		repaint();
		}
		
	}
	

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
    
	//Dragging the POI point
	public void mouseDragged(MouseEvent arg0) {
		// Save the mouse coordinates in the member variables x and y
		if (POIstate)
		{
	    x = arg0.getX();
		y = arg0.getY();
		Point p=new Point(x,y);
		for (int i=0; i<POI.size(); i++)
		{
			PointBuffer pf=new PointBuffer(POI.get(i).getPoint(),30);
			if (pf.isInside(p))
				POI.set(i, new PointOfInterest(new Point(x,y),POI.get(i).getName()));
		}
		repaint();
		}
	}


	//Get the mouse moved coordinate
	public void mouseMoved(MouseEvent arg0) {	
		x =  arg0.getX();
		y =  arg0.getY();
		repaint();
	}
}
