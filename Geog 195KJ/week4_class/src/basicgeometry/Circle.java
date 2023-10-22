package basicgeometry;

public class Circle implements geometry{

	double r;
	public Circle (double r){
	this.r=r;
}


   public double computeArea()
   {
	   return Math.pow(r, 2)*Math.PI;
   }
}