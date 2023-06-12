import Exceptions.AccountCreationException;
import Exceptions.InvalidBalanceException;
import Model.Account;
import Model.CheckingAccount;
import Model.SavingsAccount;
import Service.ClientService;
import Util.AccountTypeUtil;

public class Bank {
    public static void main(String[] args) throws InvalidBalanceException, AccountCreationException {
        ClientService clientOne = new ClientService("John Doe", 123456789L, "0-1234",
                createBankAccount(AccountTypeUtil.CHECKING,"0-1234", 1111, 1000));
        clientOne.accounts.put(AccountTypeUtil.SAVINGS,
                createBankAccount(AccountTypeUtil.SAVINGS,"0-1234", 1112, 2000));
        clientOne.showBalance(AccountTypeUtil.CHECKING);
        clientOne.showBalance(AccountTypeUtil.SAVINGS);
        System.out.println("Transferring 500 from checking to savings");
        clientOne.transferToClient(AccountTypeUtil.CHECKING,clientOne, 500);
        clientOne.showBalance(AccountTypeUtil.CHECKING);
        clientOne.showBalance(AccountTypeUtil.SAVINGS);



        ClientService clientTwo = new ClientService( "Marie Antoinette", 987654321L, "0-1234",
                createBankAccount(AccountTypeUtil.CHECKING,"0-1234", 2221, 1000));
        clientTwo.accounts.put(AccountTypeUtil.SAVINGS, createBankAccount(AccountTypeUtil.SAVINGS,"0-1234", 2222, 2000));
        System.out.println("Transferring 750 from Marie Antoinette to John Doe");
        clientTwo.transferToClient(AccountTypeUtil.SAVINGS, clientOne, 750);
        clientOne.showBalance(AccountTypeUtil.CHECKING);
        clientOne.showBalance(AccountTypeUtil.SAVINGS);
        clientTwo.showBalance(AccountTypeUtil.CHECKING);
        clientTwo.showBalance(AccountTypeUtil.SAVINGS);


        System.out.println("Marie Antoinette depositing 500 to checking account");
        clientTwo.accounts.get(AccountTypeUtil.CHECKING).deposit(500);
        clientTwo.showBalance(AccountTypeUtil.CHECKING);
        System.out.println("Marie Antoinette withdrawing 750 from savings account");
        clientTwo.accounts.get(AccountTypeUtil.SAVINGS).withdraw(750);
        clientTwo.showBalance(AccountTypeUtil.SAVINGS);

        //To test the exception, uncomment the following lines:
        //clientTwo.accounts.get(AccountTypeUtil.SAVINGS).withdraw(10000);
        //clientTwo.transferToClient(AccountTypeUtil.SAVINGS, clientOne, 10000);
        //createBankAccount("invalid account type", "0-1234", 3333, 3000);


    }

    public static Account createBankAccount(String accountType, String agency, int accountNumber, double balance) throws AccountCreationException {
        if (accountType.equals(AccountTypeUtil.CHECKING)) {
            return new CheckingAccount(agency, accountNumber, balance);
        } else if (accountType.equals(AccountTypeUtil.SAVINGS)) {
            return new SavingsAccount(agency, accountNumber, balance);
        } else {
            throw new AccountCreationException("Cannot create account due to an invalid account type");
        }
    }

}