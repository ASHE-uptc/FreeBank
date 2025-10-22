package Models;
import Models.Deposit;

public class CurrentAccount extends BankingAccount {
        private double CA_fixedCommision=800;

        public CurrentAccount(String bA_accountNumber, String bA_holder, double bA_balance, double cA_fixedCommision) {
            super(bA_accountNumber, bA_holder, bA_balance);
            CA_fixedCommision = cA_fixedCommision;
        }

        public double getCA_fixedCommision() {
            return CA_fixedCommision;
        }

        public void setCA_fixedCommision(double cA_fixedCommision) {
            CA_fixedCommision = cA_fixedCommision;
        }

        @Override
        public String toString() {
            return "Current Account" + "\nCommision:"+getCA_fixedCommision() + "\nAccount Number: "
                    + getBA_accountNumber() + "\nHolder:" + getBA_holder() + "\nBalance: "
                    + getBA_balance() + "\n_________________________________________";
        }
        
    public void calculateInterests(){

        double interests=CA_fixedCommision;
    }
    

}
