package Week2;

public class Polyline {
  private Point[] Pline;
  private int s;
 
 	public Polyline(int s){
 		Pline=new Point[s];
 		this.s=s;

 	}
 	//*This method allows add points to the array of the polyline's points' coordinates/
	public void addPoint(Point aPoint, int i){
	   Pline[i]=aPoint;
	}
	public void printPolyline()
	   {for (int k=0;k<s;k++){
		   System.out.println("("+Pline[k].getx()+","+Pline[k].gety()+")");
	   }
	   }
}
	