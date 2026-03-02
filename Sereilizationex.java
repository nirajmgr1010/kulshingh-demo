import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable{
    private String name;
    private int age;
    Person(String name,int age){
            this.name = name;
            this.age = age;
    }
    public String GetName(){
        return name;
    }
    public int GetAge(){
        return age;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Your Name is: "+name+"/n Your Age is : "+age;
    }
}
public class Sereilizationex {
     public static void main(String[] args) {
        Person p = new Person("Kulshingh", 20);
        String filepath = "Text.ser";
        //Serializable
        try{
            FileOutputStream fos = new FileOutputStream(filepath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(p); 
            System.out.println("Object has been serialized ");
        }
        catch(Exception e){
            System.out.println(e);
        }
        //Deserilizable 
        try{
            FileInputStream fis = new FileInputStream(filepath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person dp = (Person) ois.readObject();
            System.out.println(dp); 
        }
        catch(Exception e){
            System.out.println(e);
        }
     }
}
