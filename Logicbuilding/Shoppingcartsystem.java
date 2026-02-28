/*
9️⃣ Shopping Cart System
WAP:
Class Product
Class Cart
Add product to cart
Calculate total price
Remove product */

import java.util.ArrayList;
import java.util.Scanner;

class Product{
    private String name;
    private int price;
    Product(String name , int price){
     this.name = name;
     this.price = price;
    }
    public int price(){
        return price;
    }
    @Override
    public String toString() {
        return "Your Product Name is : "+name+ "- "+price+"$";
    }
}
class Cart{
    ArrayList<Product> products = new ArrayList<>();
    int totoalPrice;
    public void toAdd(String name, int price){
        products.add(new Product(name, price));
    }

    public int CalculatePrice(){
        totoalPrice = 0;
        for(Product p: products){
            totoalPrice += p.price();
        }
        return totoalPrice;
    }
    public void Display(){
        for(Product s: products){
            System.out.println(s);
        }
        System.out.println("The total price is : "+totoalPrice+"$");
    }

}
public class Shoppingcartsystem {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       Cart c = new Cart();
       boolean cond = true;
       
        while (cond) {
        System.out.println("Choose the product and add to cart: ");
        System.out.println("Type 1: Strawberry - 15$");
        System.out.println("Type 2: Mango - 10$");
        System.out.println("Type 3: Apple - 13$");
        System.out.println("Type 4: Guava - 8$");
        System.out.println("Type 5: for calculate the price");
        System.out.println("Type 6: Displaying the product ");
        System.out.println("Type 0: End to shopping ");
        int num = sc.nextInt();
         String name;
         int price;
        switch (num) {
            case 1:
                name = "Strawberry";
                price = 15;
                c.toAdd(name, price);
                break;
            case 2:
                name = "Mango";
                price = 10;
                c.toAdd(name, price);
            break;
            case 3:
                name = "Apple";
                price = 13;
                c.toAdd(name, price);
            break;
            case 4:
                name = "Guava";
                price = 8;
                c.toAdd(name, price);
            break;
            case 5:
                c.CalculatePrice();
                break;    
            case 6:
                c.Display();
                cond = false;
            break;
            case 0:
                cond = false;
                break;
            default:
                break;
        }
        }
    }
}
