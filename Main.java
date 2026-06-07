import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        BankAcc[] allAccounts = {
                new BankAcc("D-1", "Ritika Bansal", 50000, "2525"),
                new BankAcc("D-2", "Shreya Rathore", 75000, "5678"),
                new BankAcc("D-3", "Chinku Singh", 120000, "2489")
        };

        System.out.println("Select your account:");
        for (int i = 0; i < allAccounts.length; i++) {
            System.out.println((i + 1) + ". " + allAccounts[i].getHolderName() + " (" + allAccounts[i].getAccNo() + ")");
        }

        System.out.print("Enter choice (1-3): ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice < 1 || choice > 3) {
            System.out.println("Invalid choice. Exiting.");
            sc.close();
            return;
        }

        BankAcc selected = allAccounts[choice - 1];
        atm.insertCard(selected);

        boolean loginDone = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter PIN: ");
            String pin = sc.nextLine().trim();
            loginDone = atm.login(pin);
            if (loginDone)
                break;
            if (selected.isBlocked()) {
                System.out.println("Account blocked. Exiting.");
                sc.close();
                return;
            }
        }

        if (!loginDone) {
            System.out.println("Login failed. Card rejected.");
            sc.close();
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("\n MAIN MENU");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int option;
            try {
                option = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number between 1 and 5.");
                continue;
            }

            if (option == 1) {
                atm.doBalanceCheck();

            } else if (option == 2) {
                System.out.print("Enter amount to deposit: Rs.");
                try {
                    double amt = Double.parseDouble(sc.nextLine().trim());
                    atm.doDeposit(amt);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount entered.");
                }

            } else if (option == 3) {
                System.out.print("Enter amount to withdraw: Rs.");
                try {
                    double amt = Double.parseDouble(sc.nextLine().trim());
                    atm.doWithdraw(amt);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount entered.");
                }

            } else if (option == 4) {
                atm.showHistory();

            } else if (option == 5) {
                atm.ejectCard();
                running = false;

            } else {
                System.out.println("Wrong option. Please choose 1 to 5.");
            }
        }

        sc.close();
        System.out.println("Program ended.");
    }
}