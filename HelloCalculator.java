/*
 * 1. Hello World & Calculator: Start with basic input/output and arithmetic operations
 */

import java.io.Serializable;
import java.util.Set;

class NegativeNum extends Exception{
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Negative Number error !";
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

    }
    public void Substraction(){

    }
    public void Multiplication(){

    }
    public void Division(){

    }
    public void Remainder(){
        
    }
}
public class HelloCalculator{
public static void main(String[] args) {
    
}
}