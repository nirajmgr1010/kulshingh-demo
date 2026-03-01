/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniproject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author acer
 */
/*
1️⃣ Online Food Ordering System
WAP:
Class FoodItem
Class Restaurant
Class Order
Add food items to order
Calculate total bill
Apply discount (if total > 1000)
Remove item from order
Show final bill
👉 Practice: Composition + Collections + Logic*/
class FoodItem{
   private String name;
   private double price;
  FoodItem(String name, double price){
       this.name = name;
       this.price = price;
  }
  public double getPrice(){
      return price;
  }
     public String toString(){
       return "Your order name is: "+name+"- "+price+"$";
     }
}
class Restaurant{
      ArrayList<FoodItem> foodItem = new ArrayList<>();
      private static final String name = "RestroBar";
      public void toAdd(String name, double price){
           foodItem.add(new FoodItem(name, price));
      }
      

}
class Order {
    
      
        
}
public class OnlineFoodOrderingSystem {
    public static void main (String[] args){
        
        Scanner sc = new Scanner(System.in);
        boolean cond = true;
         System.out.println("==============================\n");
         System.out.println("    Welcome to RestroBar      \n");
         System.out.println("==============================\n");
        while(cond){
            System.out.println("1. View Menu");
            System.out.println("2. Add Item to Order");
            System.out.println("3. Remove Item from Order");
            System.out.println("4. View Current Order");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            int num = sc.nextInt();
            switch(num){
                case 1:
                    System.out.println("------ MENU ------");
                    System.out.println("\n");
                    System.out.println("1. Momo        Rs 150");
                    System.out.println("2. Pizza       Rs 800");
                    System.out.println("3. Burger      Rs 250");
                    System.out.println("4. Coke        Rs 60");
                    System.out.println("5. Chowmein    Rs 200");
                break;
                case 2:
                break;
                case 3:
                break;
                case 4:
                break;
                case 5:
                break;
                case 6:
                break;
                   
            }
        }
        
    }
}
