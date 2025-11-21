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
    private String Tittle;
    private String author;
    private String Category;
    private String ISBN;
    //Constructor
    DataBase(String t,String a,String c,String ISBN){
     this.Tittle = t;
     this.author = a;
     this.Category = c;
     this.ISBN = ISBN;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Tittle: "+Tittle+", Author: "+author+", Category: "+Category+", ISBN: "+ISBN;
    }
}
class Library{
    HashMap<Integer,DataBase> dHashMap = new HashMap<>();
    private static final String Path = "Library.ser";
    private String Tittle;
    private String author;
    private String Category;
    private String ISBN;
    private int id;
       Library(){
          loadData();
       }
       public void toAdd(String t,String a,String C,String I,int id){
             this.Tittle = t;
             this.author = a;
             this.Category = C;
             this.ISBN = I;
             this.id = id;
                  dHashMap.put(id, new DataBase(Tittle, author, Category, ISBN));
                  save();
       }
       public void save(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Path))) {
            oos.writeObject(dHashMap);
            oos.close();
            System.out.println("succesfully saved");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
       }
       public void loadData(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Path))) {
             dHashMap = (HashMap<Integer,DataBase>) ois.readObject();
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
       }
       public void DeleteAllDetail(){
             Iterator<Map.Entry<Integer,DataBase>> itr = dHashMap.entrySet().iterator();
             while(itr.hasNext()){
                 Map.Entry<Integer, DataBase> entry = itr.next();
                 if(someCondition(entry)) itr.remove();
             }
             save();
       }
       private boolean someCondition(Entry<Integer,DataBase> entry) {
        // Example: delete entries where key > 5
                return entry.getKey() > 5;
       }
}
public class Librarymanagementsystem {
    public static void main(String[] args) {
          Library l = new Library();
          Scanner sc = new Scanner(System.in);
        //   l.toAdd("Harry potter", "Kulshingh", "StoryTeller", "123456", 1);
          l.Display();
          System.out.println("Type 1 to delete all detail: ");
          int num = sc.nextInt();
          switch (num) {
            case 1:
                l.DeleteAllDetail();
                break;
          
            default:
                break;
          }
    } 
}
