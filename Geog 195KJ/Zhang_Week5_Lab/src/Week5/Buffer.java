package Week5;

public class Buffer implements surface{
	
	private Point center;
	private double radius;
	//private double area;
		
	public Buffer(Point p, double r){  
		setCenter(p);
		setRadius(r);

	}
   //Get the radius of the buffer
	public double getRadius() { 
		return radius;
	}
   //Set the radius of the buffer
	private void setRadius(double radius) {
		this.radius = radius;
	}
	//Set the center of the buffer
	private void setCenter(Point p){
		this.center=p;
	}
	//Get the area of the buffer
    public double computeArea(){
        return Math.PI*Math.pow(getRadius(), 2);}
	
    //Check whether or not a point is in the buffer
	public boolean isInside(Point newPoint){
		if (center.distance(center, newPoint) < getRadius() ){
			return true;
		}else{
			return false;
		}
	}
	//Get the dimensionality of the buffer
	public int dimensionality() {
		return 2;
	}

    //Get the perimeter of the buffer
	public double Perimeter() {
        return Math.PI*2*getRadius();
	}

		
}
