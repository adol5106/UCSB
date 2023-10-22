package examples;

public class Book {
//Member variables
	private String bookName;
	private String bookGenre;
	private double bookPrice;
	private int bookRating;
	
	//Default parameters
	static final String defBookGenre = "General";
	static final double defBookPrice = 10;
	static final int maxBookRating = 10;
	static final int defBookRating = 5;
	
//Constructor for book***********************************************
	public Book() throws Throwable{
		System.out.println("No Book created");
		this.finalize(); 
	}
	
	public Book(String nbName){
		this(nbName, defBookGenre, defBookPrice, defBookRating);
	}
	
	public Book(String nbName, double nbPrice){
		this(nbName, defBookGenre, nbPrice, defBookRating);
	}
	
	public Book(String nbName, int nbRating){
		this(nbName, defBookGenre, defBookPrice, nbRating);
	}
	
	public Book(String nbName,String nbGenre, double nbPrice){
		this(nbName, nbGenre, nbPrice, defBookRating);
	}
	
	public Book(String nbName, String nbGenre, int nbRating){
		this(nbName, nbGenre, defBookPrice, nbRating);
	}
	
	public Book(String nbName,String nbGenre, double nbPrice, int bookRating){
		setBookName(nbName);
		setBookGenre(nbGenre);
		setBookPrice(nbPrice);
		setBookRating(bookRating);
	}
	
//Book name methods**************************************************
	 /* TASK: Gets Book Name
	 *  RETURNS: String
	 */ 
	public String getBookName() {
		return bookName;
	}

	 /* TASK: Sets Book Genre
	 *  RETURNS: void
	 */ 
	private void setBookName(String bookName) {
		this.bookName = bookName;
	}
//Book Genre*********************************************************
	 /* TASK: Gets Book Genre
	 *  RETURNS: String
	 */ 
	public String getBookGenre() {
		return bookGenre;
	}
	
	 /* TASK: Sets Book Genre
	 *  RETURNS: void
	 */ 
	private void setBookGenre(String bookGenre) {
		//Books can't have empty or null genres
		if(bookGenre == null || bookGenre == ""){
			this.bookGenre = getDefbookgenre();
		}
		else{
			this.bookGenre = bookGenre;
		}
	}

	 /* TASK: Gets Default Book Genre
	 *  RETURNS: String
	 */ 
	public static String getDefbookgenre() {
		return defBookGenre;
	}
	
//Book price methods*************************************************	
	/* TASK: Gets Book Price
	 * RETURNS: Double
	 */ 
	public double getBookPrice() {
		return bookPrice;
	}

	 /* TASK: Sets Book Price
	 *  RETURNS: void
	 */ 
	private void setBookPrice(double bookPrice) {
		//Make sure book prices are not negative
		if(bookPrice < 0){
			this.bookPrice = getDefbookprice();
		}
		else{
			this.bookPrice = bookPrice;
		}
	}

	 /* TASK: Gets Default Book Price
	 *  RETURNS: double
	 */ 
	public static double getDefbookprice() {
		return defBookPrice;
	}
	
//Book rating methods************************************************	
	 /* TASK: Gets Book Rating
	 *  RETURNS: Integer
	 */ 
	public int getBookRating() {
		return bookRating;
	}
	
	 /* TASK: Sets Book Rating
	  *  RETURNS: void
	 */ 
	private void setBookRating(int bookRating) {
		//Make sure book rating is ok
		if(bookRating < 0){
			this.bookRating = getDefbookrating();
		}
		else if(bookRating < getMaxbookrating()){
			this.bookRating = bookRating;
		}
		else{
			this.bookRating = getDefbookrating();
		}
	}

	/* TASK: Gets Default Book Rating
	 *  RETURNS: Integer
	 */ 
	public static int getDefbookrating() {
		return defBookRating;
	}

	/* TASK: Gets Max Book Rating
	 *  RETURNS: Integer
	 */ 
	public static int getMaxbookrating() {
		return maxBookRating;
	}

	
	
	
	
	
	
}
