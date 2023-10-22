package Week2;


public class Point {

	private int x; private int y;
    public Point(int x,int y)
    {this.x=x;  this.y=y;
    
    }
    public double distance(Point aPoint, Point bPoint)
    {   System.out.println(Math.sqrt(Math.pow(bPoint.y-aPoint.y,2.0)+Math.pow(bPoint.x-aPoint.x,2.0)));
    	return Math.sqrt(Math.pow(bPoint.y-aPoint.y,2.0)+Math.pow(bPoint.x-aPoint.x,2.0));}
    public int getx(){
    	return this.x;}
    public int gety(){
        return this.y;}
    public void setx(int newx){
    	this.x=newx;}
    public void sety(int newy){
    	this.y=newy;
    }
}