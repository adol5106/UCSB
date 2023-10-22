

// The Farm class it your model/blueprint of a farm and has no main method. 
// This class here is for testing your model, i.e., for creating specific farm objects. 

public class FarmTest {

	public static void main(String[] args) {
		
		// Create (and name) two farms
		Farm aFarm = new Farm("Super Farm");
		Farm aFarm2 = new Farm("Big Farm");
		Farm aFarm3 = new Farm("XFarm", 100); // This farm is created by calling the second constructor.
		
		//Display the name
		System.out.println(aFarm.getName());
		
		// Change the name (and display it)
		aFarm.setName("New Farm");
		System.out.println(aFarm.getName());
		
		// Create an array of (3) farms
		Farm[] farms = {aFarm, aFarm2, aFarm3};
		
		//Iterate over all farms to get the number of employees.
		for (int i =0; i < farms.length; i++){ // farms.length returns the number of elements in the array
			/*
			 * As we have defined Farm as a complex data type (class) together with some method, we can iterate 
			 * over individual farms, i.e., object, and call these methods to return the name of the farms and
			 * the number of employees. Note how we use i to select the right index in the array of farms.
			 */
			System.out.println("Farm "+farms[i].getName()+" has "+farms[i].getNrOfemployees()+" employees.");
		}
	}
}
