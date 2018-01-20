//Abdulaziz Abdulrhman Alghazi ID:435102241  عبدالعزيز عبدالرحمن
import java.util.Scanner;
public class Book {
	private int ISBN; 
	private String author; 
	private String title;
	private String genre; 
	private String refCode;
	
	public Book() {
		
	}
	
	public Book(int ISBN, String author, String title, String genre) {
		 this.setISBN(ISBN);
		this.setAuthor(author);
		this.setTitle(title);
		this.setGenre(genre);
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		if(this.verifyISBN(iSBN))
			this.ISBN=iSBN;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRefCode() {
		return refCode;
	}

	public void generateReference() {
		this.refCode =""+this.author.charAt(0)+ this.author.charAt(1)+"-"+this.genre.charAt(0)+this.genre.charAt(1);
	}
	
	public static boolean verifyISBN(int ISBN) {		
		int n4 = ISBN%10;
		ISBN = ISBN /10;
		int n3 = ISBN %10;
		ISBN = ISBN /10;
		int n2 = ISBN% 10;
		ISBN = ISBN /10;
		int n1 = ISBN;
	 	 
	 	 boolean result =((n1*3)+(n2*2)+(n3*1))%4 == n4;
			return result;
		
		
	}
	public  void printBookInfo() {
		System.out.println("ISBN: "+this.ISBN);
		System.out.println("Author: "+this.author);
		System.out.println("Title: "+this.title);
		System.out.println("Genre: "+this.genre);

	}
	public boolean  equals(Book b) {
		return this.ISBN == b.ISBN;
		
	}
	
	

}
