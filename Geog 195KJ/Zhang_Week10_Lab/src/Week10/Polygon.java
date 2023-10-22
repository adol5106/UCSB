package Week10;



import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


public class Polygon implements Serializable{
	
	private ArrayList<Point> polygon;
	private ArrayList<Double> xcoord;
	private ArrayList<Double> ycoord;
	private String name;
	private boolean shownameState=false;
	
	
    
	public Polygon()      //Build the constructor and integrate all points into an arraylist named polygon/
	{
	 polygon = new ArrayList<Point>();
	 xcoord = new ArrayList<Double>();
	 ycoord = new ArrayList<Double>();
	 }
	//Get the polygon's name
	public String getname()
	{
		return this.name;
	}
	//Set the polygon's name
	public void setname(String name)
	{
		this.name=name;
	}
	
   //Paint the polygon
    public void paintPolygon(Graphics2D g2d){
    	Iterator<Point> iterin=polygon.iterator();
    	while(iterin.hasNext()){
        	Point tp = iterin.next();
    	    int r=0;
    	    int gl=0;
    	    int b=0;
    	    Color color=new Color(r,gl,b);  //Draw the black polyline
    	    g2d.setColor(color);
            g2d.drawPolyline(getPolygonArrayX(), getPolygonArrayY(), getLength());
            g2d.setColor(Color.green); //set point color to green
            g2d.fillOval((int)tp.getX()-5,(int)tp.getY()-5,10,10); //draw the vertexs
        }
    	//Check the polygon name should be shown or not
    	if(shownameState)
        {
    		g2d.setColor(Color.blue); //set point color to yellow
        	g2d.drawString(name, xcoord.get(0).intValue()+5, ycoord.get(0).intValue()-5);
        }
    }
    public int getLength()   //Get the total amount of Polygon's vertexes/
    {return polygon.size();}
    
    public ArrayList<Point> getPolygon()  //Get the polygon object/
    { return polygon;}
    
    //Add a vertex to the polygon
	public void addPoint(Point p)  
	{
	  polygon.add(p);
	  xcoord.add(p.getX());
	  ycoord.add(p.getY());
	}
	
	//Check the vertex being touched or not
	public boolean touchedstate(Point tp)
    {
    	for(int i=0;i<polygon.size();i++)
    	{
    		Point currPt=polygon.get(i);
    		if(currPt.distance(currPt, tp)<15)
    			{
    			shownameState=true;
    			return true;
    			}
    	}
    	return false;}
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


	

  
    

	


	



	}
    
	