package com.banking;
import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Account sara = new Account("Sara");

        sara.deposit(new BigDecimal("100"));
        sara.withdraw(new BigDecimal("30"));

        System.out.println(sara.getTransactions());

    }
}