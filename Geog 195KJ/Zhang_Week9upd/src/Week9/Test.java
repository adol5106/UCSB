package Week9;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapRectangleImpl;
import org.openstreetmap.gui.jmapviewer.events.JMVCommandEvent;
import org.openstreetmap.gui.jmapviewer.interfaces.JMapViewerEventListener;




import au.com.bytecode.opencsv.CSVReader;

public class Test extends JFrame implements JMapViewerEventListener, MouseListener, MouseMotionListener,ActionListener{

	  private static final long serialVersionUID = 1L;
	  private String[] record;
	  private JMapViewer mapv = null;
	  private ArrayList <PointOfInterest> SchoolList = new ArrayList();
	  private double x,y;
	  
	  private ArrayList <PointOfInterest> highschoolPoint = new ArrayList();
	  private JMenuItem Highschool;

	  public Test() {
	      super();
	      //Add the menu to the panel
		  JMenuBar menuBar = new JMenuBar();;
		  JMenu menu = new JMenu("Main");;
		  Highschool = new JMenuItem("High School");
	
		  Highschool.addActionListener(this);
		  menuBar.add(menu);
		  menu.add(Highschool);
		  this.setJMenuBar(menuBar);

		  //Set the frame size
	      setSize(700, 700);
	      
	      //Set the mapviewer
	      mapv = new JMapViewer();
	      mapv.addJMVListener(this);
	      add(mapv);
	      MapMarkerDot ucsb = new MapMarkerDot("UCSB", new Coordinate(34.41254, -119.84813));
	      mapv.addMapMarker(ucsb);
	      mapv.addMouseListener(this);
	      mapv.addMouseMotionListener(this);

	      //Add the sample shape and marker to the mapviewer
	      mapv.addMapMarker(new MapMarkerDot(43.604, 1.444));
	      mapv.addMapMarker(new MapMarkerCircle(53.343, -6.267, 0.666));
	      mapv.addMapRectangle(new MapRectangleImpl(new Coordinate(53.343, -6.267), new Coordinate(43.604, 1.444)));

	      Double tempx; 
	      Double tempy; 
	      String tempname; 
	      String temptype;  
	      
	      try{
	    	  //Read the csv file
	    	   CSVReader reader = new CSVReader(new FileReader("L:\\Geog 195KJ\\Zhang_Week9_Lab\\src\\schools.csv"), '\t');
	           while((record = reader.readNext()) != null)
	           {   
	        	   String[] poidata=record[0].split(",");
	               PointOfInterest tempPOI = new PointOfInterest(new Point(Double.parseDouble(poidata[1]),Double.parseDouble(poidata[2])),poidata[0],poidata[3]);
	     	       this.SchoolList.add(tempPOI);
	           }}
	               
	               catch(Exception e){
	       			System.out.println(e.getMessage());
	       		}
	          //Add all school's dots on the MapViewer
	          for(int i=0;i<SchoolList.size();i++)
	           {
	               MapMarkerDot schools = new MapMarkerDot(new Coordinate(SchoolList.get(i).getPoint().getX(), SchoolList.get(i).getPoint().getY()));
	               mapv.addMapMarker(schools);}
	           }

	public static void main(String[] args) 
	{
		new Test().setVisible(true);
	}
	
	//The action performer for showing all the high school dots
	public void actionPerformed(ActionEvent e) { 
		if(e.getSource()==Highschool)
		{   
		   mapv.removeAllMapMarkers();
		   for(int i=0;i<this.SchoolList.size();i++)
            {
			   //Add only high school dots
				if(this.SchoolList.get(i).getType().equals("High School"))
				{
					MapMarkerDot hschools=new MapMarkerDot(this.SchoolList.get(i).getName(),new Coordinate(this.SchoolList.get(i).getPoint().getX(), this.SchoolList.get(i).getPoint().getY()));
					mapv.addMapMarker(hschools);  

                }	
             }
		    }
			  
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
	
	private void updateZoomParameters() {
	  }

	@Override
	public void processCommand(JMVCommandEvent command) {
	      if (command.getCommand().equals(JMVCommandEvent.COMMAND.ZOOM) ||
	              command.getCommand().equals(JMVCommandEvent.COMMAND.MOVE)) {
	      }
	  }

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	//Show the name of the schools' name when mouse moved
	public void mouseMoved(MouseEvent e) {
		x =  mapv.getPosition(e.getX(),e.getY()).getLat();
		y =  mapv.getPosition(e.getX(),e.getY()).getLon();
		Point pt=new Point(x,y);
		System.out.println(x+","+y);
		
		for(int i=0; i<SchoolList.size(); i++){
			//If the vertex of polyline has been digitized 30 pixels near the point, give the name of POI
			
			PointBuffer pf=new PointBuffer(SchoolList.get(i).getPoint(),.005);
			if (pf.isInside(pt)){
				mapv.removeMapMarker(mapv.getMapMarkerList().get(i));
				MapMarkerDot schools = new MapMarkerDot(SchoolList.get(i).getName(), new Coordinate(SchoolList.get(i).getPoint().getX(), SchoolList.get(i).getPoint().getY()));
                mapv.addMapMarker(schools);}
		
		}
	}

	//Add poi point to on the map
	public void mouseClicked(MouseEvent e) {
		 if (e.getButton() == MouseEvent.BUTTON1) {
	  		  MapMarkerDot tmp = new MapMarkerDot(getName(), mapv.getPosition(e.getX(), e.getY()));	 
	  		  mapv.addMapMarker(tmp);
	        }
		}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
   

}
