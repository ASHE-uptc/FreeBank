import Models.*;
import View.*;
import Exceptions.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.event.InternalFrameAdapter;

import Controller.*;

//*This is the App Class that runs the program starting with the Main Menu. */

public class App {
    public static void main(String[] args) throws Exception {
        Scanner ent=new Scanner(System.in);
        List<Transactions> transactions=FilesLoader.LoadTransactions("transactions.txt");
        boolean exit=false;

        MainMenu menu=new MainMenu();
        

        while (exit!=true) {
            menu.showMainMenu();
            int optn=ent.nextInt();

            switch (optn) {
                case 1:
                    Boolean Excep=false;
                    ent.nextLine();
                    System.out.println("Please enter the following data of the Deposit:");

                    String anumber="";

                    while (!Excep) {
                    System.out.println("Account Number: ");
                    anumber=ent.nextLine();

                        try {
                            int num=Integer.parseInt(anumber);
                            if (num<=0){ 
                                System.out.println("Nuber Format Exception, Account Number Can't be negative or zero. Try Again");
                            }else {
                                Excep=true;
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Nuber Format Exception, Invalid Input. Try Again.");
                        }
                        }

                    String aholder="";
                    Excep=false;
                    while (!Excep) {
                        try {
                            System.out.println("Account Holder:");
                            aholder=ent.nextLine();
                            boolean test=Exceptions.verifyOnlyLetters(aholder);
                            if (test==false) {
                                System.out.println("Name Can't be a number.");
                            } else {
                                Excep=true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("The name it's too Big. Try Again.");
                        }    
                    }

                    Excep=false;
                    double withdrawAmmount=0;

                    while (!Excep) {
                        try {
                        System.out.println("How much do you want to deposit?");
                        withdrawAmmount=ent.nextDouble();
                        if (withdrawAmmount<=0) {
                            System.out.println("Please enter a valid ammount.");
                        } else {
                            Excep=true;
                        }
                        } catch (NumberFormatException e) {
                        System.out.println("Invalid Number Entered.");
                        }
                    }
             
                LocalDate aDate=LocalDate.now();
                Excep=false;
                int bankoptn=0;
            try {
                   while (!Excep) {
                       try {
                           System.out.println("Type of Banking Account:\n(1)Bussiness Account \n(2)Current Account \n(3)Savings Account");
                           bankoptn=ent.nextInt();
                           if (bankoptn<=0&&bankoptn>3) {
                               System.out.println("Please, enter a valid option.");
                           }else{
                               Excep=true;
                           }
                       } catch (InputMismatchException e) {
                           System.out.println("Invalid input, try again.");
                       }
                   }
                BankingAccount accType=null;
                    switch (bankoptn) {
                        case 1:
                        
                            accType=new BussinessAccount(anumber, aholder, withdrawAmmount, 150000);
                            System.out.println("Bussiness Account Selected!");
                            
                            break;
                        case 2:
                        
                            accType=new CurrentAccount(anumber, aholder, withdrawAmmount, bankoptn);
                            System.out.println("Current Account Selected!");
                            System.out.println("Interests: ");
                            
                            break;

                        case 3:
                            accType=new SavingsAccount(anumber, aholder, withdrawAmmount, bankoptn);
                            System.out.println("Savings Account Selected!");
                            
                            break;
                        default:
                        System.out.println("Please, select a valid option.");
                            break;
                    }

                    Deposit deposit=new Deposit(accType, withdrawAmmount, aDate, withdrawAmmount);
                    transactions.add(deposit);
                    TransactionFileManager.saveTransactionsToCSV(transactions, "transactions.txt");
                    System.out.println("Deposit added Successfully!");
                    System.out.println("This is your actual balance: "+(accType.getBA_balance()+deposit.getDep_ammount());

            } catch (Exception e) {
                System.out.println("Invalid Input Exception. Returning to Main Menu...");
            }
                    break;
                
                case 2:
                ent.nextLine();
                    System.out.println("Please enter the following data of the Deposit:");
                Excep=false;
                anumber="";                    
                while (!Excep) {
                    try {
                        System.out.println("Account Number: ");
                        anumber=ent.nextLine();
                            int num=Integer.parseInt(anumber);
                            if (num<=0){ 
                                System.out.println("Nuber Format Exception, Account Number Can't be negative or zero. Try Again");
                            }else {
                                Excep=true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Nuber Format Exception, Invalid Input. Try Again.");
                        }
                }
    
                    aholder="";
                    Excep=false;
                    while (!Excep) {
                        try {
                            System.out.println("Account Holder:");
                            aholder=ent.nextLine();
                            boolean test=Exceptions.verifyOnlyLetters(aholder);
                            if (test==false) {
                                System.out.println("Name Can't be a number.");
                            } else {
                                Excep=true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("The name it's too Big. Try Again.");
                        }    
                    }

                    Excep=false;
                    withdrawAmmount=0;

                    while (!Excep) {
                        try {
                        System.out.println("How much do you want to Withdraw?");
                        withdrawAmmount=ent.nextDouble();
                        if (withdrawAmmount<=0) {
                            System.out.println("Please enter a valid ammount.");
                        } else {
                            Excep=true;
                        }
                        } catch (NumberFormatException e) {
                        System.out.println("Invalid Number Entered.");
                        }
                    }
                    
                aDate=LocalDate.now();
                Excep=false;
                bankoptn=0;
            try {
                   while (!Excep) {
                       try {
                           System.out.println("Type of Banking Account:\n(1)Bussiness Account \n(2)Current Account \n(3)Savings Account");
                           bankoptn=ent.nextInt();
                           if (bankoptn<=0&&bankoptn>3) {
                               System.out.println("Please, enter a valid option.");
                           }else{
                               Excep=true;
                           }
                       } catch (InputMismatchException e) {
                           System.out.println("Invalid input, try again.");
                       }
                   }
                BankingAccount accType=null;
                    switch (bankoptn) {
                        case 1:
                        
                            accType=new BussinessAccount(anumber, aholder, withdrawAmmount, 150000);
                            System.out.println("Bussiness Account Selected!");
                            
                            break;
                        case 2:
                        
                            accType=new CurrentAccount(anumber, aholder, withdrawAmmount, bankoptn);
                            System.out.println("Current Account Selected!");
                            System.out.println("Interests: ");
                            
                            break;

                        case 3:
                            accType=new SavingsAccount(anumber, aholder, withdrawAmmount, bankoptn);
                            System.out.println("Savings Account Selected!");
                            
                            break;
                        default:
                        System.out.println("Please, select a valid option.");
                            break;
                    }

                    Withdraw withdraw=new Withdraw(accType, withdrawAmmount, aDate, withdrawAmmount);
                    transactions.add(withdraw);
                    TransactionFileManager.saveTransactionsToCSV(transactions, "transactions.txt");
                    System.out.println("Withdraw added Successfully!");
                    System.out.println("This is your actual balance: "+(accType.getBA_balance()-withdraw.getWit_ammount()));

            } catch (Exception e) {
                System.out.println("Invalid Input Exception. Returning to Main Menu...");
            }
                    
                    
                    break;

                case 3:

                    for (Transactions t : transactions) {
                        System.out.println(t);
                    }
                    break;

                case 4:
                    System.out.println("Quiting...");
                    exit=true;
                    break;
            
                default:
                System.out.println("Invalid Option, try again.");
                    break;
            }
    

        }
    }
}
