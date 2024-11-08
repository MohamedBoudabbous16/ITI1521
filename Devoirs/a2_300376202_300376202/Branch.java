/**
 * classe Branch
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 02/10/2024
 */
public class Branch {
    private String transitNumber;
    private Double interestRate;
    private String address;
    private int currentNumberOfAccountTreated = 0;
    private Stack<BankAccount> existingBankAccounts ;
    private Stack<BankAccount> newBankAccounts ;

    public Branch(String transitNumber, Double interestRate, String address) {
        this.transitNumber = transitNumber;
        this.interestRate = interestRate;
        this.address = address;
        this.existingBankAccounts = new ArrayStack<BankAccount>(100); // Corrected instantiation
        this.newBankAccounts = new ArrayStack<BankAccount>(100); // Corrected instantiation
    }
    public String getTransitNumber() {
        return this.transitNumber;
    }

    public Double getInterestRate() {
        return this.interestRate;
    }

    public String getAddress () {
        return this.address;
    }

    public Stack<BankAccount> getNewBankAccounts() {
        return this.newBankAccounts;
    }

    public Stack<BankAccount> getExistingBankAccounts() {
        return this.existingBankAccounts;
    }

    public void addBankAccount(BankAccount bankAccount) {
        newBankAccounts.push(bankAccount);
        currentNumberOfAccountTreated++;
    }

    public void recordBankAccount(BankAccount bankAccount) {
        ArrayStack<BankAccount> tempStorage = new ArrayStack<>(100);
        boolean accountFound = false;

        while (!existingBankAccounts.isEmpty()) {
            BankAccount current = existingBankAccounts.pop();
            if (!current.getId().equals(bankAccount.getId())) {
                tempStorage.push(current);
            } else {
                accountFound = true;
            }
        }

        while (!tempStorage.isEmpty()) {
            existingBankAccounts.push(tempStorage.pop());
        }

        if (!accountFound) {
            existingBankAccounts.push(bankAccount);
            currentNumberOfAccountTreated++;
        }
    }

    public int getCurrentNumberOfAccountTreated () {
        return this.currentNumberOfAccountTreated;
    }
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Branch-Succursale, Transit=" + this.transitNumber);
        sb.append(" / " + this.address);
        sb.append(" / Comptes traités=" +this.currentNumberOfAccountTreated + "\n");
        sb.append("  - Nouveau(x) compte(s) crée(s): \n");
        sb.append(getStackBankAccountToString(this.newBankAccounts));
        sb.append("  - Compte(s) existant(s): \n");
        sb.append(getStackBankAccountToString(this.existingBankAccounts));
        return sb.toString();
    }

    private static StringBuffer getStackBankAccountToString (Stack<BankAccount> stackBankAccount) {
        StringBuffer sb = new StringBuffer();

        Stack<BankAccount> tempStack = new ArrayStack<BankAccount>(100);
        while (!stackBankAccount.isEmpty()) {
            BankAccount account = stackBankAccount.pop();
            sb.append("    " + account.toString());
            tempStack.push(account);
        }

        while (!tempStack.isEmpty()) {
            BankAccount account = tempStack.pop();
            stackBankAccount.push(account);
        }

        return sb;
    }
}
