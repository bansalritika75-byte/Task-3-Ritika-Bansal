import java.util.ArrayList;

public class ATM {

    private BankAcc currentAcc;
    private boolean loggedIn;
    private ArrayList<Transaction> txnList;

    public ATM() {   // constructor
        currentAcc = null;
        loggedIn = false;
        txnList = new ArrayList<Transaction>();
    }

    public void insertCard(BankAcc acc) {
        currentAcc = acc;
        loggedIn = false;
        System.out.println("--------------------------------------------");
        System.out.println("  Card inserted for: " + acc.getHolderName());
        System.out.println("  Please enter your PIN");
        System.out.println("--------------------------------------------");
    }

    public boolean login(String enteredPin) {
        if (currentAcc == null) {
            System.out.println("No card inserted!");
            return false;
        }
        loggedIn = currentAcc.checkPin(enteredPin);
        if (loggedIn) {
            System.out.println("Login successful! Welcome " + currentAcc.getHolderName());
        }
        return loggedIn;
    }

    // deposit operation
    public void doDeposit(double amt) {
        if (!loggedIn) {
            System.out.println("Please login first.");
            return;
        }
        boolean ok = currentAcc.deposit(amt);
        if (ok) {
            String t = java.time.LocalTime.now().toString().substring(0, 8);
            txnList.add(new Transaction("Deposit", amt, currentAcc.getBalance(), t));
        }
    }

    public void doWithdraw(double amt) {
        if (!loggedIn) {
            System.out.println("Please login first.");
            return;
        }
        boolean ok = currentAcc.withdraw(amt);
        if (ok) {
            String t = java.time.LocalTime.now().toString().substring(0, 8);
            txnList.add(new Transaction("Withdraw", amt, currentAcc.getBalance(), t));
        }
    }

    public void doBalanceCheck() {
        if (!loggedIn) {
            System.out.println("Please login first.");
            return;
        }
        currentAcc.showBalance();
        String t = java.time.LocalTime.now().toString().substring(0, 8);
        txnList.add(new Transaction("Balance Check", 0, currentAcc.getBalance(), t));
    }

    public void showHistory() {
        if (!loggedIn) {
            System.out.println("Please login first.");
            return;
        }
        System.out.println(" Transaction History");
        if (txnList.size() == 0) {
            System.out.println("No transactions yet.");
        } else {
            for (int i = 0; i < txnList.size(); i++) {
                System.out.print((i + 1) + ". ");
                txnList.get(i).printTxn();
            }
        }
    }

    public void ejectCard() {
        System.out.println("Thank you for using My ATM!");
        System.out.println("Please collect your card. Goodbye!");
        currentAcc = null;
        loggedIn = false;
        txnList.clear();
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}