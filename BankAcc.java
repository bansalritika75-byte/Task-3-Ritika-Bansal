public class BankAcc {

    private String accNo;
    private String holderName;
    private double balance;
    private String pin;
    private int wrongTries;

    
    public BankAcc(String accNo, String holderName, double balance, String pin) {
        if (balance < 0) {
            System.out.println("Opening balance cant be negative!");
            balance = 0;
        }
        this.accNo = accNo;
        this.holderName = holderName;
        this.balance = balance;
        this.pin = pin;
        this.wrongTries = 0;
    }

    public String getAccNo() {
        return accNo;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isBlocked() {
        return wrongTries >= 3;
    }

    public boolean checkPin(String enteredPin) {
        if (isBlocked()) {
            System.out.println("Account is blocked. Too many wrong attempts.");
            return false;
        }

        if (pin.equals(enteredPin)) {
            wrongTries = 0;
            return true;
        } else {
            wrongTries++;
            if (wrongTries >= 3) {
                System.out.println("Wrong PIN. Account is now blocked!");
            } else {
                System.out.println("Wrong PIN. Try again. Attempts left: " + (3 - wrongTries));
            }
            return false;
        }
    }

    public boolean deposit(double amt) {
        if (amt <= 0) {
            System.out.println("Please enter a valid amount to deposit.");
            return false;
        }
        balance = balance + amt;
        System.out.println("Deposit done! Amount added: Rs." + amt);
        System.out.println("Your new balance is: Rs." + balance);
        return true;
    }

    // withdraw money from account
    public boolean withdraw(double amt) {
        if (amt <= 0) {
            System.out.println("Please enter a valid amount to withdraw.");
            return false;
        }
        if (amt > balance) {
            System.out.println("Sorry! Not enough balance.");
            System.out.println("Current balance: Rs." + balance);
            return false;
        }
        balance = balance - amt;
        System.out.println("Withdrawal successful! Rs." + amt + " dispensed.");
        System.out.println("Remaining balance: Rs." + balance);
        return true;
    }

    public void showBalance() {
        System.out.println("-----------------------------");
        System.out.println("Name    : " + holderName);
        System.out.println("Acc No  : " + accNo);
        System.out.println("Balance : Rs." + balance);
        System.out.println("-----------------------------");
    }

}
