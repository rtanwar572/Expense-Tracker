# 💸 Java Expense Tracker 📊

A simple CLI-based Expense Tracker built with **Java** that allows users to:
- ✅ Add income and expenses
- 🗂️ Categorize transactions (e.g., Food, Rent, Travel)
- 📅 View monthly summaries
- 📁 Save & load data from a file

---

## 🚀 Features

- ➕ Add Income/Expense
- 🏷️ Choose sub-categories like `Salary`, `Business`, `Food`, `Rent`, `Travel`
- 📆 Track transactions by date
- 📊 View monthly summaries (total income, expenses, and balance)
- 📂 Load data from a `.txt` file
- 💾 Save new entries to file

---

## 🧪 How It Works

1. When the program starts, it asks:

2. If `yes`, provide the filename (e.g., `transactions.txt`)

3. Then choose:
- Add Income
- Add Expense
- View Monthly Summary
- Exit


4. While adding a transaction, you’ll enter:
- Category
- Amount
- Date (format: yyyy-mm-dd)

---

## 📝 File Format (`transactions.txt`)

```txt
INCOME,Salary,50000,2025-05-01
EXPENSE,Food,1500,2025-05-02
EXPENSE,Rent,12000,2025-05-03

```


⚠️ Make sure:
- All entries are comma-separated
- TransactionType is in **UPPERCASE** (`INCOME` or `EXPENSE`)
- No blank lines

---

## 🛠 Technologies Used

- ☕ Java
- 📚 OOP (Object-Oriented Programming)
- 📄 File I/O using `BufferedReader` / `FileWriter`
- 🧠 Enums & Collections

---

## 📂 Project Structure

``` bash
src/
├── Main.java
├── ExpenseTracker.java
├── Transaction.java
├── TransactionType.java
```


---

## 📈 Example Output

Enter year and month (yyyy mm): 2025 05
--- Summary for 2025-05
- Total Income: 70000.0
- Total Expense: 13500.0
- Net Balance: 56500.0

---

## 🏁 Getting Started

1. Compile:

2. Run:

3. Optional: create your `transactions.txt` with proper format.

---

## 📌 #Tags

#Java #ExpenseTracker #OOP #CLIApp #FileHandling #Project #FinanceApp #JavaProjects

---

## 🧑‍💻 Author
 - Rohit Tanwar 💛


Made with 💛 using Java


