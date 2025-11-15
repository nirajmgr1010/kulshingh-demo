/*
 * 1. Hello World & Calculator: Start with basic input/output and arithmetic operations
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

class NegativeNum extends Exception{
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Arithmetic Exception error ! / By Zero";
    }
}
class OperationRecord implements Serializable{
        private String OperationName;
        private int OperandA;
        private int OperandB;
        private LocalDateTime timestamp;
   public OperationRecord(String OperationName,int OperandA,int OperandB){
     this.OperationName = OperationName;
     this.OperandA = OperandA;
     this.OperandB = OperandB;
     this.timestamp = LocalDateTime.now();
   }
   public String GetOperationName(){return OperationName;}
   public int GetOperandA(){ return OperandA; }
   public int GetOperandB(){return OperandB;}
   
   @Override
   public String toString() {
   // TODO Auto-generated method stub
   return "The "+OperationName+", A: "+OperandA+", B: "+OperandB+" ,"+timestamp;
   }
}
class Calculator{
    private ArrayList<OperationRecord> operationRecords = new ArrayList<>();
    private static final String FIle_Name = "Operations.ser";
    //Add,Substraction,Multiplication,Division,Remainder
    private int numA;
    private int numB;
    public Calculator(){
         loadRecords();
    }
    public void SetA(int a){
            this.numA = a;
    }
    public void SetB(int b){
        this.numB =b;
    }
    public int GetA(){
        return numA;
    }
    public int GetB(){
        return numB;
    }
    private void addRecord(String name){
        operationRecords.add(new OperationRecord(name, numB, numA));
        saveRecords();
    }
    public void Addition(){
         int result = GetA() + GetB();
         System.out.println("The additon value is : "+result);
         addRecord("Addition");
    }
    public void Substraction(){
         int result = GetA() - GetB();
         System.out.println("The substraction value is :"+result);
         addRecord("Substractrion");
    }
    public void Multiplication(){
       int result = GetA() * GetB();
       System.out.println("The multiplication value is :"+result);
       addRecord("Multiplication");
    }
    public void Division() throws NegativeNum{
        if(GetB() == 0){
            throw new NegativeNum();
        }
        int result = GetA() / GetB();
        System.out.println("The Division value is :"+result);
        addRecord("Division");
    }
    public void Remainder() throws NegativeNum{
         if(GetB() == 0){
            throw new NegativeNum();
         }
         int result = GetA() % GetB();
         System.out.println("The remainder value is :"+result);
         addRecord("Remainder");
    }
    //Serilization
   public void saveRecords(){
    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FIle_Name))){
             oos.writeObject(operationRecords);
    }
    catch(Exception e){
        System.out.println(e);
    }
   }

   //Deserilization
    public void loadRecords(){
        File file = new File(FIle_Name);
        if(!file.exists()){return;}
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FIle_Name))) {
                 operationRecords = (ArrayList<OperationRecord>) ois.readObject();
             } catch (Exception e) {
                System.out.println("Error loading history: "+e.getMessage());
            }
    }

    //Show history
    public void Showhistory(){
        if(operationRecords.isEmpty()){
            System.out.println("Data it empty");
            return;
        }
         System.out.println("\n===== Operation History =====");
        for(OperationRecord o: operationRecords){
            System.out.println(o);
        }
    }
}
public class HelloCalculator{
public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int numA;
    int numB;
    boolean Check = true;
     Calculator c = new Calculator();
while(Check){
     System.out.println("Choose the opertion...");
     System.out.println("Choose 1 - Addition");
     System.out.println("Choose 2 - Substraction");
    System.out.println("Choose 3 - Multiplication");
     System.out.println("Choose 4 - Division");
   System.out.println("Choose 5 - Remainder"); 
   System.out.println("Choose 6 - Show history..");
   System.out.println("Choose 7 - Exit.....");
   int num = sc.nextInt();
 switch (num) {
    case 1:
        System.out.println("Enter the value of A: ");
         numA = sc.nextInt();
        System.out.println("Enter the value of B: ");
         numB = sc.nextInt();
        c.SetA(numA);
        c.SetB(numB);
        c.Addition();
        break;
     case 2:
        System.out.println("Enter the value of A: ");
        numA  = sc.nextInt();
        System.out.println("Enter the value of B: ");
         numB = sc.nextInt();
        c.SetA(numA);
        c.SetB(numB);
        c.Substraction();
        break;
    case 3:
        System.out.println("Enter the value of A: ");
        numA = sc.nextInt();
        System.out.println("Enter the value of B: ");
        numB = sc.nextInt();
        c.SetA(numA);
        c.SetB(numB);
        c.Multiplication();
    break;
     case 4:
    try{
        System.out.println("Enter the value of A: ");
        numA = sc.nextInt();
        System.out.println("Enter the value of B: ");
        numB = sc.nextInt();
        c.SetA(numA);
        c.SetB(numB);
        c.Division();
    }
    catch(NegativeNum e){
        System.out.println(e);
    }
    break;
     case 5:
    try{
        System.out.println("Enter the value of A: ");
        numA = sc.nextInt();
        System.out.println("Enter the value of B: ");
        numB = sc.nextInt();
        c.SetA(numA);
        c.SetB(numB);
        c.Remainder();
    }
    catch(NegativeNum e){
        System.out.println(e);
    }
    break;
    case 6:
      c.Showhistory();
    break;
    case 7:
      Check = false;
    break;
    default:
    System.out.println("Out of number....");
        break;
   }
    }
}
}