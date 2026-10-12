public class StudentAccount extends BankAccount {
    public StudentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > 100)
            throw new InsufficientBalanceException("Max 100 per withdrawal");
        if (amount > balance)
            throw new InsufficientBalanceException("Not enough money");
        balance -= amount;
    }
}
