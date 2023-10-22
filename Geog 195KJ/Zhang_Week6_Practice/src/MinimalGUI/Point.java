package MinimalGUI;


public class Point implements Geometry{

	private double x; private double y;
	//private static Polygon boundingBoxPoint=new Polygon();
	private Point lowerleft;
	private Point upperright;
    public Point(double x,double y)  //Build the constructor which allows the input of x and y coordiante associate with the point.
    {setX(x);setY(y);
    
    
    }
    public double distance(Point aPoint, Point bPoint) //Calculate the distance between two points
    {   
    	return Math.sqrt(Math.pow(bPoint.y-aPoint.y,2.0)+Math.pow(bPoint.x-aPoint.x,2.0));}
    public double getX()  //Get the x coordinate value
    {
    	return this.x;}
    public double getY()  //Get the y coordinate value
    {
        return this.y;}
    public void setX(double x)   //Set the x coordinate value to a new value
    {
    	this.x=x;}
    public void setY(double y){  //Set the y coordinate value to a new value
    	this.y=y;
    }
	public int dimensionality() {  //Get the dimensionality of the point
		return 0;
	}

	public double computeArea() {  //Get the area of the point
        return 0;
	}

	public double Perimeter() {  //Get the perimeter of the point
        return 0;
	}
	public void setLowerleft(Point lowerleft)
	{
		this.lowerleft = lowerleft;
	}

	public void setUpperright(Point upperright)
	{
		this.upperright=upperright;
	}

	public Point getLowerleft()
	{
		return lowerleft;
	}

	public Point getUpperright()
	{
		return upperright;
	}
	@Override
	public int getLength() {
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
	@Override
	public void setBoundingbox() {
		setLowerleft(new Point(getX(),getY()));
		
		setUpperright(new Point(getX()+3,getY()+3));

		
	}
	

}