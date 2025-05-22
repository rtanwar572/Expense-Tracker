import java.io.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

public class ExpenseTracker {
    private List<Transaction> transactions;

    public ExpenseTracker() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty())
                    continue; // skip blank lines
                transactions.add(Transaction.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void saveToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Transaction t : transactions) {
                bw.write(t.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public void showMonthlySummary(int year, int month) {
        double incomeTotal = 0, expenseTotal = 0;
        System.out.println("Monthly Summary for " + YearMonth.of(year, month));

        for (Transaction t : transactions) {
            if (t.getDate().getYear() == year && t.getDate().getMonthValue() == month) {
                System.out.printf("%s - %s: ₹ %.2f\n", t.getType(), t.getCategory(), t.getAmount());

                if (t.getType() == TransactionType.INCOME)
                    incomeTotal += t.getAmount();
                else
                    expenseTotal += t.getAmount();
            }
        }

        System.out.printf("Total Income: ₹%.2f\n", incomeTotal);
        System.out.printf("Total Expense: ₹%.2f\n", expenseTotal);
        System.out.printf("Net Savings: ₹%.2f\n", (incomeTotal - expenseTotal));
    }
}