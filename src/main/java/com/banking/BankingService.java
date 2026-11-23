package com.banking;
import java.util.HashMap;
import java.util.Map;
public class BankingService {
    private Map<String, Account> accounts = new HashMap<>();
    public BankingService() {
        accounts.put("ACC001", new Account("Customer"));
        accounts.put("ACC002", new Account("Alice"));
        accounts.put("ACC003", new Account("Bob"));
    }
    public Account getAccount(String accountId) {
        Account account = accounts.get(accountId);

        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }

        return account;
    }



}
