package com.banking;
import java.math.BigDecimal;
public class Account {
    private String Owner;
    private BigDecimal Balance;
    public Account(String owner) {
        this.Owner = owner;
        this.Balance = new BigDecimal(0);

    }
    public void deposit(BigDecimal amount) {
        //the money deposited in the bank
        if (amount.compareTo(BigDecimal.ZERO) <=0) {
            throw new IllegalArgumentException("you cannot deposit a negative amount");
        }
        this.Balance=this.Balance.add(amount);
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

    }
    public BigDecimal getBalance() {
        return this.Balance;
    }

}
