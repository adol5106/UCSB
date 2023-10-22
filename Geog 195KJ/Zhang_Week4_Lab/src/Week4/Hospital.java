package Week4;





public class Hospital extends building{

	//Use the random methods to create certain amount of hospital location
	public Hospital(int buildingNumber)
	{ super(buildingNumber);
	for(int i=0; i<super.buildingNumber; i++){
		buildings.add(new Point((int)(Math.random()*450)+10,(int)(Math.random()*450)+10));
	}

	  }
	
	//Get the text of the "hospital"
	 public String buildingName(){
		 return "Hospital";
	 }
}

