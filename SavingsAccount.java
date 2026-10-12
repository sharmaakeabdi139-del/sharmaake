public class SavingsAccount extends BankAccount {
    private double minimumBalance;

    public SavingsAccount(String accountNumber, double balance, double minimumBalance) {
        super(accountNumber, balance);
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance - amount < minimumBalance)
            throw new InsufficientBalanceException("Must keep at least " + minimumBalance);
        balance -= amount;
    }
}
