package geog.ucsb.edu;



import java.util.ArrayList;  //import the Array list methods/

import java.util.Iterator;  //import the Iterator methods/


public class Polygon{
	
	protected ArrayList<Point> polygon;  
    
	public Polygon()      //Build the constructor and integrate all points into an arraylist named polygon/
	{polygon = new ArrayList<Point>();
}

    public int getLength()   //Get the total amount of Polygon's vertexes/
    {return polygon.size();}
    
    public ArrayList<Point> getPolygon()  //Get the polygon object/
    { return polygon;
    
    }
	public boolean add(Point e) //Delegate method/
    {return polygon.add(e);}
	
    //Print all points coordinates of this polygon/
    public void printAll(){
    	
    	Iterator<Point> iterator= polygon.iterator();
    	System.out.println("The vertexes coordinates of this polygon are:");
    	while(iterator.hasNext())
    	    {Point a;
    	    a=iterator.next();
    		System.out.println("("+a.getX()+","+a.getY()+")");
    }}
    //Check the polygon is closed or not/
    public boolean closePolygon()
    {    //If it is closed, the last vertex's coordinate must be same as the first vertex.
         if (polygon.get(0).getX()==polygon.get(polygon.size()-1).getX() && polygon.get(0).getY()==polygon.get(polygon.size()-1).getY())
         {   System.out.println("This polygon is closed.");
        	 return true;
         }
         else {System.out.println("This polygon is not closed");
        	 return false;
         }
    
    }
	public int dimensionality() { //Get the dimensionality of the polygon
		return 2;
	}

	public double computeArea() {  //I don't know how to use the array list to calculate the area of the polygon sorry!
		return 0;
	}


	public double Perimeter() {  //Get the length of the polygon  I don't know how to use the array list to calculate the perimeter sorry!

		return getLength();
	}
    }
	