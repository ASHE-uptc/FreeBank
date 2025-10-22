package Models;

public class BussinessAccount extends BankingAccount{
    private double BUS_withdrawLimit;

    public BussinessAccount(String bA_accountNumber, String bA_holder, double bA_balance, double bUS_withdrawLimit) {
        super(bA_accountNumber, bA_holder, bA_balance);
        BUS_withdrawLimit = bUS_withdrawLimit;
    }

    public double getBUS_withdrawLimit() {
        return BUS_withdrawLimit;
    }

    public void setBUS_withdrawLimit(double bUS_withdrawLimit) {
        BUS_withdrawLimit = bUS_withdrawLimit;
    }

    @Override
    public String toString() {
        return "Bussiness Account "+ "\nAccount Number: "
                + getBA_accountNumber() + "\nHolder:" + getBA_holder() + "\nBalance()=" + getBA_balance()
                +"\nWithdraw Limit: " + getBUS_withdrawLimit()+"\n______________________________________";
    }
    
    

}
