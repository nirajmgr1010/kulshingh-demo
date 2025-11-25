/*
1. 📚 Library Management System (LMS)
✔ Add / View / Search Books
✔ Add / View Members
✔ Borrow Book
✔ Return Book
✔ Track Due Date & Fine
✔ Category-wise Book List
✔ Borrow History
✔ File Save & Load (Serialization)
✔ Custom Exceptions(BookNotFoundException|MemberNotFoundException|BookAlreadyBorrowedException)
✔ Simple Multithreading
✔ Admin Login */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.xml.crypto.Data;
class BookNotFoundException extends Exception{
      @Override
      public String toString() {
          // TODO Auto-generated method stub
          return "Book not found sorry!";
      }
}
class MemberNotFoundException extends Exception{
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Memeber not found sorry!";
    }
}
class BookAlreadyBorrowedException extends Exception{
           @Override
           public String toString() {
               // TODO Auto-generated method stub
               return "Book already borrowed sorry!";
           }
}
class DataBase implements Serializable{
    private String memberName;
    private String Tittle;
    private String author;
    private String Category;
    private String ISBN;
    //Constructor
    DataBase(String name,String t,String a,String c,String ISBN){
        this.memberName  = name;
     this.Tittle = t;
     this.author = a;
     this.Category = c;
     this.ISBN = ISBN;
    }
    public String membername(){
        return memberName;
    }
    public String BookName(){
        return Tittle;
    }
    @Override
    public String toString(){
        // TODO Auto-generated method stub
        return " Tittle: "+Tittle+", Author: "+author+", Category: "+Category+", ISBN: "+ISBN;
    }
}
class Library{
    HashMap<Integer,DataBase> dHashMap = new HashMap<>();
    ArrayList<DataBase> Book = new ArrayList<>();
    private static final String Path = "Library.ser";
    Scanner sc = new Scanner(System.in);
    private String memberName;
    private String Tittle;
    private String author;
    private String Category;
    private String ISBN;
    private int id;
       Library(){
          loadData();
       }
       public void toAdd(String name,String t,String a,String C,String I,int id){
             this.memberName = name;
             this.Tittle = t;
             this.author = a;
             this.Category = C;
             this.ISBN = I;
             this.id = id;
                  dHashMap.put(id, new DataBase(memberName,Tittle, author, Category, ISBN));
                  Book.add(new DataBase(memberName,Tittle,author,Category,ISBN));
                  save();
       }
       public void save(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Path))) {
            oos.writeObject(dHashMap);
            oos.writeObject(Book);
            System.out.println("succesfully saved");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
       }
       public void loadData(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Path))) {
             dHashMap = (HashMap<Integer,DataBase>) ois.readObject();
             Book = (ArrayList<DataBase>) ois.readObject();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
       }
       public void Display(){
      for (Map.Entry<Integer, DataBase> entry : dHashMap.entrySet()) {
    System.out.println("Key = " + entry.getKey());
    System.out.println("Value = " + entry.getValue());
    System.out.println("-------------------");
}
Iterator<DataBase> itr = Book.iterator();
     while(itr.hasNext()){
             DataBase d = itr.next();
             System.out.println(d);
     }
       }
       public void DeleteAllDetail(){
             Iterator<Map.Entry<Integer,DataBase>> itr = dHashMap.entrySet().iterator();
             while(itr.hasNext()){
                 Map.Entry<Integer, DataBase> entry = itr.next();
                 if(someCondition(entry)){
                    itr.remove();
                 } 
             }
             save();
       }
       private boolean someCondition(Entry<Integer,DataBase> entry) {
        // Example: delete entries where key > 5
                return entry.getKey() < 5;
       }
       public void displayMember(){
        Iterator<Map.Entry<Integer,DataBase>> itr = dHashMap.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<Integer,DataBase> entry = itr.next();
            System.out.println("Membername: "+ entry.getValue().membername());
            System.out.println("----------------");
        }
       }
       public void SearchBook(){
        System.out.println("Enter key value: ");
        int id = sc.nextInt();
        Iterator<Map.Entry<Integer,DataBase>> itr = dHashMap.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<Integer,DataBase> entry = itr.next();
            if(entry.getKey()==id){
                System.out.println("Key = " + entry.getKey());
                System.out.println("Value = " + entry.getValue());
                System.out.println("-------------------");
            }
            // else if(){

            // }
        }
       }
       public void BorrowBook(String BookName) throws BookAlreadyBorrowedException{
        Iterator<DataBase> itr = Book.iterator();
     while(itr.hasNext()){
             DataBase d = itr.next();
            if(BookName.equalsIgnoreCase(d.BookName())){
                   dHashMap.put(, d);
            }
            else{
                throw new BookAlreadyBorrowedException();
            }
     }
       }
}
public class Librarymanagementsystem {
    public static void main(String[] args) {
          Library l = new Library();
          Scanner sc = new Scanner(System.in);
        //   l.toAdd("Harry potter", "Kulshingh", "StoryTeller", "123456", 1);
        boolean check = true;
        while(check){
            System.out.println("Type 1 to add book details: ");
          System.out.println("Type 2 to delete all detail: ");
          System.out.println("Type 3 to search book: ");
          System.out.println("Type 4 to view All details :");
          System.out.println("Type 5 to display the member only");
          System.out.println("Type 6 to borrow the book");
          int num = sc.nextInt();
          switch (num) {
            case 1:
                System.out.println("Enter id no in integer : ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter a member Name: ");
                String name = sc.nextLine();
                System.out.println("Enter a book Tittle Name: ");
                String tittle = sc.nextLine();
                System.out.println("Enter a author name: ");
                String author = sc.nextLine();
                System.out.println("Enter a book category Name: ");
                String Category = sc.nextLine();
                System.out.println("Enter International Standard Book Number Atleast 10 Digit: Eg(0-123-45678-9) ");
                String ISBN = sc.nextLine();
                String Isbnresult = ISBN.substring(0,1)+"-"+
                                    ISBN.substring(1, 4)+"-"+
                                    ISBN.substring(4, 9)+"-"+
                                    ISBN.substring(9);
                l.toAdd(name,tittle, author, Category, Isbnresult, id);
                break;
            case 2:
                l.DeleteAllDetail();
                break;
                case 3:
                    l.SearchBook();
                    break;
                    case 4:
                        l.Display();
                        break;
                        case 5:
                            l.displayMember();
                            break;
                            case 6:
                                try{
                                   System.out.println("Enter a book name to borrow");
                                   String Book = sc.nextLine();
                                  l.BorrowBook(Book);
                                }
                                catch(BookAlreadyBorrowedException e){
                                          System.out.println(e);
                                          e.printStackTrace();
                                }
                                break;
            default:
         check = false;
                break;
          }
        }
    } 
}
