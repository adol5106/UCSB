package MinimalGUI;

import java.util.ArrayList;//import the Array list methods/
import java.util.Iterator; //import the Iterator methods/

public class Polyline implements Geometry{
	
	private ArrayList<Point> polyline;  
	private ArrayList<Double> xcoord;
	private ArrayList<Double> ycoord;
	private Point lowerleft;
	private Point upperright;
	
	
    
	public Polyline()   //Build the constructor and integrate all points into an arraylist named polyline/
	{polyline = new ArrayList<Point>();
	 xcoord = new ArrayList<Double>();
	 ycoord = new ArrayList<Double>();
	 lowerleft = new Point(2147483647.0,2147483647.0);
	 upperright= new Point(-2147483647.0,-2147483647.0);
  //Initialize the upper right and lower left points of the bounding box/
	 

}
    //set the lowerleft point
	public void setLowerleft(Point lowerleft)
	{
		this.lowerleft=lowerleft;
	}
    //set the upperright point
	public void setUpperright(Point upperright)
	{
		this.upperright=upperright;
	}
    //get the lowerleft point
	public Point getLowerleft()
	{
		return lowerleft;
	}
    //get the upperright point
	public Point getUpperright()
	{
		return upperright;
	}
    public int getLength() //Get the total amount of Polyline's vertexes/
    {   
    	return polyline.size();}
    
    public ArrayList<Point> getPolyline()  //Get the polygon object/
    { return polyline;}
    
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

	public double Perimeter() {  //Get the length of the polyline I don't know how to use the array list to calculate the perimeter sorry!

		return getLength();
	}
	  //Build the bounding box by using the existing polygon/
    public void setBoundingbox(){
	    for (int i=0;i<getPolyline().size()-1;i++){
		     if (getPolyline().get(i).getX()<getLowerleft().getX()) {
		    	 getLowerleft().setX(getPolyline().get(i).getX());
		     } else if (getPolyline().get(i).getX()>getUpperright().getX()) {
		    	 getUpperright().setX(getPolyline().get(i).getX());
		     }
		     
		     if (getPolyline().get(i).getY()<getLowerleft().getY())
		     {getLowerleft().setY(getPolyline().get(i).getY());
		     } else if (getPolyline().get(i).getY()>getUpperright().getY()) {
		    	 getUpperright().setY(getPolyline().get(i).getY());
		     }}
	
    }

	
	@Override
	public Point getCentre() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getRadius() {
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








}
