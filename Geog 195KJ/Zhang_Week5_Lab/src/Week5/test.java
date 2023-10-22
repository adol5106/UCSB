package Week5;

import java.util.ArrayList;  //import the Array list methods/
import java.util.Iterator;  //import the Iterator methods


public class test {


	public static void main(String[] args) {

         surface rectangle=new Rectangles(3.5,4.5);     //Create a rectangle implement surface
         System.out.println("The area of this rectange is "+rectangle.computeArea());    //Use the surface interface to calculate the area of rectangle
         System.out.println("The dimensionality of this rectangle is "+rectangle.dimensionality()); //Use the surface interface to calculate the dimensionality of rectangle
         System.out.println("The Perimeter of this retangle is "+rectangle.Perimeter());  //Use the surface interface to calculate the perimeter of rectangle
         
         surface buffer=new Buffer(new Point(5,7),5.0);    //Create a point buffer implement surface
         System.out.println("The area of this buffer is "+buffer.computeArea());  //Use the surface interface to calculate the area of point buffer
         System.out.println("The dimensionality of this buffer is "+buffer.dimensionality());  //Use the surface interface to calculate the dimensionality of point buffer
         System.out.println("The Perimeter of this buffer is "+buffer.Perimeter());  //Use the surface interface to calculate the perimeter of buffer
         Polygon aPolygon=new Polygon();  //Create a polygon
         aPolygon.add(new Point(5,8));
         aPolygon.add(new Point(7,10));
         aPolygon.add(new Point(4,11));
         aPolygon.add(new Point(5,8));
         surface boundingbox=new BoundingBox(aPolygon);  //Build the bounding box of this polygon
         System.out.println("The area of the bounding box is "+boundingbox.computeArea());  //Use the surface interface to calculate the area of the bounding box
         System.out.println("The dimensionality of this boundingbox is "+boundingbox.dimensionality());  //Use the surface interface to calculate the dimensionality of the bounding box
         System.out.println("The perimeter of the polygon is "+boundingbox.Perimeter()); //Use the surface interface to calculate the perimeter of the bounding box
         Flood aflood=new Flood();  //Create a flood which inherit to disaster and inherit to polygon
         surface floodzone=new BoundingBox(aflood);  //Create a bounding box of the flood polygon to represent the actual hazard zone
         System.out.println("The area of the flood zone is "+floodzone.computeArea());  //Calculate the area of the flood hazard zone
         System.out.println("The dimensionality of the flood disaster polygon is "+aflood.dimensionality()); //Get the dimensionality of the flood hazard zone
         System.out.println("The perimeter of the flood disaster polygon is "+aflood.Perimeter());  //Get the perimeter of the flood hazard zone
         WildfireModel awildfire=new WildfireModel();  //Create a wildfire which inherit to disaster and inherit to polygon
         surface wildfirezone=new BoundingBox(awildfire);  //Create a bounding box of the disaster polygon to represent the actual hazard zone
         System.out.println("The area of the wildfire is "+wildfirezone.computeArea()); //Calculate the area of the wildfire hazard zone
         System.out.println("The dimensionality of the wildfire disaster polygon is "+awildfire.dimensionality());  //Get the dimensionality of the wildfire hazard zone
         System.out.println("The perimeter of the wildfire disaster polygon is "+awildfire.Perimeter());  //Get the perimeter of the wildfire hazard zone
         Farm afarm=new Farm(7);  //Create seven farms
         Hospital ahospital=new Hospital(10);  //Create ten hospitals
         Store astore=new Store(5);  //Create five stores
         //Print out all evacuation message 
         checkAll((BoundingBox) floodzone,afarm.getBuildings(),afarm.buildingName(),aflood.disasterName());
         checkAll((BoundingBox) floodzone,ahospital.getBuildings(),ahospital.buildingName(),aflood.disasterName());
         checkAll((BoundingBox) floodzone,astore.getBuildings(),astore.buildingName(),aflood.disasterName());
         checkAll((BoundingBox) wildfirezone,afarm.getBuildings(),afarm.buildingName(),awildfire.disasterName());
         checkAll((BoundingBox) wildfirezone,ahospital.getBuildings(),ahospital.buildingName(),awildfire.disasterName());
         checkAll((BoundingBox) wildfirezone,astore.getBuildings(),astore.buildingName(),awildfire.disasterName());
         
}
	//This method check all buildings' evacuation status of a particular disaster
	public static void checkAll(BoundingBox TheBoundingBox, ArrayList<Point> buildings, String buildName, String disaName){

		Iterator<Point> iterator=buildings.iterator();
		while (iterator.hasNext())
			{Point p;
			 p=iterator.next();
			 if (TheBoundingBox.isInside(p))
				 System.out.println("The "+buildName+" ("+p.getx()+","+p.gety()+") should be evacuated for the disaster of "+disaName+".");
			 else
				 System.out.println("The "+buildName+" ("+p.getx()+","+p.gety()+") should not be evacuated for the disaster of "+disaName+".");
			}
		      
		}
}
