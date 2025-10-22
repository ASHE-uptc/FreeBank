package Models;

import java.time.LocalDate;

public class Withdraw extends Transactions {
    private double Wit_ammount;

    public Withdraw(BankingAccount tRA_bankingAccount, double tRA_ammount, LocalDate tRA_date, double wit_ammount) {
        super(tRA_bankingAccount, tRA_ammount, tRA_date);
        Wit_ammount = wit_ammount;
    }

    public double getWit_ammount() {
        return Wit_ammount;
    }

    public void setWit_ammount(double wit_ammount) {
        Wit_ammount = wit_ammount;
    }

    @Override
    public String toString() {
        return "Type: Withdraw \nAmmount: " + getWit_ammount() + "\nBanking Account: " + getTRA_bankingAccount()
                +"\nDate: " + getTRA_date() + "\n__________________";
    }

    public String depositToCSV(){
        BankingAccount account=getTRA_bankingAccount();
        return String.join(",",
        "Deposit",                              //Type: Deposit
        account.getBA_accountNumber(),                      //Account Number
        account.getBA_holder(),                             //Holder
        String.valueOf(account.getBA_balance()),            //Balance
        String.valueOf(getWit_ammount()),                   //Withdraw Ammount
        getTRA_date().toString()                            //Withdraw Date
        );
    }    


}
