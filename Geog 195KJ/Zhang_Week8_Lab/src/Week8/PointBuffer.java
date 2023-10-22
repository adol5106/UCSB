package Week8;

import java.util.ArrayList;

public class PointBuffer {
	
	private Point center;
	private int radius;

	public PointBuffer(Point p, int r){  //The constructor passes the central point and radius in
		setCenter(p);
		setRadius(r);	
    }


   //Get the radius of the buffer
	public int getRadius() { 
		return radius;
	}
	
   //Set the radius of the buffer
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	//Set the center of the buffer
	private void setCenter(Point p){
		this.center=p;
	}
	//Get the center of the buffer
	public Point getCentre()
	{
		return center;
	}
	
	//Get the area of the buffer
    public double computeArea()
    {
        return Math.PI*Math.pow(getRadius(), 2);
    }
	
    //Check whether or not a point is in the buffer
	public boolean isInside(Point newPoint){
		if (center.distance(center, newPoint) < getRadius() ){
			return true;}
		else {
			return false;
		}
	}
	//Get the dimensionality of the buffer
	public int dimensionality() {
		return 2;
	}

    //Get the perimeter of the buffer
	public double Perimeter() {
        return Math.PI*2*getRadius();
	}

	




   
		
}
