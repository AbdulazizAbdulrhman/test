//Abdulaziz Abdulrhman Alghazi ID:435102241  عبدالعزيز عبدالرحمن
import java.util.Scanner;
public class Library {
	private Book[] libraryBooks;
	private int numOfBooks;
	public static final int MAX_SIZE=100;
	
	public Library() {
		this.numOfBooks=0;
		this.libraryBooks=new Book[this.MAX_SIZE];
	}
	public boolean addBook(int ISBN, String author, String title, String genre) {
		if(Book.verifyISBN(ISBN)) {
			if(this.findBook(ISBN) == -1)
			this.libraryBooks[this.numOfBooks++] = new Book(ISBN, author, title, genre);
			return true;
		}
		return false;
	}
	public boolean addBook(Book a) {
		if(a.verifyISBN(a.getISBN())) {
			if(this.findBook(a.getISBN()) == -1)
			this.libraryBooks[this.numOfBooks++] = new Book(a.getISBN(), a.getAuthor(),a.getTitle(), a.getGenre());
			return true;
		}
		return false;
	}
	public int findBook(int ISBN) {
		for(int i =0; i<this.numOfBooks; i++)
			if(this.libraryBooks[i].getISBN() == ISBN)
				return i;
		return -1;
	}
	public boolean deleteBook(int ISBN) {
		if(this.findBook(ISBN) != -1) {
			this.libraryBooks[this.findBook(ISBN)] = this.libraryBooks[this.numOfBooks-1];
			this.numOfBooks--;
			return true;
		}
		return false;
	}

	public int findBook(Book find) {
		for(int i=0; i<this.numOfBooks; i++) {
			if(this.libraryBooks[i].getISBN() == find.getISBN())
				return i;
		}
		return -1;
	}
	public void printAll() {
		if(this.numOfBooks>0)
			for(int i=0; i<this.numOfBooks; i++)
				this.libraryBooks[i].printBookInfo();
				
	}
	public void printGenre(String genre) {
		if(this.numOfBooks>0) {
			for(int i=0; i<this.numOfBooks; i++) {
			if(this.libraryBooks[i].getGenre().equalsIgnoreCase(genre))
				this.libraryBooks[i].printBookInfo();
			}
		}
	}
	
	
	public int getNumberOfBooksByAuthor(String Author) {
		int result=0;
		for(int i=0; i<this.numOfBooks; i++)
			if(this.libraryBooks[i].getAuthor().equalsIgnoreCase(Author))
				result++;
		return result;
	}
	public int getNumberOfBooks() {
		return this.numOfBooks;
	}
	public Book[] getLibraryBooks() {
		return this.libraryBooks;
	}
	public void setNumOfBooks(int n) {
		this.numOfBooks=n;
	}
	public void printBookInfo(int a) {
		this.libraryBooks[a].printBookInfo();
	}
}
