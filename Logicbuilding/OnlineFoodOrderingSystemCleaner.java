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
       return name + " x" + quantity + " - Rs " + getPrice();
  }
      

}
// ----------------- Restaurant Class -----------------
class Restaurant {
    private String name = "RestroBar";

    // Return FoodItem object based on menu number
    public FoodItem getFoodItemByNumber(int itemNum, int quantity) {
        String foodName = "";
        double price = 0;

        switch (itemNum) {
            case 1 -> { foodName = "Momo"; price = 150; }
            case 2 -> { foodName = "Pizza"; price = 800; }
            case 3 -> { foodName = "Burger"; price = 250; }
            case 4 -> { foodName = "Coke"; price = 60; }
            case 5 -> { foodName = "Chowmein"; price = 200; }
            default -> {
                System.out.println("Invalid item number! Defaulting to Momo.");
                foodName = "Momo";
                price = 150;
            }
        }
        return new FoodItem(foodName, price, quantity);
    }

    // Display Menu
    public void displayMenu() {
        System.out.println("------ MENU ------");
        System.out.println("1. Momo        Rs 150");
        System.out.println("2. Pizza       Rs 800");
        System.out.println("3. Burger      Rs 250");
        System.out.println("4. Coke        Rs 60");
        System.out.println("5. Chowmein    Rs 200");
        System.out.println("------------------");
    }
}

// ----------------- Order Class -----------------
class Order {
    private ArrayList<FoodItem> orderItems = new ArrayList<>();

    // Add FoodItem to order
    public void addItem(FoodItem item) {
        orderItems.add(item);
        System.out.println(item + " added to your order.");
    }

    // Remove item by index
    public void removeItem(int index) {
        if (index >= 0 && index < orderItems.size()) {
            FoodItem removed = orderItems.remove(index);
            System.out.println(removed + " removed from your order.");
        } else {
            System.out.println("Invalid index!");
        }
    }

    // Calculate total dynamically
    public double calculateTotal() {
        double total = 0;
        for (FoodItem f : orderItems) {
            total += f.getPrice();
        }
        // Apply discount if total > 1000
        if (total > 1000.00) {
            total *= 0.90; // 10% discount
        }
        return total;
    }

    // Display current order
    public void displayOrder() {
        if (orderItems.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }

        System.out.println("------ Current Order ------");
        int i = 0;
        for (FoodItem f : orderItems) {
            System.out.println(i + ". " + f);
            i++;
        }
        System.out.println("---------------------------");
        System.out.println("Total price: Rs " + calculateTotal());
    }

    // Checkout
    public void checkout() {
        if (orderItems.isEmpty()) {
            System.out.println("No items in the order to checkout.");
            return;
        }

        System.out.println("------ Checkout ------");
        displayOrder(); // Show items and total
        System.out.println("Final bill: Rs " + calculateTotal());
        System.out.println("Thank you for ordering!");
        orderItems.clear(); // Clear order after checkout
    }
}

public class OnlineFoodOrderingSystemCleaner {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Order o = new Order();
        Restaurant r = new Restaurant();
        boolean cond = true;

        System.out.println("==============================");
        System.out.println("       Welcome to RestroBar       ");
        System.out.println("==============================");

        while (cond) {
            System.out.println("\n1. View Menu");
            System.out.println("2. Add Item to Order");
            System.out.println("3. Remove Item from Order");
            System.out.println("4. View Current Order");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int num = sc.nextInt();

            switch (num) {
                case 1 -> r.displayMenu();
                case 2 -> {
                    System.out.print("Enter item number: ");
                    int itemnum = sc.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    FoodItem item = r.getFoodItemByNumber(itemnum, quantity);
                    o.addItem(item);
                }
                case 3 -> {
                    o.displayOrder();
                    System.out.print("Enter index to remove: ");
                    int index = sc.nextInt();
                    o.removeItem(index);
                }
                case 4 -> o.displayOrder();
                case 5 -> o.checkout();
                case 6 -> {
                    cond = false;
                    System.out.println("Exiting... Thank you!");
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
        sc.close();
    }
}
