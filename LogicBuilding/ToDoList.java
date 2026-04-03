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
import java.util.Iterator;
import java.util.Scanner;

class Task implements Serializable{
   private int id;
   private String name,description;
   String Status;

   Task(int id, String name, String description,String Status){
       this.id = id;
       this.name = name;
       this.description = description;
       this.Status = Status;
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

   public void SetAssigned(String S){
           this.Status = S;
   }

   public String GetAssigned(){
    return Status;
   }

   @Override
   public String toString() {
       return "Task Id: "+id+" Task Name: "+name+" Description: "+description+"Task Assigned : "+Status;
   }
    
}
class Employee implements Serializable{
     private int id,age;
     private String name;
     Task taskAssigned;
     String Status;

     Employee(int id, int age, String name,String Status){
            this.id = id;
            this.age = age;
            this.name = name;
            this.Status = Status;
     }

     public int id(){
        return id;
     }
     public int age(){
        return age;
     }
     public String name(){
        return name;
     }
     public void SettaskAssigned(Task t,String Status){
         this.taskAssigned = t;
         this.Status = Status;

     }
     public Task taskAssigned(){
           return taskAssigned;
     }
     public String GetStatus(){
      return Status;
     }
     @Override
     public String toString() {
         return "Id: "+id+" Employee Name: "+name+" age: "+age+" Employee Assigned : "+Status;
     }
}

class ToDoListManagement{
      ArrayList<Task> task;
      ArrayList<Employee> employees;
      private static final String File_Name1 = "Task.ser";
      private static final String File_Name2 = "Employee.ser";
      ToDoListManagement(){
        task = new ArrayList<>();
        employees = new ArrayList<>();
        loadTask();
        loadEmployee();
      }

      public void AddTask(int id,String name, String discription){
        task.add(new Task(id, name, discription,"Not Assigned"));
        saveTask();
      } 
      public void AddEmployee(int id,String name, int age){
        employees.add(new Employee(id, age, name,"Not Assigned"));
        saveEmployee();
      }

      public void assignedTask(int empId, int taskId){
          Employee emp = null;
          Task t = null;
          for(Employee e: employees){
            if(e.id() == empId){
                emp = e;
                break;
            }
          }

          for(Task T : task){
             if(T.id() == taskId){
                t = T;
                break;
             }
          }

          if(emp != null && t != null){
            emp.SettaskAssigned(t,"Assigned");
            t.SetAssigned("Assigned");
            System.out.println("Task Assigned Successfully");
          }
          else{
            System.out.println("Invalid Employee ID or Task ID");
          }
          saveEmployee();
          saveTask();
      }

