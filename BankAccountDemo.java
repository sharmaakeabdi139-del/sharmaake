class BankAccount {
    private String accountNumber;
    protected double balance;

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Rejected: deposit must be more than 0");
            return;
        }
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    private double minimumBalance = 50;

    public double getMinimumBalance() {
        return minimumBalance;
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit = 200;

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public double availableFunds() {
        return balance + overdraftLimit;
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount();
        savings.setAccountNumber("SAV-1001");
        savings.deposit(300);
        savings.deposit(-20);

        CurrentAccount current = new CurrentAccount();
        current.setAccountNumber("CUR-2001");
        current.deposit(150);

        System.out.println(
            savings.getAccountNumber() +
            " balance: " + savings.getBalance() +
            " (minimum " + savings.getMinimumBalance() + ")"
        );

        System.out.println(
            current.getAccountNumber() +
            " balance: " + current.getBalance() +
            " (available with overdraft " +
            current.availableFunds() + ")"
        );

        System.out.println("Savings IS-A BankAccount? " +
            (savings instanceof BankAccount));
        System.out.println("Savings IS-A Object? " +
            (savings instanceof Object));
    }
}
