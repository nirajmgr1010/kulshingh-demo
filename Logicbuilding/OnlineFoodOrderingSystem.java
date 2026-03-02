/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Iterator;
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
   private int quantity;
  FoodItem(String name,double price,int quantity){
     this.name = name;
     this.price = price;
     this.quantity = quantity;
  }
  public double getPrice(){
      return price*quantity;
  }  
  public String toString(){
      return name+"   "+quantity+"    -"+price*quantity;
  }
      

}
class Restaurant{
    private String name;
    private double price;
    ArrayList<FoodItem> menu = new ArrayList<>();
    public void setFoodItem(int itemNum,int quantity){
        
        switch(itemNum){
            case 1:
            name = "Momo";
            price = 150;
            break;
            case 2:
            name = "Pizza";
            price = 800;
            break;
            case 3:
            name = "Burger";
            price = 250;
            break;
            case 4:
            name = "Coke";
            price = 60;
            break;
            case 5:
            name = "Chowmein";
            price = 200;
            break;
        }
        toAdd(name,price,quantity);
    } 
   
    private void toAdd(String name, double price, int quantity){
        menu.add(new FoodItem(name ,price,quantity));
    }
    
    public ArrayList<FoodItem> getListofFoodItem(){
       return menu;
    }

   }
class Order {
    private int quantity;
    private int itemNum;
    private double totalprice = 0;
    ArrayList<Order> order = new ArrayList<>();
    public void SetFun(int quantity, int itemNum,Restaurant r){
        this.quantity = quantity;
        this.itemNum = itemNum;
        r.setFoodItem(itemNum,quantity);
    }
    public void Display(Restaurant r){
        ArrayList<FoodItem> list = r.getListofFoodItem(); //Fetch the list from Restaurant
         System.out.println("------ Current Order ------");
        for(FoodItem l: list){
            System.out.println(l);
        }
        System.out.println("---------------------------");
        System.out.println("Total price is: "+totalprice);
    }
    public void Checkout(Restaurant r){
            ArrayList<FoodItem> list = r.getListofFoodItem(); //Fetch the list from Restaurant
            for(FoodItem f: list){
               totalprice += f.getPrice();
            }
            if(totalprice<1000){
               totalprice = totalprice * 0.90;
            }
         
    }

    public void removeItem(int index,Restaurant r){
           Iterator<FoodItem> it = r.menu.iterator();
           int ConCurrentIndex = 0;
           while (it.hasNext()) {
            it.next();
            if(ConCurrentIndex == index){
                it.remove();
                break;
            }
            ConCurrentIndex++;
           }
         System.out.println("Successfully removed");
    }
      
        
}
public class OnlineFoodOrderingSystem {
    public static void main (String[] args){
        
        Scanner sc = new Scanner(System.in);
        Order o = new Order();
        Restaurant r = new Restaurant();
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
                    System.out.println("Enter item number:");
                    int itemnum = sc.nextInt();
                    System.out.println("Enter quantity:");
                    int quantity = sc.nextInt();
                    o.SetFun(quantity, itemnum, r); // pass the same Restaurant object
                    
                break;
                case 3:
                    o.Display(r);
                    System.out.println("Type index no to remove items");
                    int index = sc.nextInt();
                    o.removeItem(index,r);

                break;
                case 4:
                  o.Display(r);
                break;
                case 5:
                    
                break;
                case 6:
                    cond = false;
                break;
                
                default:
                break;
                   
            }
        }
        
    }
}
