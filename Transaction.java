import java.time.LocalDate;

public class Transaction {
    private TransactionType type;
    private String category;
    private double amount;
    private LocalDate date;

    public Transaction(TransactionType type, String category, double amount, LocalDate date) {
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public TransactionType getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return type + "," + category + "," + amount + "," + date;
    }

    public static Transaction fromString(String line) {
        if (line.trim().isEmpty()) {
            throw new IllegalArgumentException("Skipping empty line");
        }

        String[] parts = line.split(",");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid transaction format: " + line);
        }

        TransactionType type = TransactionType.valueOf(parts[0].trim().toUpperCase());
        String category = parts[1].trim();
        double amount = Double.parseDouble(parts[2].trim());
        LocalDate date = LocalDate.parse(parts[3].trim());

        return new Transaction(type, category, amount, date);
    }


}