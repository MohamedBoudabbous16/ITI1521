/**
 * classe  ChequingAccount
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 02/08/2024
 */
public class ChequingAccount extends BankAccount {
    private String accountId;

    public ChequingAccount(char[] bankInstitution, String transit, Person owner, String shortAccountNumber) {
        super(owner);
        this.accountId = new String(bankInstitution) + transit + shortAccountNumber;
        this.accountId += String.valueOf(Utils.generateRandomEvenNumber());
    }

    public ChequingAccount(char[] bankInstitution, String transit, Person owner) {
        this(bankInstitution, transit, owner, String.valueOf(Bank.getNextAccountNumber()));
    }

    String getId() {
        return accountId;
    }

    public String getMetadata() {
        return "AccountType: Chequing, AccountHolder: " + this.getAccountHolder().getName();
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

