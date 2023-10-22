package edu.ucsb.geog;

import java.util.ArrayList;

public class Polyline {
	// Define a arrayList which stores the point class objects
	private ArrayList<Point> points; 
		
	// The constructor creates a new ArrayList of points
	public Polyline(Point p1, Point p2){
		points = new ArrayList<Point>();		
		points.add(p1);
		points.add(p2);
	}
	
	public Polyline(){
		points = new ArrayList<Point>();
	}

	// This method gets the polyline ArrayList
	public ArrayList<Point> getPolyline(){
		return points;
	}
	
	public void addPoint(Point p){
		points.add(p);
	}
	
	public void removePoint(int i){	
		points.remove(i);
	}
	
	
}
