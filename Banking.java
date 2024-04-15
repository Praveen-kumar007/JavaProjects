import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SavingsAccount person1Savings = new SavingsAccount(1500.0, 0.03);
        SavingsAccount person2Savings = new SavingsAccount(2000.0, 0.04);
        CurrentAccount person1Current = new CurrentAccount(1000.0);
        CurrentAccount person2Current = new CurrentAccount(1200.0);

        List<String> transactionSummary = new ArrayList<>();

        System.out.println("Select an option: ");
        System.out.println("1. Person 1 Savings Account");
        System.out.println("2. Person 2 Savings Account");
        System.out.println("3. Person 1 Current Account");
        System.out.println("4. Person 2 Current Account");

        int personChoice = scanner.nextInt();
        Account selectedAccount;

        switch (personChoice) {
            case 1:
                selectedAccount = person1Savings;
                break;
            case 2:
                selectedAccount = person2Savings;
                break;
            case 3:
                selectedAccount = person1Current;
                break;
            case 4:
                selectedAccount = person2Current;
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                return;
        }

        int choice;
        do {
            System.out.println("\nSelect an operation for the account: ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer to Another Account");
            System.out.println("4. Balance Enquiry");
            System.out.println("0. Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    performOperation(selectedAccount, Operation.DEPOSIT, depositAmount);
                    transactionSummary.add("Deposited $" + depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    performOperation(selectedAccount, Operation.WITHDRAW, withdrawalAmount);
                    transactionSummary.add("Withdrawn $" + withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Select account to transfer to: ");
                    System.out.println("1. Person 1 Savings Account");
                    System.out.println("2. Person 2 Savings Account");
                    System.out.println("3. Person 1 Current Account");
                    System.out.println("4. Person 2 Current Account");
                    int transferAccountChoice = scanner.nextInt();
                    Account destinationAccount;

                    switch (transferAccountChoice) {
                        case 1:
                            destinationAccount = person1Savings;
                            break;
                        case 2:
                            destinationAccount = person2Savings;
                            break;
                        case 3:
                            destinationAccount = person1Current;
                            break;
                        case 4:
                            destinationAccount = person2Current;
                            break;
                        default:
                            System.out.println("Invalid choice. Transfer aborted.");
                            continue;
                    }

                    System.out.print("Enter transfer amount: $");
                    double transferAmount = scanner.nextDouble();
                    performTransfer(selectedAccount, destinationAccount, transferAmount);
                    transactionSummary.add("Transferred $" + transferAmount + " to another account.");
                    break;
                case 4:
                    performOperation(selectedAccount, Operation.BALANCE_ENQUIRY);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        System.out.println("\nTransaction Summary:");
        for (String transaction : transactionSummary) {
            System.out.println(transaction);
        }

        System.out.println("\nFinal Balances:");
        System.out.println("Person 1 Savings Account Balance: $" + person1Savings.getBalance());
        System.out.println("Person 2 Savings Account Balance: $" + person2Savings.getBalance());
        System.out.println("Person 1 Current Account Balance: $" + person1Current.getBalance());
        System.out.println("Person 2 Current Account Balance: $" + person2Current.getBalance());
    }

    static void performTransfer(Account sourceAccount, Account destinationAccount, double amount) {
        sourceAccount.transfer(destinationAccount, amount);
    }

    static enum Operation {
        DEPOSIT, WITHDRAW, BALANCE_ENQUIRY
    }

    public static void performOperation(Account account, Operation operation, double amount) {
        switch (operation) {
            case DEPOSIT:
                account.deposit(amount);
                System.out.println("Deposit of $" + amount + " completed.");
                break;
            case WITHDRAW:
                account.withdraw(amount);
                System.out.println("Withdrawal of $" + amount + " completed.");
                break;
            case BALANCE_ENQUIRY:
                account.balanceEnquiry();
                break;
            default:
                System.out.println("Invalid operation");
        }
    }

    public static void performOperation(Account account, Operation operation) {
        performOperation(account, operation, 0.0);
    }
}

abstract class Account {
    protected double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public abstract void handleTransaction(double amount);

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract void balanceEnquiry();

    public abstract void transfer(Account destinationAccount, double amount);
}

final class SavingsAccount extends Account {
    private final double interestRate;

    public SavingsAccount(double initialBalance, double interestRate) {
        super(initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void handleTransaction(double amount) {
        // applying interest
        balance += balance * interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        handleTransaction(amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            handleTransaction(-amount);
        } else {
            System.out.println("Insufficient funds for withdrawal. Withdrawal aborted.");
        }
    }

    @Override
    public void balanceEnquiry() {
        System.out.println("Savings Account Balance: $" + getBalance());
    }

    @Override
    public void transfer(Account destinationAccount, double amount) {
        if (amount <= balance) {
            balance -= amount;
            destinationAccount.deposit(amount);
            handleTransaction(-amount);
            destinationAccount.handleTransaction(amount);
            System.out.println("Transfer of $" + amount + " completed.");
        } else {
            System.out.println("Insufficient funds for transfer. Transfer aborted.");
        }
    }
}

final class CurrentAccount extends Account {
    public CurrentAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void handleTransaction(double amount) {
        // Implement specific transaction handling for Current Account if needed
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        handleTransaction(amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            handleTransaction(-amount);
        } else {
            System.out.println("Insufficient funds for withdrawal. Withdrawal aborted.");
        }
    }

    @Override
    public void balanceEnquiry() {
        System.out.println("Current Account Balance: $" + getBalance());
    }

    @Override
    public void transfer(Account destinationAccount, double amount) {
        if (amount <= balance) {
            balance -= amount;
            destinationAccount.deposit(amount);
            handleTransaction(-amount);
            destinationAccount.handleTransaction(amount);
            System.out.println("Transfer of $" + amount + " completed.");
        } else {
            System.out.println("Insufficient funds for transfer. Transfer aborted.");
        }
    }
}
