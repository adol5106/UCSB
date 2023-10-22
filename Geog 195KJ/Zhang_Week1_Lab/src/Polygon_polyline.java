
public class Polygon_polyline {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int pl1x=2; int pl1y=1;  /**Polyline point 1 coordinate*/
        int pl2x=6; int pl2y=3;  /**Polyline point 2 coordinate*/
        int pg1x=1; int pg1y=3;  /**Polygon point 1 coordinate*/
        int pg2x=2; int pg2y=5;  /**Polygon point 2 coordinate*/
        int pg3x=4; int pg3y=6;  /**Polygon point 3 coordinate*/
        int pg4x=5; int pg4y=4;  /**Polygon point 4 coordinate*/
        int pg5x=1; int pg5y=3;  /**Polygon point 5 coordinate*/
        
        /**Test the polygon whether or not it is enclosed*/
        if (pg5x==pg1x && pg5y==pg1y) 
           {System.out.println("The polygon is enclosed.");}
        
        /**Calculation**/
        double dist1=Math.sqrt(Math.pow(pg1y-pl1y, 2)+Math.pow(pg1x-pl1x, 2)); /**Calculate the distance between polygon point 1 and polyline point 1*/
        double dist2=Math.sqrt(Math.pow(pg2y-pl1y, 2)+Math.pow(pg2x-pl1x, 2)); /**Calculate the distance between polygon point 2 and polyline point 1*/
        double dist3=Math.sqrt(Math.pow(pg3y-pl1y, 2)+Math.pow(pg3x-pl1x, 2)); /**Calculate the distance between polygon point 3 and polyline point 1*/
        double dist4=Math.sqrt(Math.pow(pg4y-pl1y, 2)+Math.pow(pg4x-pl1x, 2)); /**Calculate the distance between polygon point 4 and polyline point 1*/
        double dist5=Math.sqrt(Math.pow(pg1y-pl2y, 2)+Math.pow(pg1x-pl2x, 2)); /**Calculate the distance between polygon point 1 and polyline point 1*/
        double dist6=Math.sqrt(Math.pow(pg2y-pl2y, 2)+Math.pow(pg2x-pl2x, 2)); /**Calculate the distance between polygon point 2 and polyline point 1*/
        double dist7=Math.sqrt(Math.pow(pg3y-pl2y, 2)+Math.pow(pg3x-pl2x, 2)); /**Calculate the distance between polygon point 3 and polyline point 1*/
        double dist8=Math.sqrt(Math.pow(pg4y-pl2y, 2)+Math.pow(pg4x-pl2x, 2)); /**Calculate the distance between polygon point 4 and polyline point 1*/

        /**Print out the results*/
        System.out.println("The distance between Polygon point 1 and Polyline point 1 is "+dist1);
        System.out.println("The distance between Polygon point 2 and Polyline point 1 is "+dist2);
        System.out.println("The distance between Polygon point 3 and Polyline point 1 is "+dist3);
        System.out.println("The distance between Polygon point 4 and Polyline point 1 is "+dist4);
        System.out.println("The distance between Polygon point 1 and Polyline point 2 is "+dist5);
        System.out.println("The distance between Polygon point 2 and Polyline point 2 is "+dist6);
        System.out.println("The distance between Polygon point 3 and Polyline point 2 is "+dist7);
        System.out.println("The distance between Polygon point 4 and Polyline point 2 is "+dist8);
        System.out.println("So, the minimum distance between the polyline and polygon is "+dist8);
	    }
          
		
	}

