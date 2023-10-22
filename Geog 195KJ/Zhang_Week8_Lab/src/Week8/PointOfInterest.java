package Week8;

import java.io.Serializable;



public class PointOfInterest implements Serializable{
     
	//These variable will be attribute of POI
	private Point p;
    private String name;
    
	//The constructor passes the POI point and POI name in
	public PointOfInterest(Point p,String name){
		setPoint(p);
		setName(name);
		
	}
	//Get the POI point
	public Point getPoint()
	{
		return p;
	}
	//Get the name og POI
	public String getName()
	{
		return name;
	}
	//Set the POI point
	private void setPoint(Point p)
	{
		this.p=p;
	}
	//Set the POI name
	private void setName(String name)
	{
		this.name=name;
	}
}
