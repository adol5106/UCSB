package Week5;


public class WildfireModel extends disaster{
	
	//The constructor build the wildfire polygon
	public WildfireModel() {
		polygon.add(new Point(100,200));
		polygon.add(new Point(180,170));
		polygon.add(new Point(220,110));
		polygon.add(new Point(290,100));
		polygon.add(new Point(330,140));
		polygon.add(new Point(350,190));
		polygon.add(new Point(415,220));
		polygon.add(new Point(325,210));
		polygon.add(new Point(190,220));
		polygon.add(new Point(100,200));
	}

   //Get the wildfire name
public String disasterName()
{   return "Wild Fire";}

}