/*
1. Student Management System
Create a system to:
Add student (ID, name, marks)
Display all students
Search student by name
Save and load from file

for add student 
for exception handling
for save and load student data from file
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class MarkException extends Exception{
 @Override
 public String getMessage() {
     return "Enter valid mark between 0 to 100";
 }
}


class Student implements Serializable{
    int id;
    String name;
    double marks;
    Student(int id, String name, double mark){
            this.id = id;
            this.name = name;
            this.marks = mark;
    }
    public int id(){
        return id;
    }
    public String name(){
        return name;
    }
    public double mark(){
        return marks;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "ID: "+id+" Student: "+name+" TotalMarks:"+marks;
    }
}
class OpStudent{
  
    Scanner sc;
    ArrayList<Student> students;
    private static final String File_Name = "Student.txt";
    OpStudent(){
        students = new ArrayList<>();
        sc = new Scanner(System.in);
        load();
    }

    public double validateMarks(double marks) throws MarkException{
    if(marks<0 || marks > 100){
        throw new MarkException();
    }
    return marks;
}
    public void addStudent(){
        int i=1,id;
        String name;
        double English,Nepali,Computer,Science,Math,total;
        System.out.println("Type no how many you want to add Student : ");
        int num = sc.nextInt();
        while (i<=num) {
            System.out.println("Enter id: ");
            id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Student name: ");
            name = sc.nextLine();
            try{
            System.out.println("--- Enter Marks ---");
            System.out.println("English: ");
            English = validateMarks(sc.nextDouble());
            sc.nextLine();
            System.out.println("Nepali: ");
            Nepali = validateMarks(sc.nextDouble());
            sc.nextLine();
            System.out.println("Computer: ");
            Computer = validateMarks(sc.nextDouble());
            sc.nextLine();
            System.out.println("Science: ");
            Science = validateMarks(sc.nextDouble());
            sc.nextLine();  
            System.out.println("Math: ");
            Math = validateMarks(sc.nextDouble());

            total = Nepali + English + Computer + Science + Math;

            students.add(new Student(id, name, total));
            System.out.println("Successfully inserted ");
            Save();
            i++;
            }
            catch(MarkException e){
                  System.out.println(e.getMessage());
            }
        }

    }
    private void Save(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(File_Name))) {
            for(Student s: students){
              writer.write(s.id+","+s.name+","+s.marks);
              writer.newLine();
            }
            
        } catch (Exception e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }
    private void load(){
         File file = new File(File_Name);
         if(!file.exists()){
            return;
         }
         try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
             String line;
             while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double marks = Double.parseDouble(data[2]);

                Student student = new Student(id, name, marks);
                students.add(student);

             }
         } catch (Exception e) {
              System.out.println("Error Loading students: " + e.getMessage());
         }
    }


}
public class StudentManagementSystem {
    public static void main(String[] args) {
        
    }
}
