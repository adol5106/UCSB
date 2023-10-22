package examples;

public class Bookcase {
	private Shelf[] bcShelves;		//Array of shelves on bookcase
	private int numShelves;			//Number of shelves on bookcase

//Constructors
	//Empty
	public Bookcase(){
		Shelf[] newSh = new Shelf[1];
		newSh[0] = new Shelf();
		setBcShelves(newSh);
	}
	
	//Construct bookshelf
	public Bookcase(Shelf[] newShelves){
		setBcShelves(newShelves);
	}
	
//Bookshelf Methods	
	//Get Bookshelf array
	public Shelf[] getBcShelves() {
		return bcShelves;
	}
	
	//Set bookshelf
	private void setBcShelves(Shelf[] bcShelves) {
		this.bcShelves = bcShelves;
		setNumShelves(bcShelves.length);
	}
	
	//Get number of shelves
	public int getNumShelves() {
		return this.numShelves;
	}
	
	//Set number of shelves
	private void setNumShelves(int numShelves) {
		this.numShelves = numShelves;
	}
}
