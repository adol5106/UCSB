package basicgeometry;

public class Rectangle implements geometry{

	private double a,b;
	 
	public Rectangle (double a,double b){
		this.a=a;
		this.b=b;
	}

	@Override
	public double computeArea() {
		// TODO Auto-generated method stub
		return a*b;
	}
	  
	
}
