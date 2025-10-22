package Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import Models.*;

public class TransactionFileManager {

    public static void saveTransactionsToCSV(List<Transactions> transactions, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Type,AccountNumber,Holder,Balance,Amount,Date\n");

            for (Transactions t : transactions) {
                if (t instanceof Deposit) {
                    writer.write(((Deposit) t).depositToCSV() + "\n");
                } else if (t instanceof Withdraw) {
                    writer.write(((Withdraw) t).depositToCSV()+ "\n");
                }
            }

            System.out.println("Transactions saved to: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
