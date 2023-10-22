package Week2;

public class Polygon {
	  Point Plgon[];
	  private int s;
	  
	 	public Polygon(int s){
	 		Point Plgon[]=new Point [s];
	 		this.s=s;


		
	}
	//*This method allows add points to the array of polygon's points' coordinates/
	public void addPoint(Point aPoint, int i){
		   Plgon[i].setx(aPoint.getx());
		   Plgon[i].sety(aPoint.gety());}
	public boolean closePolygon(){
		if (Plgon[s-1].getx()==Plgon[0].getx() && Plgon[s-1].gety()==Plgon[0].gety())
		{System.out.println("The Polygon is enclosed");
		 return true;}
		else{System.out.println("This polygon is not enclosed");
		 return false;
		}
		
	}
	public int gets()
	   {return this.s;}
	    
	
}
	