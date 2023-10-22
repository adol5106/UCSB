package Week5;

public class Rectangles implements surface{

	private double a,b;
	 
	public Rectangles (double a,double b){ //The constructor input the side length a and b
		seta(a);
		setb(b);
		
	}
    //Get the area of the rectangle
	public double computeArea() {

		return a*b;
	}
	//Get the dimensionality of the rectangle
	public int dimensionality() {
		return 2;
	}
	//Set side length a
    private void seta(double a)
    { this.a=a;}
    //Set side length b
    private void setb(double b)
    { this.b=b;}
    //Get the perimeter
	public double Perimeter() {
    	return 2*a+2*b;
	}
}
