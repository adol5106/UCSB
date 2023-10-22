package Week4;



import java.util.ArrayList;  //import the Array list methods/
import java.util.Iterator;  //import the Iterator methods/


public class Polygon {
	
	protected ArrayList<Point> polygon;  
    
	public Polygon()      //Build the constructor and integrate all points into an arraylist named polygon/
	{polygon = new ArrayList<Point>();
}
	public boolean add(Point e) //Delegate method/
    {return polygon.add(e);}

    public int getLength()   //Get the total amount of Polygon's vertexes/
    {return polygon.size();}
    
    public ArrayList<Point> getPolygon()  //Get the polygon object/
    { return polygon;
    
    }
    
    //Print all points coordinates of this polygon/
    public void printAll(){
    	
    	Iterator<Point> iterator= polygon.iterator();
    	System.out.println("The vertexes coordinates of this polygon are:");
    	while(iterator.hasNext())
    	    {Point a;
    	    a=iterator.next();
    		System.out.println("("+a.getx()+","+a.gety()+")");
    }}
    //Check the polygon is closed or not/
    public boolean closePolygon()
    {    //If it is closed, the last vertex's coordinate must be same as the first vertex.
         if (polygon.get(0).getx()==polygon.get(polygon.size()-1).getx() && polygon.get(0).gety()==polygon.get(polygon.size()-1).gety())
           
        	 return true;
         
         else 
        	 return false;
         
    
    }
    }
	