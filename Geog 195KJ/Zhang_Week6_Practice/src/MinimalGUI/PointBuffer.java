package MinimalGUI;

import java.util.ArrayList;

public class PointBuffer implements Geometry{
	
	private Point center;
	private int radius;
	private Point lowerleft;
	private Point upperright;
	
	
	
		
	public PointBuffer(Point p, int r){  //The constructor passes the central point and radius in
		setCenter(p);
		setRadius(r);
		
		
    }
	//Set lower left point
	public void setLowerleft(Point lowerleft)
	{
		this.lowerleft = lowerleft;    
	}
    //set upper right point
	public void setUpperright(Point upperright)
	{
		this.upperright=upperright;
	}
    //get lower left point
	public Point getLowerleft()
	{
		return lowerleft;
	}
    //get upper right point
	public Point getUpperright()
	{
		return upperright;
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

	
	public void setBoundingbox() {
		setLowerleft(new Point(getCentre().getX(),getCentre().getY()));
		
		setUpperright(new Point(getCentre().getX()+getRadius(),getCentre().getY()+getRadius()));
		
		
	}

	
	
	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] getPolygonArrayX() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getPolygonArrayY() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getPolylineArrayY() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getPolylineArrayX() {
		// TODO Auto-generated method stub
		return null;
	}


   
		
}
