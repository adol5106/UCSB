package Week7;

import java.util.ArrayList;

public class PointOfInterest {
     
	
	private ArrayList<Point> POI= new ArrayList<Point>();
    private ArrayList<String> NameList= new ArrayList<String>();
	
	public PointOfInterest(){
		
		
	}
	public void addPOI(Point p,String name){
		POI.add(p);
		NameList.add(name);
	}
	public ArrayList<Point> getPOI()
	{
		return POI;
	}
	public ArrayList<String> NameList()
	{
		return NameList;
	}
}
