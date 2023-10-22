

public class Point {
	// Define member variables, the x&y coordinates of a point
	double x,y;
	
	// Point constructor takes x&y as input
	public Point(double x, double y) {
		setX(x);
		setY(y);
	}
	// This method returns the x coordinate
	public double getX(){
		return x;
	}
	// This method returns the y coordinate
	public double getY(){
		return y;
	}
	// This method changes the x coordinate
	public void setX(double x){
		this.x = x;
	}
	// This method changes the y coordinate
	public void setY(double y){
		this.y = y;
	}
	// This method calculate the distance between 2 points specified
	public double distance(Point p1, Point p2){
		return Math.sqrt(Math.pow(p1.getX()-p2.getX(),2)+Math.pow(p1.getY()-p2.getY(), 2));
	}

}
