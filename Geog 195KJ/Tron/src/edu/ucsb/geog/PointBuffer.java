package edu.ucsb.geog;

public class PointBuffer{
	
	private Point center;
	private double radius;
	//private double area;
		
	public PointBuffer(Point p, double r){
		center = p;
		setRadius(r);
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public boolean isInside(Point newPoint){
		if (center.distance(center, newPoint) < getRadius() ){
			return true;
		}else{
			return false;
		}
	}
	
	public Point getCentre(){
		return center;
	}

	
		
}
