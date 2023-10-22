package Week5;


public class Flood extends disaster{

	//The constructor build the flood polygon
	public Flood() {
		polygon.add(new Point(10,10));
		polygon.add(new Point(100,10));
		polygon.add(new Point(150,60));
		polygon.add(new Point(185,60));
		polygon.add(new Point(150,125));
		polygon.add(new Point(100,300));
		polygon.add(new Point(70,90));
		polygon.add(new Point(120,200));
		polygon.add(new Point(10,100));
		polygon.add(new Point(10,10));

	}
		

    //Get the flood name
	public String disasterName()
	{   return "Flood";}

	
	
}
