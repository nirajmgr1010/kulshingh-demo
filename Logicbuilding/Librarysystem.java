/*8️⃣ Library System
Composition
WAP:
Class Book
Class Library
Library has multiple books
Add book
Display all books
(Practice ArrayList + Composition.) */


import java.util.ArrayList;
import java.util.Scanner;

class Library{
    private String Book;
    Library(String Book){
        this.Book = Book;
    }
    @Override
    public String toString(){
        return Book;
    }

}
class Book{
    ArrayList<Library> library = new ArrayList<>();
    public void toAdd(String book){
        library.add(new Library(book));
    }
    public void Display(){
        for(Library s: library){
            System.out.println("Book name is : " +s);
        }
    }
}
public class Librarysystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         Book b = new Book();
         System.out.println("Enter a no how many You want to insert a book: ");
         int num = sc.nextInt();
         int count = 0;
         sc.nextLine();
         while (count<num) {
            System.out.println("Enter a book name: ");
            String name = sc.nextLine();
            b.toAdd(name);
            count++;
         }
         b.Display();

    }
}
