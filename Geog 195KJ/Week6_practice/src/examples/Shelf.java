package examples;

public class Shelf {
	private Book[] bookShelf;			//Bookshelf that holds books
	private String bookshelfGenre;		//Name of bookshelf genre
	private int bookCount;				//Count of books in bookshelf
	
//Constructors	
	/*Empty constructor*/
	public Shelf(){
		this(new Book[0], Book.defBookGenre);
	}
	
	/*Uses the other constructor with "" are a
	 * genre for the bookshelf.*/
	public Shelf(Book[] nbsBooks){
		this(nbsBooks, Book.defBookGenre);
	}
	
	/*Our main constructor with all the arguments*/
	public Shelf(Book[] nbsBooks,String nbsGenre){
		setBookshelfGenre(nbsGenre);
		setBookShelf(nbsBooks);
	}

//Bookshelf methods
	/* TASK: Returns a copy of all the books on
	 * our bookshelf.
	 * RETURNS Array of Book*/	
	public Book[] getBookShelf() {
		return bookShelf;
	}

	/* TASK: Sets/updates the array that holds out books.
	 * Only books that are of the same genre as the bookshelf
	 * are allowed on the bookshelf, however.
	 * RETURNS: void
	 */ 
	public void setBookShelf(Book[] newbookShelf) {
		//Make sure new shelf has more than one book
		if(newbookShelf.length >= 1){
			
			//Find and keep track books of correct genre
			Boolean[] okBook = new Boolean[newbookShelf.length];	//Temp array to keep track of book w/ correct genre 
			int okbookCount = 0;									//Count of new books w/ correct genre
			
			//Iterate through new book shelf
			for(int i = 0; i < newbookShelf.length; i++){
				okBook[i] = (newbookShelf[i].getBookGenre() == getBookshelfGenre()? true : false);	//Alternate if/then statement type  
				okbookCount = (newbookShelf[i].getBookGenre() == getBookshelfGenre()? 
								okbookCount + 1 : okbookCount);
			}
		
		//Add books of correct genre to new book array
			if(okbookCount > 0){
				Book[] okBooks = new Book[okbookCount];				//Temp array to hold good books
				
				//Add ok Books to temp book collection
				for(int i = 0; i < newbookShelf.length; i++){
					if(okBook[i] == true){
						okbookCount -= 1;
						okBooks[okbookCount] = newbookShelf[i];
					}
				}
				
				//Loop done => add okBooks to shelf collection
				//and update count  
				this.bookShelf = okBooks;
				setBookCount(okBooks.length);
			}
			else{
				System.out.println("No books added");
			}
		}
		else{
			if(getBookCount() > 0){
				System.out.println("No books added");
			}
			else{
				System.out.println("No books on shelf");
			}
		}
	}

	/* TASK: Method returns the genre of the bookshelf
	 * RETURNS: String
	*/
	public String getBookshelfGenre() {
		return bookshelfGenre;
	}

	/* TASK: Sets the bookshelf's genre to new String.
	 * Can't have empty name for bookshelf.
	 * RETURNS: void
	*/
	private void setBookshelfGenre(String nbsGenre) {
		if(nbsGenre == null || nbsGenre == ""){
			this.bookshelfGenre = Book.defBookGenre;
		}
		else{
			this.bookshelfGenre = nbsGenre;
		}			
	}

//Book methods	
	/* TASK: attempts to add an array 
	 * of books to the bookshelf.
	 * RETURNS: void
	*/
	public void addBooks(Book[] newBooks){
		//Temp array to hold old books and new book
			Book[] newBS = new Book[getBookCount()+ newBooks.length]; 	
		
		//Keep old books in temp array
			for(int i = 0; i<(getBookCount()); i++){
				newBS[i] = getBookShelf()[i];
			}
		
		//Add new books to temp array
			for(int i=0; i< newBooks.length; i++){
				newBS[i + getBookCount()] = newBooks[i];
			}
		
		//Try to update new book array
			setBookShelf(newBS);
	}
	
	/* TASK: Attempts to add a single 
	 * book to the bookshelf.
	 *  RETURNS: void 
	*/
	public void addBook(Book newBook){
		//Temp array to hold old books and new book
			Book[] newBS = new Book[getBookCount()+1]; 	

		//Keep old books
			for(int i = 0; i<(getBookCount()); i++){
				newBS[i] = getBookShelf()[i];
			}
			
		//Add new book
			newBS[getBookCount()-1] = newBook;
		
		//Try to update new book array
			setBookShelf(newBS);
	}
	
	/* TASK: Returns the books
	 * from the book shelf.
	 * RETURNS Book
	 */	
	public Book getBook(int bookIdx){
		if(bookIdx < 0 || bookIdx >= getBookCount()){
			System.out.println("Error: Cannot return that book. Returning empty book.");
			return null;
		}
		else{
			return this.bookShelf[bookIdx];
		}
	}
	
	
	/* TASK: Returns the number of books
	 * on the book shelf.
	 * RETURNS int
	 */	
	public int getBookCount() {
		return bookCount;
	}

	/*This method updates the number of books
	 * on the book shelf.
	 */	
	private void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}	
}