      public void Display(){
        System.out.println("--- Employees details ---");
        for(Employee e: employees){
          System.out.println(e);
        }

        System.out.println("--- Task details ---");
        for(Task t: task){
               System.out.println(t);
        }
      }
      private void saveTask(){
         try (BufferedWriter writer = new BufferedWriter(new FileWriter(File_Name1))) {
            for(Task t : task){
                writer.write(t.id()+ "," +t.name()+"," +t.Description()+"," +t.GetAssigned());
                writer.newLine();
            }
         } catch (Exception e) {
           System.out.println(e);
         }
      }
      private void loadTask(){
      File file = new File(File_Name1);
      if(!file.exists()){
        return;
      }
      try (BufferedReader reader = new BufferedReader(new FileReader(File_Name1))) {
        String line;
        while((line = reader.readLine()) != null){
            String[] data = line.split(",");
            int id = Integer.parseInt(data[0]);
            String TaskName = data[1];
            String description = data[2];
            String status = data[3];

            Task t = new Task(id, TaskName, description,status);
            task.add(t);
        }
      } catch (Exception e) {
         System.out.println(e);
      }
      }
      private void saveEmployee(){
         try (BufferedWriter writer = new BufferedWriter(new FileWriter(File_Name2))) {
              for(Employee e : employees){
                writer.write(e.id()+","+e.name()+","+e.age()+","+
                (e.taskAssigned() != null ? e.taskAssigned().id() : -1)+","+e.GetStatus());
                writer.newLine();
              }
         } catch (Exception e) {
             System.out.println(e);
         }
      }
      private void loadEmployee(){
         File file = new File(File_Name2);
         if(!file.exists()){
           return;
         }
        try (BufferedReader reader = new BufferedReader(new FileReader(File_Name2))) {
            String line;
            while((line = reader.readLine()) != null){
               String[] data = line.split(",");
               int id = Integer.parseInt(data[0]);
               String name = data[1];
               int age = Integer.parseInt(data[2]);
               int taskId = Integer.parseInt(data[3]);
               String Status = data[4];

               Employee e = new Employee(taskId, age, name,Status);
               Task assignedTask = null;
               for(Task t : task){
                if(t.id() == taskId){
                   e.SettaskAssigned(t,Status);
                    break;
                }
               }
             
               employees.add(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
      }

      public void DeleteEmployeeById(int Eid){
        boolean cond = false;
          Iterator<Employee> e = employees.iterator();
          while (e.hasNext()) {
            Employee E = e.next();
            if(Eid == E.id()){
              e.remove();
              cond = true;
              break;
            }
          }
          if(!cond){
            System.out.println("Sorry Employeee is not found");
          }
          else{
            System.out.println("Successfully deleted Employee details");
          }
      }
      public void DeleteTaskByID(int Tid){
             boolean cond = false;
             Iterator<Task> t = task.iterator();
             while (t.hasNext()) {
              Task T = t.next();
              if(Tid == T.id()){
                t.remove();
                cond = true;
                break;
              }
             }
            if(!cond){
            System.out.println("Sorry Task is not found");
          }
          else{
            System.out.println("Successfully deleted Task details");
          }
      }

      public void DeleteAllEmployee(){
        employees.clear();
        saveEmployee();
      }
      public void DeleteAllTask(){
        task.clear();
        saveTask();
      }
}

public class ToDoList {
    public static void main(String[] args) {
        ToDoListManagement Management = new ToDoListManagement();
         Scanner sc = new Scanner(System.in);
         int Eid,age,Tid;
         String name,description;

           while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Add Task");
            System.out.println("3. Assigned the Task to Employee");
            System.out.println("4. Display");
            System.out.println("5. DeleteALL Employee");
            System.out.println("6. DeleteALl Task");
            System.out.println("7. Delete Employee by Id");
            System.out.println("8. Delete Task by Id");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                  System.out.println("Enter id: ");
                  Eid = sc.nextInt();
                  sc.nextLine();
                  System.out.println("Enter name: ");
                  name = sc.nextLine();
                  System.out.println("Enter age: ");
                  age = sc.nextInt();
                  Management.AddEmployee(Eid, name, age);
                  break;
                }
                case 2 -> {
                  System.out.println("Enter id: ");
                  Tid = sc.nextInt();
                  sc.nextLine();
                  System.out.println("Enter task Name: ");
                  name = sc.nextLine();
                  System.out.println("Enter a 10-20 words task desciption");
                  description = sc.nextLine();
                  Management.AddTask(Tid, name, description);
                  break;
                }
                case 3 -> {
                  System.out.println("Enter the task Id: ");
                  Tid = sc.nextInt();
                  System.out.println("Enter the Employee Id: ");
                  Eid = sc.nextInt();
                  Management.assignedTask(Eid, Tid);
                  break;
                }
                case 4 -> Management.Display();
                case 5 -> Management.DeleteAllEmployee();
                case 6 -> Management.DeleteAllTask();
                case 7 ->{
                  System.out.println("Enter Employee id to Delete: ");
                  Eid = sc.nextInt();
                  Management.DeleteEmployeeById(Eid);
                }
                case 8 ->{
                  System.out.println("Enter Task id to Delete: ");
                  Tid = sc.nextInt();
                  Management.DeleteTaskByID(Tid);
                }
                case 9 -> {
                    System.out.println("👋 Exiting... Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
