package Week2_Arraylist;

import java.util.ArrayList;//import the Array list methods/
import java.util.Iterator; //import the Iterator methods/

public class _Polyline {
	
	private ArrayList<Point> polyline; 
    
	
    
	public _Polyline()   //Build the constructor and integrate all points into an arraylist named polyline/
	{polyline = new ArrayList<Point>();
}
	public boolean add(Point e)  //Delegate method/
    {return polyline.add(e);}

    public int getLength() //Get the total amount of Polyline's vertexes/
    {   System.out.println("The total amount vertex point is "+polyline.size());
    	return polyline.size();}
    
   
    
    
  //Print all points coordinates of this polyline/
    public void printAll(){
    	
    	Iterator<Point> iterator= polyline.iterator();
    	System.out.println("The vertexes coordinates of this polyline are:");
    	while(iterator.hasNext())
    	    {Point a;
    	    a=iterator.next();
    		System.out.println("("+a.getx()+","+a.gety()+")");
    }
    }
    }

