package Models;

import java.time.LocalDate;

public class Deposit extends Transactions{
    private double Dep_ammount;

    public Deposit(BankingAccount tRA_bankingAccount, double tRA_ammount, LocalDate tRA_date, double dep_ammount) {
        super(tRA_bankingAccount, tRA_ammount, tRA_date);
        Dep_ammount = dep_ammount;
    }

    public double getDep_ammount() {
        return Dep_ammount;
    }

    public void setDep_ammount(double dep_ammount) {
        Dep_ammount = dep_ammount;
    }

    @Override
    public String toString() {
        return "\nType: Deposit \nAmmount: " + getDep_ammount() + "\nBanking Account: " + getTRA_bankingAccount()
                + "\nDate:" + getTRA_date() + "\n______________________";
    }

    public String depositToCSV(){
        BankingAccount account=getTRA_bankingAccount();
        return String.join(",",
        "Deposit",                              //Type: Deposit
        account.getBA_accountNumber(),                      //Account Number
        account.getBA_holder(),                             //Holder
        String.valueOf(account.getBA_balance()),            //Balance
        String.valueOf(getDep_ammount()),                   //Deposit Ammount
        getTRA_date().toString()                            //Deposit Date
        );
    } 
    
    public double calculateInterests(){
        double interests=getDep_ammount()-(getDep_ammount()*0.7);
        return interests;
    }
}
