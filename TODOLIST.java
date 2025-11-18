/*
 * 4	4. To-Do List: Use ArrayList to add, delete, and mark tasks complete.
 * 1. Add Task
Add simple tasks
Add task with priority (High/Medium/Low)
Add task with deadline date
Add task with category (Work, Study, Personal)
Store them in an ArrayList
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
import java.util.ArrayList;

import javax.print.attribute.standard.MediaSize.NA;

class Details implements Serializable{
         private static String FullName;
         private String TaskName;
         Details(String name,String task){
            FullName = name;
             this.TaskName = task;
         }
         public String GetName(){
            return FullName;
         }
         public String GetTask(){
            return TaskName;
         }
         @Override
         public String toString() {
         return "Fullname: "+FullName+"Task: "+TaskName;
         }

}
class Task{
   ArrayList<Details> details;
   private String FullName;
   private String Task;
   private static final String fullPath = "TODOLIST.ser";
   Task(){
      details = new ArrayList<>();
       load();
   }
   public void SetName(String Name,String task){
      this.FullName = Name;
      this.Task = task;
      toAdd();
   }
   private void toAdd(){
       details.add(new Details(FullName, Task));
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
    t.SetName("Kulshingh","Homework");
    t.SetName("bishal", "Do push up");
   } 
}
