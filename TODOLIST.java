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
import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.NA;

class Details implements Serializable{
         private String Taskname;
         private String Priority;
         private String Category;
         private String DeadlineDay;
         private LocalDateTime localDateTime;
         Details(String t,String p,String c,String d){
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
         @Override
         public String toString() {
         return "TaskName: "+Taskname+", Priority: "+Priority+", Category: "+Category+", DeadlineDay: "+DeadlineDay+" "+localDateTime;
         }
}
class Task{
   ArrayList<Details> details;
   private String Taskname;
   private String Priority;
   private String Category;
   private String DeadlineDay;
   private static final String fullPath = "TODOLIST.ser";
   Task(){
      details = new ArrayList<>();
       load();
   }
   public void SetName(String task,String priority,String c,String d){
       this.Taskname = task;
       this.Category = c;
       this.Priority = priority;
       this.DeadlineDay = d;
      toAdd();
   }
   private void toAdd(){
       details.add(new Details(Taskname,Priority,Category,DeadlineDay));
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
   public void Display(){
      for(Details d:details){
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
   System.out.println("Enter any number to choose choice ->");
   System.out.println("1.Add a Task");
   System.out.println("2. View Task");
   System.out.println("3. Delete Task");
   System.out.println("4. Mark Complete");
   System.out.println("5. Edit Task");
   System.out.println("6. Clear all Task");
   System.out.println("7. Save to file");
   System.out.println("8. Search task");
   System.out.println("9. Exit....");
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
            t.SetName(taskNname,Priority,Category,Day);
         break;
      
         case 2:
         t.Display();
         break;
      default:
         break;
   }
   } 
}
