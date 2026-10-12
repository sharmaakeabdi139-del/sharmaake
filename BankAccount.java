public abstract class BankAccount {
    private String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Every subclass MUST write its own rule
    public abstract void withdraw(double amount) throws InsufficientBalanceException;

    // Shared by all accounts
    public void deposit(double amount) {
        if (amount <= 0) return;   // rule written once
        balance += amount;
    }

    public double getBalance() { return balance; }

    public void show() {
        System.out.println(accountNumber + ": " + balance);
    }
}
