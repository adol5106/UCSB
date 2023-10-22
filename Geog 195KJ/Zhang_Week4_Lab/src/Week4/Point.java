package Week4;


public class Point {

	private int x; private int y;
    public Point(int x,int y)  //Build the constructor which allows the input of x and y coordiante associate with the point.
    {this.x=x;  this.y=y;
    
    }
    public double distance(Point aPoint, Point bPoint) //Calculate the distance between two points
    {   System.out.println(Math.sqrt(Math.pow(bPoint.y-aPoint.y,2.0)+Math.pow(bPoint.x-aPoint.x,2.0)));
    	return Math.sqrt(Math.pow(bPoint.y-aPoint.y,2.0)+Math.pow(bPoint.x-aPoint.x,2.0));}
    public int getx()  //Get the x coordinate value
    {
    	return this.x;}
    public int gety()  //Get the y coordinate value
    {
        return this.y;}
    public void setx(int newx)   //Set the x coordinate value to a new value
    {
    	this.x=newx;}
    public void sety(int newy){  //Set the y coordinate value to a new value
    	this.y=newy;
    }
    
}