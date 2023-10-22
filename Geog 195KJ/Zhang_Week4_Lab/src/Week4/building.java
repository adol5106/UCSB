package Week4;

import java.util.ArrayList;

public class building {

	protected int buildingNumber;  //The total amount of the buildings
	protected ArrayList<Point> buildings;   //The arraylist of the buildings' coordinates
	

//Create some coordinates for buildings
  public building (int buildingNumber){
	  this.buildingNumber=buildingNumber;
	  buildings = new ArrayList<Point>();
	  }

// Returns the list of buildings
  public ArrayList<Point> getBuildings(){
	return buildings;
		}
}