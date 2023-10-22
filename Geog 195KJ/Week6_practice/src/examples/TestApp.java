package examples;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bookcase testBookcase = new Bookcase();
		System.out.println("Num shelves: " + testBookcase.getNumShelves());
		System.out.println("Genre: " + testBookcase.getBcShelves()[0].getBookshelfGenre());
		
		//Should return error
		System.out.println(testBookcase.getBcShelves()[0].getBook(0).getBookName());
		
	}

}
