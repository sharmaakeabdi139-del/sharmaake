public class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance - amount < -overdraftLimit)
            throw new InsufficientBalanceException("Overdraft limit " + overdraftLimit + " exceeded");
        balance -= amount;
    }
}
