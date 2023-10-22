package edu.ucsb.geog.w3;

import java.util.ArrayList;

public class WildfireModel {

	// Arraylists of points
	private ArrayList<Point> polypoints;
	private ArrayList<Point> building;
	
	public WildfireModel(int numberOfBuildings) {
		polypoints = new ArrayList<Point>();
		building = new ArrayList<Point>();
		
		polypoints.add(new Point(100,200));
		polypoints.add(new Point(180,170));
		polypoints.add(new Point(220,110));
		polypoints.add(new Point(290,100));
		polypoints.add(new Point(330,140));
		polypoints.add(new Point(350,190));
		polypoints.add(new Point(415,220));
		polypoints.add(new Point(325,210));
		polypoints.add(new Point(190,220));
		polypoints.add(new Point(100,200));
		
		// Create some random coordinates for buildings
		for(int i=0; i<numberOfBuildings; i++){
			building.add(new Point((int)(Math.random()*450)+10,(int)(Math.random()*450)+10));
		}
		
    }
	
	// Returns the list of points forming the wildfire polygon
	public ArrayList<Point> getWilfFirePolygon(){
		return polypoints;
	}
	
	// Returns the list of buildings
	public ArrayList<Point> getBuildings(){
		return building;
	}
	
	
}
