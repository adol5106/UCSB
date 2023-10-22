package geog.ucsb.edu;


public class Point{

	private int x; private int y;
    public Point(int x,int y)  //Build the constructor which allows the input of x and y coordiante associate with the point.
    {setX(x);setY(y);
    
    }
    public double distance(Point aPoint, Point bPoint) //Calculate the distance between two points
    {   System.out.println(Math.sqrt(Math.pow(bPoint.y-aPoint.y,2.0)+Math.pow(bPoint.x-aPoint.x,2.0)));
    	return Math.sqrt(Math.pow(bPoint.y-aPoint.y,2.0)+Math.pow(bPoint.x-aPoint.x,2.0));}
    public int getX()  //Get the x coordinate value
    {
    	return this.x;}
    public int getY()  //Get the y coordinate value
    {
        return this.y;}
    public void setX(int x)   //Set the x coordinate value to a new value
    {
    	this.x=x;}
    public void setY(int y){  //Set the y coordinate value to a new value
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
}