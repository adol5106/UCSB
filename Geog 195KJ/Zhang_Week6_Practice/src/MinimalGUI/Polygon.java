package MinimalGUI;



import java.util.ArrayList;
import java.util.Iterator;


public class Polygon implements Geometry{
	
	private ArrayList<Point> polygon;
	private ArrayList<Double> xcoord;
	private ArrayList<Double> ycoord;
	private Point lowerleft;
	private Point upperright;
	
	
    
	public Polygon()      //Build the constructor and integrate all points into an arraylist named polygon/
	{
	 polygon = new ArrayList<Point>();
	 xcoord = new ArrayList<Double>();
	 ycoord = new ArrayList<Double>();
	 
	 
	 lowerleft = new Point(2147483647.0,2147483647.0);
	 upperright= new Point(-2147483647.0,-2147483647.0);
  //Initialize the upper right and lower left point of the bounding box/
	 



	 
	 }
	//set the lowerleft point
	public void setLowerleft(Point lowerleft)
	{
		this.lowerleft = lowerleft;
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

    public int getLength()   //Get the total amount of Polygon's vertexes/
    {return polygon.size();}
    
    public ArrayList<Point> getPolygon()  //Get the polygon object/
    { return polygon;}
    
	public void addPoint(Point p)
	{
	  polygon.add(p);
	  xcoord.add(p.getX());
	  ycoord.add(p.getY());
	}
	public ArrayList<Double> getPolygonX()
	{
		return xcoord;
	}
	public ArrayList<Double> getPolygonY()
	{
		return ycoord;
	}
	
	public int[] getPolygonArrayX(){
		int[] pl=new int [getPolygonX().size()];
		for (int i=0; i<pl.length;i++)
		{
			pl[i]=getPolygonX().get(i).intValue();
		}
		return pl;
	}
	public int[] getPolygonArrayY(){
		int[] pl=new int [getPolygonY().size()];
		for (int i=0; i<pl.length;i++)
		{
			pl[i]=getPolygonY().get(i).intValue();
		}
		return pl;
	}
	
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

  //Build the bounding box by using the existing polygon/
    public void setBoundingbox(){
	    for (int i=0;i<getPolygon().size()-1;i++){
		     if (getPolygon().get(i).getX()<getLowerleft().getX()) {
		    	 getLowerleft().setX(getPolygon().get(i).getX());
		     } else if (getPolygon().get(i).getX()>getUpperright().getX()) {
		    	 getUpperright().setX(getPolygon().get(i).getX());
		     }
		     
		     if (getPolygon().get(i).getY()<getLowerleft().getY())
		     {getLowerleft().setY(getPolygon().get(i).getY());
		     } else if (getPolygon().get(i).getY()>getUpperright().getY()) {
		    	 getUpperright().setY(getPolygon().get(i).getY());
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
    
	