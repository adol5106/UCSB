package Week9;


public class PointOfInterest {
     
	//These variable will be attribute of POI
	private Point p;
    private String name;
    private String type;
    
	//The constructor passes the POI point and POI name in
	public PointOfInterest(Point point,String tempName,String tempType){
		setPoint(point);
		setName(tempName);
		setType(tempType);
		
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
	public String getType()
	{
		return type;
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
	private void setType(String type)
	{
		this.type=type;
	}
}
