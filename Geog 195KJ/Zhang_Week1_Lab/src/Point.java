
public class Point {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int p1x=2;  /**Point 1 x coordinate*/
      int p1y=1;  /**Point 1 y coordinate*/
      int p2x=6;  /**Point 2 x coordinate*/
      int p2y=3;  /**Point 2 y coordinate*/
      System.out.println("Point 1 ("+p1x+","+p1y+")"); /**Print point 1 coordinate*/
      System.out.println("Point 2 ("+p2x+","+p2y+")"); /**Print point 2 coordinate*/
      System.out.println("The Euclidean distance between Point 1 and 2 is");
      System.out.println(Math.sqrt(Math.pow(p2y-p1y, 2)+Math.pow(p2x-p1x, 2)));/**Print the Euclidean distance*/
	}

}
