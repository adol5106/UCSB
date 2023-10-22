package Week5;

import java.util.ArrayList;//import the Array list methods/
import java.util.Iterator; //import the Iterator methods/

public class Polyline implements surface{
	
	private ArrayList<Point> polyline; 
    
	
    
	public Polyline()   //Build the constructor and integrate all points into an arraylist named polyline/
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

	public double computeArea()  //Get the area of the polyline
	{return 0;}

	public int dimensionality()  //Get the dimensionality of the polyline
	{return 1;}

	public double Perimeter() {  //Get the length of the polyline I don't know how to use the array list to calculate the perimeter sorry!

		return getLength();
	}

}
