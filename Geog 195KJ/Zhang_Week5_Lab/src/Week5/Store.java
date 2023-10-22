package Week5;



public class Store extends building{


//Use the random methods to create certain amount of store location
	public Store(int buildingNumber){  
		super(buildingNumber);
		for(int i=0; i<super.buildingNumber; i++){
			buildings.add(new Point((int)(Math.random()*450)+10,(int)(Math.random()*450)+10));}
		}

    
	
//Get the text of the "store"
	 public String buildingName(){
		 return "Store";
	 }

}
