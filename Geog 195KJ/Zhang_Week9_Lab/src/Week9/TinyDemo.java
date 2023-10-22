package Week9;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapRectangleImpl;
import org.openstreetmap.gui.jmapviewer.events.JMVCommandEvent;
import org.openstreetmap.gui.jmapviewer.interfaces.JMapViewerEventListener;


import au.com.bytecode.opencsv.CSVReader;

/**
*
* GEOG UCSB
*
* @author Qingyun Zhang
*
*/
public class TinyDemo extends JFrame 
	implements JMapViewerEventListener, MouseListener, MouseMotionListener{

  private static final long serialVersionUID = 1L;
  private String[] record;
  private JMapViewer mapv = null;
  private ArrayList <PointOfInterest> SchoolList;
  private double x,y;

  public TinyDemo() {
      super("A Tiny JMapViewer Demo to Get You Started!");
      SchoolList = new ArrayList<PointOfInterest>();
      
      setSize(700, 700);
      mapv = new JMapViewer();
      mapv.addJMVListener(this);
      add(mapv);
      MapMarkerDot ucsb = new MapMarkerDot("UCSB", new Coordinate(34.41254, -119.84813));
      mapv.addMapMarker(ucsb);
      mapv.addMouseListener(this);
      mapv.addMouseMotionListener(this);
      
      mapv.addMapMarker(new MapMarkerDot(43.604, 1.444));
      mapv.addMapMarker(new MapMarkerCircle(53.343, -6.267, 0.666));
      mapv.addMapRectangle(new MapRectangleImpl(new Coordinate(53.343, -6.267), new Coordinate(43.604, 1.444)));
      
      Double tempx; 
      Double tempy; 
      String tempname; 
      String temptype;}  
      
/*      try{
           SVReader reader = new CSVReader(new FileReader("L:\\Geog 195KJ\\Zhang_Week9_Lab\\src\\schools.csv"), '\t');
           while((record = reader.readNext()) != null)
           {   
        	   String[] poidata=record[0].split(",");
               PointOfInterest tempPOI = new PointOfInterest(new Point(Double.parseDouble(poidata[1]),Double.parseDouble(poidata[2])),poidata[0],poidata[3]);
     	       //SchoolList.add(tempPOI);
           }
               System.out.println(SchoolList.get(3).getPoint().getX());}
               catch(Exception e){
       			System.out.println(e.getMessage());
       		}
          for(int i=0;i<SchoolList.size();i++)
          {
               MapMarkerDot schools = new MapMarkerDot(SchoolList.get(i).getName(), new Coordinate(SchoolList.get(i).getPoint().getX(), SchoolList.get(i).getPoint().getY()));
               mapv.addMapMarker(schools);}
           }*/
           

public static void main(String[] args) {
      new TinyDemo().setVisible(true);
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

@Override
public void mouseMoved(MouseEvent e) {
	x =  e.getX();
	y =  e.getY();
	System.out.println(x+","+y);
}

@Override
public void mouseClicked(MouseEvent e) {
	 if (e.getButton() == MouseEvent.BUTTON1) {
  		  MapMarkerDot tmp = new MapMarkerDot("POI", mapv.getPosition(e.getX(), e.getY()));	 
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