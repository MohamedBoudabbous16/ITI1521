public class Account {
    private double balance;

    public Account() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("new balance=" + this.balance + "$");
    }

    public void withdraw(double amount) throws NotEnoughMoneyException {
        if (this.balance < amount) {
            throw new NotEnoughMoneyException(amount, this.balance);
        }
        this.balance -= amount;
        System.out.println("new balance=" + this.balance + "$");
    }

    public double getBalance() {
        return balance;
    }
}

