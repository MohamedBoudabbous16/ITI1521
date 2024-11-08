/**
 * classe abstraite Account
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 02/08/2024
 */

abstract class Account {
    abstract String getId();
    protected Person accountHolder;

    Person getAccountHolder() {
        return accountHolder;
    }

    void setAccountHolder(Person accountHolder) {
        this.accountHolder = accountHolder;
    }
}