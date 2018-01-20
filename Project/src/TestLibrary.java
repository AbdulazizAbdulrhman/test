import java.util.Scanner;
public class TestLibrary {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Library a = new Library();
		int option=0;
		do {
			System.out.println("**********************************************************************");
			System.out.println("* Welcome to KSU Library :)");
			System.out.println("* ---------------------------");
			System.out.println("* Please enter one of the following options:");
		    System.out.println("* 1) Add a book");
		    System.out.println("* 2) Delete a book");
		    	System.out.println("* 3) Find a book");
		    	System.out.println("* 4) List all books");
		    	System.out.println("* 5) List books for a given genre");
		    	System.out.println("* 6) Number of books for a given author");
		    	System.out.println("* 7) Total number of books");
		    	System.out.println("* 8) Exit");
		    System.out.println("**********************************************************************");
		    System.out.print("Enter your option :>");
		    option = input.nextInt();
		    
		    if(option == 1) {
		    System.out.print("Please, enter the book details #ISBN, author, title, and genre");
		    int ISBN = input.nextInt();
		    String author = input.next();
		    String title = input.next();
		    String genre = input.next();
		    	if(Book.verifyISBN(ISBN)) {
		    		a.addBook(ISBN, author, title, genre);
		    		System.out.println("The book has been added.");
		    	}
		    	else
		    		System.out.println("The book hasn't been added.");
		    }
		    
		    if(option == 2) {
		    	System.out.print("Enter the ISBN of Book: ");
		    	
		    	if(a.deleteBook(input.nextInt()))
		    		System.out.println("the book has been deleted.");
		    	else
		    		System.out.println("the book hasn't been deleted.");

		    	
		    }
		    
		    if(option == 3) {
		    	System.out.print("Enter the ISBN of Book: ");
		    	int ISBN = input.nextInt();
		    	if(a.findBook(ISBN) != -1)
		    		a.printBookInfo(a.findBook(ISBN));
		    	else
		    		System.out.println("Book hasn't been found.");
		    		
		    }
		    		    
		    if(option == 4) {
		    	a.printAll();
		    }
		    

		    if(option == 5) {
		    	System.out.print("Enter genre name: ");
		    	String genre = input.next();
		    	a.printGenre(genre);
		    }
		    

		    if(option == 6) {
		    	System.out.print("Enter Author name: ");
				   System.out.println(a.getNumberOfBooksByAuthor(input.next()));
		    		
		    }
		    

		    if(option == 7) {
		    	System.out.println("the number of books is "+a.getNumberOfBooks());
		    	
		    }
		    
		    
			
		}while(option !=8);
		System.out.print("Thanks. Goodbye!");

	}

}
