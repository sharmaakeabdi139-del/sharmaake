class BankAccount {
    private String accountNumber;
    protected double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Basic rule: you cannot take out more than you have
    void withdraw(double amount) {
        if (amount > balance)
            refuse("not enough money");
        else
            balance -= amount;
    }

    void refuse(String why) {
        System.out.println(" " + accountNumber + " refused: " + why);
    }

    void show() {
        System.out.println(" " + accountNumber + " balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    SavingsAccount(String n, double b) {
        super(n, b);
    }

    @Override
    void withdraw(double amount) {
        // Must keep at least 50
        if (balance - amount < 50)
            refuse("must keep at least 50");
        else
            balance -= amount;
    }
}

class CurrentAccount extends BankAccount {
    CurrentAccount(String n, double b) {
        super(n, b);
    }

    @Override
    void withdraw(double amount) {
        // May go down to -200
        if (balance - amount < -200)
            refuse("overdraft limit is 200");
        else
            balance -= amount;
    }
}

public class OverridingDemo {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SAV-1001", 300);
        CurrentAccount current = new CurrentAccount("CUR-2001", 150);

        savings.withdraw(100);
        savings.show();

        savings.withdraw(200);
        savings.show();

        current.withdraw(300);
        current.show();

        current.withdraw(100);
        current.show();
    }
}
