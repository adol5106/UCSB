package Week7;

import java.util.ArrayList;//import the Array list methods/
import java.util.Iterator; //import the Iterator methods/

public class Polyline{
	
	private ArrayList<Point> polyline;  
	private ArrayList<Double> xcoord;
	private ArrayList<Double> ycoord;
	
	
	
    
	public Polyline()   //Build the constructor and integrate all points into an arraylist named polyline/
	{polyline = new ArrayList<Point>();
	 xcoord = new ArrayList<Double>();
	 ycoord = new ArrayList<Double>();


    }


    public int getLength() //Get the total amount of Polyline's vertexes/
    {   
    	return polyline.size();}
    
    public ArrayList<Point> getPolyline()  //Get the polygon object/
    { 
    	return polyline;
    }
    
    public void addPoint(Point p)   //Add point and x, y coordinate into separate arrays
	{
	  polyline.add(p);
	  xcoord.add((double) p.getX());
	  ycoord.add((double) p.getY());
	}
    
	public ArrayList<Double> getPolylineX()  //Get xcoord list
	{
		return xcoord;
	}
	public ArrayList<Double> getPolylineY()  //Get ycoord list
	{
		return ycoord;
	}
	
	//Get array of polyline x coordinate
	public int[] getPolylineArrayX(){   
		int[] pl=new int [getPolylineX().size()];
		for (int i=0; i<pl.length;i++)
		{
			pl[i]=getPolylineX().get(i).intValue();
		}
		return pl;
	}
	//Get array of polyline y coordinate
	public int[] getPolylineArrayY(){   
		int[] pl=new int [getPolylineY().size()];
		for (int i=0; i<pl.length;i++)
		{
			pl[i]=getPolylineY().get(i).intValue();
		}
		return pl;
	}
	
    
  //Print all points coordinates of this polyline/
    public void printAll(){
    	
    	Iterator<Point> iterator= polyline.iterator();
    	System.out.println("The vertexes coordinates of this polyline are:");
    	while(iterator.hasNext())
    	    {Point a;
    	    a=iterator.next();
    		System.out.println("("+a.getX()+","+a.getY()+")");
    }
    }

	public double computeArea()  //Get the area of the polyline
	{return 0;}

	public int dimensionality()  //Get the dimensionality of the polyline
	{return 1;}

	public double Perimeter() {  //Get the length of the polyline 
        double sum=0;
		for (int i=1;i<polyline.size();i++)
		{  sum+=Math.sqrt(Math.pow(polyline.get(i).getY()-polyline.get(i-1).getY(), 2)+Math.pow(polyline.get(i).getX()-polyline.get(i-1).getX(), 2));
		
		
	}
		return sum;}
	  

}
	










