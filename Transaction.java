public class Transaction {

    private String txnType; // "Deposit", "Withdraw", "Balance Check"
    private double amount;
    private double balAfter;
    private String time;

    public Transaction(String txnType, double amount, double balAfter, String time) {
        this.txnType = txnType;
        this.amount = amount;
        this.balAfter = balAfter;
        this.time = time;
    }

    // getters
    public String getTxnType() {
        return txnType;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalAfter() {
        return balAfter;
    }

    public String getTime() {
        return time;
    }

    // print this transaction as one line
    public void printTxn() {
        if (txnType.equals("Balance Check")) {
            System.out.println("[" + time + "]  " + txnType + "  |  Balance: Rs." + balAfter);
        } else {
            System.out.println("[" + time + "]  " + txnType + "  |  Rs." + amount + "  |  Balance: Rs." + balAfter);
        }
    }
}