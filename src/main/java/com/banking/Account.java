package com.banking;
import java.math.BigDecimal;
import java.util.ArrayList;
public class Account {
    private String Owner;
    private BigDecimal Balance;
    private ArrayList<Transaction> AccountTransactions;
    public Account(String owner) {
        this.Owner = owner;
        this.Balance = new BigDecimal(0);
        this.AccountTransactions = new ArrayList<>();

    }
    public  ArrayList<Transaction> getTransactions() {
         return this.AccountTransactions;

    }
    public void deposit(BigDecimal amount) {
        //the money deposited in the bank
        if (amount.compareTo(BigDecimal.ZERO) <=0) {
            throw new IllegalArgumentException("you cannot deposit a negative amount");
        }
        this.Balance=this.Balance.add(amount);
        this.AccountTransactions.add(new Transaction("deposit",amount));
    }
    public void withdraw(BigDecimal amount) {
        //the money withdrawn from the bank
        if(amount==null){
            throw new IllegalArgumentException("you cannot withdraw a null amount");
        }
        if(amount.compareTo(BigDecimal.ZERO)<=0){
            throw new IllegalArgumentException("you cannot withdraw a negative amount");
        }
        if (this.Balance.subtract(amount).compareTo(BigDecimal.ZERO)<=0){
            throw new IllegalArgumentException("you don't have enough balance");
        }

        this.Balance=this.Balance.subtract(amount);
        this.AccountTransactions.add(new Transaction("withdraw",amount));

    }
    public BigDecimal getBalance() {
        return this.Balance;
    }
    public void transferTo(Account recipient, BigDecimal amount) {
        if (recipient.getBalance()==null){
            throw new IllegalArgumentException("recipient cannot be null balance");
        }
        Account sender = this;
        sender.withdraw(amount);
        recipient.deposit(amount);

    }

}
