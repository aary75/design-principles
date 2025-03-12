//Creating the class LibraryBooks to find which books added in library
import java.util.Scanner;
import java.util.ArrayList;

// Create an independent class Book
class Book{
    
    // Fields (Atrributes)
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author){
         this.title = title;
         this.author = author;
    }

    // Displaying the author and title
    public void display(){
        System.out.println("Book " + title + " by author " + author);
    }

    // getters
    public String getTitle(){
        return title;
    }

    public String getAuthor(){
       return author;
    }
}

// Create a dependent class Library
class Library{
      
     // Fields(Attributes)
     private String name;
     private ArrayList<Book> books;

     // Constructor
     public Library(String name){
           this.name = name;
           this.books = new ArrayList<>();
     }

    // adding books in library
    public void addBook(Book book){
         books.add(book);
    }

    // Display all book details present in library
    public void displayLibrary(){
        System.out.println("Library: " + name);
        if(books.isEmpty()){
            System.out.print("No books in library.");
         }
        else{
           for(Book book : books){
             book.display();
            }
        }
    }
}

// Main class
public class LibraryBooks{
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in); // scanner class to get user's input

       String space = "true";

       while(space.equals("true")){
           
           System.out.print("Title: ");
           String title = scanner.nextLine();

          System.out.print("Author: ");
          String author = scanner.nextLine();

         // Creating book (independent object)
         Book book1 = new Book(title, author);

         System.out.print("Library Name: ");
         String libraryName = scanner.nextLine();

        // Create library object
        Library library1 = new Library(libraryName);

        // adding books in library
        library1.addBook(book1);

       // displaying the details of book
       library1.displayLibrary();

       System.out.print("Do you want to add more books(true/false): ");
       space = scanner.nextLine();
    }
}
}
        
// Input: 
// Title: Godan
// Author: Premchand
//Library Name: Public Library

// Output:
// Library: Public Library
// Book Godan by author Premchand
// Do you want to add more books(true/false): true

// Input:
// Title: Gaban
// Author: Premchand
// Library Name: Public Library

// Output:
// Library: Public Library
// Book Gaban by author Premchand
// Do you want to add more books(true/false): false
