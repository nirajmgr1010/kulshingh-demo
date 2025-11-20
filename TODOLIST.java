/*
 * 4	4. To-Do List: Use ArrayList to add, delete, and mark tasks complete.
 * 1. Add Task
Ask: Task Name?                                       
Ask: Priority? (High/Med/Low)                         
Ask: Deadline Date?                                   
Ask: Category? (Work/Study/Personal)                  
Create Task Object                                    
Add to ArrayList                                      
2. View All Tasks
3. Delete a Task ->User enters task number → remove from ArrayList.
5. Edit Task Name -> Example: “Finish homework” → “Finish homework (Math)”
6. Clear All Tasks -> Remove everything from the list with one command.
7.7. Save Tasks to File (Optional but Easy) ->
8. Simple Search

 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.NA;

class Details implements Serializable{
         private String Taskname;
         private String Priority;
         private String Category;
         private String DeadlineDay;
         private LocalDateTime localDateTime;
         private int id;
         Details(String t,String p,String c,String d,int id){
            this.id = id;
             this.Taskname = t;
             this.Category = c;
             this.Priority = p;
             this.DeadlineDay = d;
             this.localDateTime = LocalDateTime.now();
         }
         // public String GetName(){
         //    return FullName;
         // }
         // public String GetTask(){
         //    return TaskName;
         // }
         public int GetId(){
            return id;
         }
         public String GetTaskName(){
            return Taskname;
         }
         public void SetTaskname(String task){
            this.Taskname = task;
         }
         public String GetPriority(){
            return Priority;
         }
         @Override
         public String toString() {
         return "ID : "+id+", TaskName: "+Taskname+", Priority: "+Priority+", Category: "+Category+", DeadlineDay: "+DeadlineDay+" "+localDateTime;
         }
}
class Task{
   ArrayList<Details> details;
   private int ID;
   private String Taskname;
   private String Priority;
   private String Category;
   private String DeadlineDay;
   private static final String fullPath = "TODOLIST.ser";
   private Scanner sc = new Scanner(System.in);
   Task(){
      details = new ArrayList<>();
       load();
   }
   public void SetName(int id,String task,String priority,String c,String d){
      this.ID = id;
       this.Taskname = task;
       this.Category = c;
       this.Priority = priority;
       this.DeadlineDay = d;
      toAdd();
   }
   private void toAdd(){
       details.add(new Details(Taskname,Priority,Category,DeadlineDay,ID));
      Save();
   }
   private void Save(){
     try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fullPath))) {
        oos.writeObject(details);
     } catch (Exception e) {
      // TODO: handle exception
      System.out.println(e);
     }
   }
   private void load(){
      File file = new File(fullPath);
      if(!file.exists()){
            System.out.println("File doesn't exist");
            return;
      }
         try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fullPath))) {
            details = (ArrayList<Details>) ois.readObject();
             
         } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
         }
   }
   public void DeleteTask(){
      for(Details d: details){
         System.out.println(d);
      }
      System.out.println("Enter id to delete selected task: ");
      int num = sc.nextInt();
      Iterator<Details> itr = details.iterator();
      while(itr.hasNext()){
         Details d = itr.next();
         if(d.GetId()==num){
            itr.remove();
            System.out.println("Successfully removed one task");
         }
      }
        Save();
   }
   public void Display(){
      for(Details d:details){
         System.out.println(d);
      }
   }
   public void ClearallTask(){
      Iterator<Details> itr = details.iterator();
               while(itr.hasNext()){
                  itr.next();
                  itr.remove();
                  System.out.println("Successfull remove all task");
               }
               Save();
   }
   public void EditTask(){
      Iterator<Details> itr = details.iterator();
      System.out.println("------All task-----");
      for(Details c: details){
         System.out.println(c);
      }
      System.out.println("Enter a task name: ");
      String taskName  = sc.nextLine();
         while(itr.hasNext()){
             Details d = itr.next();
              if(d.GetTaskName().equals(taskName)){
                 System.out.println("enter a new Taskname: ");
                 String newTaskname = sc.nextLine();
                 d.SetTaskname(newTaskname);
                 System.out.println("Successfully set new name");
                 return;
              }
              else{
               System.out.println("Task not found");
              }
         }
         Save();
   }
   public void SearchTask(){
      Iterator<Details> itr = details.iterator();
      System.out.println("Enter a id no to search the task: ");
      int value = sc.nextInt();
      while(itr.hasNext()){
         Details d = itr.next();
         if(d.GetId()==value){
            System.out.println(details.toString());
         }
         else{
         System.out.println("Not found..");
         }
      }
   }
    public void DisplayINOrder(){
      Collections.sort(details,new Comparator<Details>() {

         @Override
         public int compare(Details o1, Details o2) {
              return GetPriorityValue(o1.GetPriority())-GetPriorityValue(o2.GetPriority());
         }
          private int GetPriorityValue(String priority){
              switch (priority.toLowerCase()) {
               case "high":
                    return 1;
               case "medium":
                     return 2;
                     case "low":
                        return 3;
               default:
                  System.out.println("Sorry it not found");
                  break;
              }
              return 99;
    }
      });
      System.out.println("Task shorted by priority...");
      for(Details d: details){
         System.out.println(d);
      }
    }
}
public class TODOLIST {
   public static void main(String[] args) {
    Task t = new Task();
    Scanner sc = new Scanner(System.in);
   // System.out.println("Enter a how many students you want to enter details");
   // int num = sc.nextInt();
   //  while(num>0){
   //  System.out.println("Enter Your Name: ");
   //  String name = sc.nextLine();
   //  sc.nextLine();
   //  System.out.println("Enter your Task Name: ");
   //  String taskNname = sc.nextLine();
   //  t.SetName(name, taskNname);
   //  num--;
   //  }
   boolean choice = true;
   while(choice){
   System.out.println("Enter any number to choose choice ->");
   System.out.println("1.Add a Task");  //Completed
   System.out.println("2. View Task"); //Completed
   System.out.println("3. Delete Task"); //Completed
   System.out.println("4. Edit Task");//Completed
   System.out.println("5. Search task");//Completed
   System.out.println("6.clear all task");//Completed
   System.out.println("7.Display in order of prirites");
   System.out.println("8. Exit....");//Completed
   int num = sc.nextInt();
   sc.nextLine();
   switch (num) {
      case 1:
         System.out.println("Enter you task name: ");
         String taskNname = sc.nextLine();
         
          System.out.println("Type task priority between high-medium-low type correct -> ");
          String Priority = sc.nextLine();
          System.out.println("Enter category ->");
          String Category = sc.nextLine();
          System.out.println("Enter deadline Date on Day");
          String Day = sc.nextLine();
          sc.nextInt();
          System.out.println("Enter id: ");
          int id = sc.nextInt();
            t.SetName(id,taskNname,Priority,Category,Day);
         break;

         case 2:
         t.Display();
         break;
         case 3:
              t.DeleteTask();
            break;
            case 4:
                 t.EditTask();
               break;
               case 5:
                  t.SearchTask();
               break;
         case 6:
            t.ClearallTask();
            break;
            case 7:
               t.DisplayINOrder();
               break;
            case 8:
               choice =false;
               break;
      default:
         break;
   }
   }
   } 
}
