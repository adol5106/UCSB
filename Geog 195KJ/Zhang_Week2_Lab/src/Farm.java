
public class Farm {

	//Member variables are visible within the whole class.
	String name=""; // An empty string that will store the name of the farm
	int NrOfemployees=0; // The number of employees is set to 0 as default value;
	
	// This constructor does not take the number of employees as additional input and, hence, it will remain 0; see line 7.
	public Farm(String name){
		// The content (or pointer) of the local 'name' variable will be stored in the member variable in line 6.
		this.name = name; 
	}
	
	//This constructor also allows to specify a number of employees.
	public Farm(String name, int NrOfemployees){
		this.name = name;
		this.NrOfemployees = NrOfemployees; 
	}
	
	//This returns the value stored in the member variable name.
	public String getName(){
		return name;
	}
	
	//Assigns a new value to name, e.g., to change the name of the farm.
	public void setName(String newName){
		name = newName;
	}
	
	// This just returns the number of employees of the farm.
	public int getNrOfemployees() {
		return NrOfemployees;
	}

	// This method allows you to change the number of employees.
	public void setNrOfemployees(int nrOfemployees) {
		NrOfemployees = nrOfemployees;
	}
}
