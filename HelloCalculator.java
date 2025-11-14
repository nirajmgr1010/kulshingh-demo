/*
 * 1. Hello World & Calculator: Start with basic input/output and arithmetic operations
 */

import java.io.Serializable;
import java.time.LocalDateTime;
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
   public OperationRecord(String OperationName,int OperandA,int OperandB,LocalDateTime localDateTime){
     this.OperationName = OperationName;
     this.OperandA = OperandA;
     this.OperandB = OperandB;
     this.timestamp = localDateTime.now();
   }
   public String GetOperationName(){return OperationName;}
   public int GetOperandA(){ return OperandA; }
   public int GetOperandB(){return OperandB;}
   
   @Override
   public String toString() {
   // TODO Auto-generated method stub
   return "The"+OperationName+"A: "+OperandA+", B: "+OperandB+""+timestamp;
   }
}
class Calculator{
    //Add,Substraction,Multiplication,Division,Remainder
    private int numA;
    private int numB;
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
    public void Addition(){
         int result = GetA() + GetB();
         System.out.println("The additon value is : "+result);
    }
    public void Substraction(){
         int result = GetA() - GetB();
         System.out.println("The substraction value is :"+result);
    }
    public void Multiplication(){
       int result = GetA() * GetB();
       System.out.println("The multiplication value is :"+result);
    }
    public void Division() throws NegativeNum{
        if(GetB() == 0){
            throw new NegativeNum();
        }
        int result = GetA() / GetB();
        System.out.println("The Division value is :"+result);
    }
    public void Remainder() throws NegativeNum{
         if(GetB() == 0){
            throw new NegativeNum();
         }
         int result = GetA() % GetB();
         System.out.println("The remainder value is :"+result);
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
   System.out.println("Choose 6- Exit..");
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
      Check = false;
    break;
    default:
    System.out.println("Out of number....");
        break;
   }
    }
}
}