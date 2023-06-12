package Model;

import Exceptions.InvalidBalanceException;
import Util.AccountTypeUtil;

public class CheckingAccount extends Account {

    public void setAccountType() {
        this.accountType = AccountTypeUtil.CHECKING;
    }

    public CheckingAccount(String agency, int accountNumber) {
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.setAccountType();
    }

    public CheckingAccount(String agency, int accountNumber, double balance) {
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.setAccountType();
    }

    @Override
    public void deposit(double amount) {
        this.balance = this.balance + amount;
    }

    @Override
    public void withdraw(double amount) throws InvalidBalanceException {
        if (amount > balance)
            throw new InvalidBalanceException("Cannot withdraw: Insufficient funds");
        else
            this.balance = this.balance - amount;
    }

}
