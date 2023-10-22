package Week2_Arraylist;



public class test {

    public static void main(String[] args){
    	_Polyline poly = new _Polyline(); //Create a new polyline/
    	_Polygon pogn = new _Polygon();  //Create a new polygon/
    	
    	poly.add(new Point(1,1)); //Add four points to the polyline/
    	poly.add(new Point(2,1));
    	poly.add(new Point(3,1));
    	poly.add(new Point(4,2));
    	poly.getLength(); //Print out the total amount of vertexes of the polyline/
    	poly.printAll();
    	poly.add(new Point(5,3)); //Add additional point.
    	poly.getLength(); //Print out the total amount of vertexes of the polyline/
    	poly.printAll(); //Print the modified polyline vertexes.
    	pogn.add(new Point(1,1)); //Add four points to the polyline/
    	pogn.add(new Point(2,1));
    	pogn.add(new Point(3,4));
    	pogn.add(new Point(1,6));
    	pogn.printAll(); //Print out the total amount of vertexes of the polyline
    	pogn.closePolygon(); //Check the polygon closed or not/
    	pogn.add(new Point(1,1));//Add the last point
    	pogn.printAll(); //Print out the total amount of vertexes of the polyline
    	pogn.closePolygon(); //Check the polygon closed or not/
    	BoundingBox bundbox = new BoundingBox(pogn); //Create a bounding box/
    	bundbox.setBoundingbox(); //Setting the bounding box/
    	bundbox.isInside(new Point (2,3));
    	bundbox.isInside(new Point (7,10));//Check this point is inside or not/
	}

}
