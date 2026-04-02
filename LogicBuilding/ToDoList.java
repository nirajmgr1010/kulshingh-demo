/*
9. To-Do List Application
Create:
Add task (task ID, description, status)
Show all tasks
Mark task as completed
Save tasks in file
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;

class Task implements Serializable{
   private int id;
   private String name,description;

   Task(int id, String name, String description){
       this.id = id;
       this.name = name;
       this.description = description;
   }

   public int id(){
    return id;
   }
   public String name(){
    return name;
   }

   public String Description(){
    return description;
   }

   @Override
   public String toString() {
       return "Task Id: "+id+" Task Name: "+name+" Description: "+description;
   }
    
}
class Employee implements Serializable{
     private int id,age;
     private String name;
     Task taskAssigned;

     Employee(int id, int age, String name){
            this.id = id;
            this.age = age;
            this.name = name;
     }

     @Override
     public String toString() {
         return "Id: "+id+" Employee Name: "+name+" age: "+age;
     }
}

class ToDoListManagement{
      ArrayList<Task> task;
      ArrayList<Employee> employees;
      private static final String File_Name1 = "Employee.ser";
      private static final String File_Name2 = "Task.ser";
      ToDoListManagement(){
        task = new ArrayList<>();
        employees = new ArrayList<>();
        loadEmployee();
        loadTask();
      }


      public void saveTask(){
         try (BufferedWriter writer = new BufferedWriter(new FileWriter(File_Name1))) {
            for(Task t : task){
                writer.write(t.id()+ "," +t.name()+"," +t.Description());
                writer.newLine();
            }
         } catch (Exception e) {
           System.out.println(e);
         }
      }
      public void loadTask(){
      File file = new File(File_Name1);
      if(!file.exists()){
        return;
      }
      try (BufferedReader reader = new BufferedReader(new FileReader(File_Name1))) {
        String line;
        if((line = reader.readLine()) != null){
            String[] data = line.split(",");
            int id = Integer.parseInt(data[0]);
            String TaskName = data[1];
            String description = data[2];

            Task t = new Task(id, TaskName, description);
            task.add(t);
        }
      } catch (Exception e) {
         System.out.println(e);
      }
      }
      public void saveEmployee(){

      }
      public void loadEmployee(){

      }
}

public class ToDoList {
    public static void main(String[] args) {
        
    }
}
