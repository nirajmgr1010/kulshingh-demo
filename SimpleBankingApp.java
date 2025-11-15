/*1	2. Simple Banking App: Use loops and conditionals to deposit/withdraw money.
 * 1.Deposit();
 * 2.Withdraw();
 * 3.CheckBalance();
 * 4.showmenu();
 * 5.login(); ->Ask for PIN/password before using bank
 * 6.transactionhistory();
 * 7.exit();
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
class CustomEception extends Exception{
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Error!!";
    }
}
class BankDetails implements Serializable{
  private static String AccountName;
  private static long AccountNO;
  private long Balance = 0;
  private LocalDateTime localDateTime;
  BankDetails(long b,String accountname,long AccountNO){
    this.Balance = b;
    this.AccountName = accountname;
    this.AccountNO = AccountNO;
    this.localDateTime = LocalDateTime.now();
  }
  public void SetBalance(){
    
  }
  public long Getbalance(){
    return Balance;
  }
  @Override
  public String toString() {
      // TODO Auto-generated method stub
      return "Account Name: "+AccountName+", Account NO: "+AccountNO+", Balance: "+Balance+", "+localDateTime;
  }
}
class NepalRastriyaBank{
    private Scanner sc = new Scanner(System.in);
    private static final String File_name = "BankOperation.ser";
    ArrayList<BankDetails> bankDetails = new ArrayList<>();
   private long Balance;
   private String name;
   private long No;
   NepalRastriyaBank(String Accountname,long AccountNO){
   this.name = Accountname;
   this.No = AccountNO;
   loadBalance();
   }
   private void toAdd(long amount){
          bankDetails.add(new BankDetails(amount,name,No));
         savebalance();
   }
  private void Deposit(long Balance){
        this.Balance = Balance;
        toAdd(Balance);
  }
  private void CheckBalance(){
    for(BankDetails b: bankDetails){
        System.out.println(b);
        // System.out.println(b.Getbalance());
    }
  }
  private void Withdraw(long amount){
      this.Balance = amount;
      long RemainingBalance;
      for(BankDetails w:bankDetails){
            RemainingBalance = w.Getbalance() - Balance;
              toAdd(RemainingBalance);
      }
  }
   //Serelization
   private void savebalance(){
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(File_name))) {
          oos.writeObject(bankDetails);
    } catch (Exception e) {
        // TODO: handle exception 
        System.out.println(e);
    }
   }

  //Deserelization
  private void loadBalance(){
    File file = new File(File_name);
    if(!file.exists()){
        return;
    }
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
        bankDetails  = (ArrayList<BankDetails>) ois.readObject();
    } catch (Exception e) {
        // TODO: handle exception
        System.out.println(e);
    }
  }
  public void ShowMenu(){
    boolean Check = true;
    while(Check){
    System.out.println("Choose to do operation:  ");
    System.out.println("Choose 1 - Deposit the Balance");
    System.out.println("Choose 2 - Withdraw the amount");
    System.out.println("Choose 3 - Check The Balance");
    System.out.println("Choose 4- Transaction history");
    System.out.println("Choose 7 - exit....");
    int num = sc.nextInt();
    switch (num) {
        case 1:
              System.out.println("Deposit the balance");
              long balance = sc.nextLong();
              Deposit(balance);
            break;
        case 2:
        System.out.println("Enter the amount to withdraw: ");
        long amount = sc.nextLong();
        Withdraw(amount);

        break;
        case 3:
            CheckBalance();
        break;
        case 4:
        break;
        case 5:
        break;
        case 6:
        break;
            case 7:
            Check = false;
            break;
        default:
        System.out.println("Sorry but it is not availaible");
            break;
    }
    }
  }
}
public class SimpleBankingApp {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        String fullName = "Kulshingh Rana Magar";
       long AccountNO = 8159800067l;
         NepalRastriyaBank  bank = new NepalRastriyaBank(fullName,AccountNO);
         System.out.println("Set your 4 Digit pin: ");
         int PIN = Integer.parseInt(sc.nextLine());
            System.out.println("Enter your 4 Digit pin");
        int Pin = Integer.parseInt(sc.nextLine());
                if(Pin==PIN){
                   bank.ShowMenu();
            }
            else{
                System.out.println("Enter correct Pin");
            }
    }
}
