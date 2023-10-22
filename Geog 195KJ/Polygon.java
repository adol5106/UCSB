package edu.ucsb.geog;

import java.util.ArrayList;

public class Polygon {
	
	// Define a arrayList which stores the point class objects
	private ArrayList<Point> points; 
	
	// The constructor takes 4 points and assign them to the Point array
	public Polygon(Point p1, Point p2, Point p3){
		points = new ArrayList<Point>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p1);
	}

	// This method gets the polygon ArrayList
	public ArrayList<Point> getPolygon(){
		return points;
	}
	
	public boolean addPoint(Point p){
		points.set(points.size()-1, p);
		return points.add(points.get(0));
	}
}
