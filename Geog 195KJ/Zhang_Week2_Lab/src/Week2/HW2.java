package Week2;

public class HW2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Point firstPoint= new Point(2,3);
        Point secondPoint= new Point(5,10);
        
        firstPoint.distance(firstPoint, secondPoint);
        Polyline poly=new Polyline(5);
        
        poly.addPoint(firstPoint,0);
        
        //poly.addPoint(new Point(1,2),0);
        //poly.addPoint(new Point(3,5),1);
        //poly.addPoint(new Point(4,5),2);
        //poly.addPoint(new Point(4,6),3);
        //poly.addPoint(new Point(4,7),4);
        //poly.printPolyline();
        
        
        
        
	}
}
