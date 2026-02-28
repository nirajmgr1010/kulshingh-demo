/*🔹 1. Student Management System (Console Based)
⭐ Most Recommended
Features
Add student
View all students
Search student by roll number
Delete student
Store data using ArrayList */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class StudentRecord implements Serializable{

    private String StudentName;
    private int rollno;
    private int age;
    StudentRecord(String name, int roll, int age){
       this.StudentName = name;
       this.rollno = roll;
       this.age=age;
    }
    public int id(){
        return rollno;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Name: "+StudentName+"Roll.No: "+rollno+"Age: "+age;
    }
}
class Management{
    ArrayList<StudentRecord> records = new ArrayList<>();
    private static final String FIle_Name = "Studentdata.ser";
    private Scanner sc = new Scanner(System.in);
    private String name;
    private int roll;
    private int age;
    Management(){
        load();
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
     public void setRoll(int roll){
        this.roll = roll;
    }
    public int getRoll(){
        return roll;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void AddStudent(){
        records.add(new StudentRecord(name, roll, age));
        saveRecords();
    }
     
    public void DeleteById(){
        System.out.println("-------Student details--------");
        for(StudentRecord s : records){
            System.out.println(s);
        }
         System.out.println("Enter a roll no to delete student");
         int id = sc.nextInt();
         Iterator<StudentRecord> itr = records.iterator();
         while(itr.hasNext()){
            StudentRecord r = itr.next();
            if(r.id()==id){
                itr.remove();
                System.out.println("Successfully remove one student data");
            }
         }
         saveRecords();
         
    }

    private void saveRecords(){
     try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FIle_Name))) {
         oos.writeObject(records);
     } catch (Exception e) {
        System.out.println(e);
     }
    }

    private void load(){
      File file = new File(FIle_Name);
      if(!file.exists()){return;}
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FIle_Name))) {
                 records = (ArrayList<StudentRecord>) ois.readObject();
             } catch (Exception e) {
                System.out.println("Error loading history: "+e.getMessage());
            }
    }
    public void Display(){
    if(records.isEmpty())
    { 
      System.err.println("The data is not here!!");  
    }
      for(StudentRecord s: records){
           System.out.println(s);
      }
}
}
public class studentmanpr {
    public static void main(String[] args) {
        Management m = new Management();
        m.setName("Kulshingh");
        m.setAge(20);
        m.setRoll(1);
        // m.AddStudent();
        m.DeleteById();
        m.Display();
    }
}

