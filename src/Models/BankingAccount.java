package Models;

import java.util.Scanner;

/**This is an abstrat class named BankingAccount that makes the model to the other types of accounts.
 * 
 */

public abstract class BankingAccount {

    protected String BA_accountNumber;
    protected String BA_holder;
    protected double BA_balance=5900000;
    

    public BankingAccount(String bA_accountNumber, String bA_holder, double bA_balance) {
        BA_accountNumber = bA_accountNumber;
        BA_holder = bA_holder;
        BA_balance = bA_balance;
    }

    public String getBA_accountNumber() {
        return BA_accountNumber;
    }

    public void setBA_accountNumber(String bA_accountNumber) {
        BA_accountNumber = bA_accountNumber;
    }

    public String getBA_holder() {
        return BA_holder;
    }

    public void setBA_holder(String bA_holder) {
        BA_holder = bA_holder;
    }

    public double getBA_balance() {
        return BA_balance;
    }

    public void setBA_balance(double bA_balance) {
        BA_balance = bA_balance;
    }

    @Override
    public String toString() {
        return "BankingAccount [BA_accountNumber=" + BA_accountNumber + ", BA_holder=" + BA_holder + ", BA_balance="
                + BA_balance + "]";
    }

    
    public double deposit(){
        Scanner ent=new Scanner(System.in);
        System.out.println("How much do you want to deposit?");
        double deposit=ent.nextDouble();

        deposit=getBA_balance()+deposit;

        System.out.println("The new balance is:");
        return deposit;
    }

    public double whitdraw(){
        Scanner ent=new Scanner(System.in);
        System.out.println("How much do you want to whitdraw?");
        double withdraw=ent.nextDouble();

        withdraw=getBA_balance()-withdraw;

        System.out.println("The new balance is:");
        return withdraw;
    }
  

}
