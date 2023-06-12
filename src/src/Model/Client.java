package Model;

import java.util.HashMap;
import java.util.Map;

public class Client {
    protected String name;
    public Long documentNumber;
    public String agency;
    public Map<String, Account> accounts;

    Client(String name, Long documentNumber, String agency) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.agency = agency;
        this.accounts = new HashMap<String, Account>();
        System.out.println("Client " + this.name + " signed up successfully");
    }

    protected Client(String name, Long documentNumber, String agency, Account account) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.agency = agency;
        this.accounts = new HashMap<String, Account>();
        this.accounts.put(account.getAccountType(), account);
        System.out.println("Client " + this.name + " signed up successfully");
    }

}
