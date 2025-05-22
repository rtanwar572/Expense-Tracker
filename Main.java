import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner sc = new Scanner(System.in);

        System.out.println("Do you want to load data from file? (yes/no)");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            System.out.print("Enter file name: ");
            tracker.loadFromFile(sc.nextLine());
        }

        while (true) {
            System.out.println("\n1. Add Transaction\n2. Show Monthly Summary\n3. Save to File\n4. Exit");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.println("Select type: 1. Income  2. Expense");
                TransactionType type = sc.nextLine().equals("1") ? TransactionType.INCOME : TransactionType.EXPENSE;

                String category;
                if (type == TransactionType.INCOME) {
                    System.out.println("Select Income Category: 1. Salary  2. Business");
                    category = sc.nextLine().equals("1") ? "Salary" : "Business";
                } else {
                    System.out.println("Select Expense Category: 1. Food  2. Rent  3. Travel");
                    switch (sc.nextLine()) {
                        case "1": category = "Food"; break;
                        case "2": category = "Rent"; break;
                        default: category = "Travel"; break;
                    }
                }

                System.out.print("Enter amount: ");
                double amount = Double.parseDouble(sc.nextLine());

                System.out.print("Enter date (yyyy-mm-dd): ");
                LocalDate date = LocalDate.parse(sc.nextLine());

                tracker.addTransaction(new Transaction(type, category, amount, date));
                System.out.println("Transaction Added!");

            } else if (choice == 2) {
                System.out.print("Enter year and month (yyyy mm): ");
                int year = sc.nextInt();
                int month = sc.nextInt();
                sc.nextLine(); // clear buffer
                tracker.showMonthlySummary(year, month);

            } else if (choice == 3) {
                System.out.print("Enter file name to save: ");
                tracker.saveToFile(sc.nextLine());
                System.out.println("Data saved successfully!");

            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            }
        }

        sc.close();
    }
}