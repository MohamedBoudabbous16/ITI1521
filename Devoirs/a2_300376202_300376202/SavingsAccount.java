/**
 * classe  SavingsAccount
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 02/08/2024
 */
public class SavingsAccount extends BankAccount {
    private String accountId;
    private Double interestRate;

    public SavingsAccount(char[] bankInstitution, String transit, Person owner, String shortAccountNumber, Double interestRate) {
        super(owner);
        this.accountId = new String(bankInstitution) + transit + shortAccountNumber;
        this.interestRate = interestRate;
    }

    public SavingsAccount(char[] bankInstitution, String transit, Person owner, Double interestRate) {
        this(bankInstitution, transit, owner, String.valueOf(Bank.getNextAccountNumber()), interestRate);int checkDigit = (Utils.generateRandomEvenNumber() + 1)%10;accountId += String.valueOf(checkDigit);
    }

    public void setInterestRate (Double interestRate) {
        this.interestRate = interestRate;
    }


    String getId() {
        return accountId;
    }
   public String getMetadata() {
        return "AccountType: Savings, AccountHolder: " + this.getAccountHolder().getName() + ", InterestRate: " + this.interestRate;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

//
}