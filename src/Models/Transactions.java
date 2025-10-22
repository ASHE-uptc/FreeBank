package Models;

import java.time.LocalDate;

public abstract class Transactions {
    private BankingAccount TRA_bankingAccount;
    private LocalDate TRA_date;

    public Transactions(BankingAccount tRA_bankingAccount, double tRA_ammount, LocalDate tRA_date) {
        TRA_bankingAccount = tRA_bankingAccount;
        TRA_date = tRA_date;
    }

    public BankingAccount getTRA_bankingAccount() {
        return TRA_bankingAccount;
    }

    public void setTRA_bankingAccount(BankingAccount tRA_bankingAccount) {
        TRA_bankingAccount = tRA_bankingAccount;
    }

    public LocalDate getTRA_date() {
        return TRA_date;
    }

    public void setTRA_date(LocalDate tRA_date) {
        TRA_date = tRA_date;
    }

    @Override
    public String toString() {
        return "To string por defecto. Transactions [TRA_bankingAccount=" + TRA_bankingAccount+ ", TRA_date="
                + TRA_date + "]";
    }
}
