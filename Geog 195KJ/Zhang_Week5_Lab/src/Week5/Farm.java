package Week5;



public class Farm extends building{

	//Use the random methods to create certain amount of farm location
	public Farm(int buildingNumber){
		super(buildingNumber);
		for(int i=0; i<super.buildingNumber; i++){
			buildings.add(new Point((int)(Math.random()*450)+10,(int)(Math.random()*450)+10));}
		
    }
	
    //Get the text of the "farm"
	 public String buildingName(){
		 return "Farm";
	 }

}
