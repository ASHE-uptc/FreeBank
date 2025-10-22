package Models;

public class SavingsAccount extends BankingAccount{
    private double SA_monthlyInterests=(0.7*BA_balance);

    public SavingsAccount(String bA_accountNumber, String bA_holder, double bA_balance, double sA_monthlyInterests) {
        super(bA_accountNumber, bA_holder, bA_balance);
        SA_monthlyInterests = sA_monthlyInterests;
    }

    public double getSA_monthlyInterests() {
        return SA_monthlyInterests;
    }

    public void setSA_monthlyInterests(double sA_monthlyInterests) {
        SA_monthlyInterests = sA_monthlyInterests;
    }

    @Override
    public String toString() {
        return "Savings Account" + "\nAccount Number: "
                + getBA_accountNumber() + "\nHolder: " + getBA_holder() + "\nBalance: " + getBA_balance()
                + "\nMonthly Interests: " + getSA_monthlyInterests()+"\n_________________________________________";
    }

    public void calculateInterests(){
        double interests=getBA_balance()+getSA_monthlyInterests();
        System.out.println(interests);
    }
}
