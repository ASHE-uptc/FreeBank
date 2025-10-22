package Controller;

import Models.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class FilesLoader {

    public static List<Transactions> LoadTransactions(String pathFile) {
        List<Transactions> Ftransactions = new ArrayList<>();

        try (BufferedReader buffer_reader = new BufferedReader(new FileReader(pathFile))) {
            String line;

            // Saltar la cabecera si existe
            line = buffer_reader.readLine();
            if (line != null && line.startsWith("Type,")) {
                // Saltamos la primera línea
                line = buffer_reader.readLine();
            }

            while (line != null) {
                String[] values = line.split(",");

                if (values.length < 6) {
                    System.out.println("Línea inválida (no tiene suficientes columnas): " + line);
                    line = buffer_reader.readLine();
                    continue;
                }

                // Extraer campos
                String type = values[0].trim(); // "Deposit" o "Withdraw"
                String accountNumber = values[1].trim();
                String holder = values[2].trim();
                double balance = Double.parseDouble(values[3].trim());
                double amount = Double.parseDouble(values[4].trim());
                LocalDate date = LocalDate.parse(values[5].trim());

                // Crear cuenta bancaria (como clase anónima, porque es abstracta)
                BankingAccount account = new BankingAccount(accountNumber, holder, balance) {};

                // Crear la transacción según el tipo
                if (type.equalsIgnoreCase("Deposit")) {
                    Deposit deposit = new Deposit(account, amount, date, amount);
                    Ftransactions.add(deposit);
                } else if (type.equalsIgnoreCase("Withdraw")) {
                    Withdraw withdraw = new Withdraw(account, amount, date, amount);
                    Ftransactions.add(withdraw);
                } else {
                    System.out.println("Invalid Type of transaction " + type);
                }

                line = buffer_reader.readLine(); // leer siguiente línea
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + pathFile);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error parsing file: " + e.getMessage());
        }

        return Ftransactions;
    }
}
