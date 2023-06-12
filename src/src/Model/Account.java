package Model;

import Exceptions.InvalidBalanceException;

public abstract class Account {
    protected double balance;
    protected String agency;
    protected int accountNumber;
    protected String accountType;

    public void deposit(double amount) {}
    public void withdraw(double amount) throws InvalidBalanceException {}
    public String getAccountType() {
        return this.accountType;
    }
    public void setAccountType() {
        this.accountType = accountType;
    }
    public double getBalance() {
        return this.balance;
    }
}
