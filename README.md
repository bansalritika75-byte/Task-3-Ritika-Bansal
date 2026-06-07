About the Project
This project simulates a basic ATM machine where a user can:

Login using a PIN
Check account balance
Deposit money
Withdraw money
View transaction history

Built as part of the DecodeLabs Java Training Program to practice OOP concepts like classes, objects, encapsulation, and input validation.

 Project Structure
ATM-Interface/
│
├── BankAccount.java      # Stores account details, handles deposit/withdraw/PIN
├── ATM.java              # Manages session, login, and transaction flow
├── Transaction.java      # Records each transaction with type, amount, and time
└── Main.java             # Entry point — runs the menu and takes user input

 Key Concepts Used

Classes & Objects — BankAccount, ATM, Transaction
Encapsulation — private fields with public getters
Methods — deposit, withdraw, balance check, PIN verify
Input Validation — checks for negative amounts, insufficient balance, wrong PIN
ArrayList — to store transaction history
Scanner — for taking user input from console


 How to Run
Make sure you have Java installed. Then:
bash# Step 1 - Compile all files
javac BankAccount.java Transaction.java ATM.java Main.java

# Step 2 - Run the program
java Main
