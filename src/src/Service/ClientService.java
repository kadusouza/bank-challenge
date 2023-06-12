package Service;

import Exceptions.InvalidBalanceException;
import Model.Account;
import Model.Client;
import Util.AccountTypeUtil;

public class ClientService extends Client {

    public ClientService(String name, long documentNumber, String agency, Account account) {
        super(name, documentNumber, agency, account);
    }

    public void transferToClient(String accountType, Client receivingClient, double amount) throws InvalidBalanceException {
        if(this.accounts.get(accountType).getBalance() < amount) {
            throw new InvalidBalanceException("Cannot transfer: Insufficient funds");
        } else if(this.documentNumber.equals(receivingClient.documentNumber) && (this.agency.equals(receivingClient.agency))) {
            this.accounts.get(accountType).withdraw(amount);
            this.accounts.get(AccountTypeUtil.returnOtherAccountType(accountType)).deposit(amount);
        } else {
            this.accounts.get(accountType).withdraw(amount);
            receivingClient.accounts.get(accountType).deposit(amount);
        }
    }

    public void showBalance(String accountType) {
        if (accountType.equals(AccountTypeUtil.CHECKING))
            System.out.println(this.name + ", your checking account balance is: " + accounts.get(accountType).getBalance());
        else if (accountType.equals(AccountTypeUtil.SAVINGS))
            System.out.println(this.name + ", your savings account balance is: " + accounts.get(accountType).getBalance());
    }

}
