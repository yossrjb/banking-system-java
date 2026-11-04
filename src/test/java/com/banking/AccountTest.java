package com.banking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    @Test
    void depositShouldIncreaseBalance() {

        Account account = new Account("Sara");

        account.deposit(new BigDecimal("100"));

        assertEquals(
                new BigDecimal("100"),
                account.getBalance()
        );
    }
    @Test
    void negativeDepositShouldFail() {
        Account account1 = new Account("Sara");

        assertThrows(IllegalArgumentException.class,
                    () -> account1.deposit(new BigDecimal("-100")));
        }


    @Test
    void withdrawShouldDecreaseBalance() {
        Account account = new Account("Sara");
        account.deposit(new BigDecimal("100"));
        account.withdraw(new BigDecimal("50"));
        assertEquals(new BigDecimal("50"), account.getBalance());
    }
    @Test
    void withdrawingTooMuchShouldFail() {
        Account account = new Account("Sara");
        account.deposit(new BigDecimal("100"));
        assertThrows(IllegalArgumentException.class,
                    () -> account.withdraw(new BigDecimal("150")));
    }
    @Test
    void failedWithdrawalShouldNotChangeBalance() {
        Account account = new Account("Sara");
        account.deposit(new BigDecimal("100"));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(new BigDecimal("150")));
        assertEquals(new BigDecimal("100"), account.getBalance() );
    }
    @Test
    void MultipleDepositsShouldAddUp(){
        Account account = new Account("Sara");
        account.deposit(new BigDecimal("100"));
        account.deposit(new BigDecimal("200"));
        assertEquals(new BigDecimal("300"), account.getBalance());



    }
    @Test
    void transferShouldUpdateBothBalances(){
        Account account1 = new Account("Sara");
        Account account2 = new Account("Adam");
        account1.deposit(new BigDecimal("100"));
        account2.deposit(new BigDecimal("200"));
        account1.transferTo(account2, new BigDecimal("50"));
        assertEquals(new BigDecimal("50"), account1.getBalance());
        assertEquals(new BigDecimal("250"), account2.getBalance());


    }
    @Test
    void TransferWithInsufficientFundsShouldFail() {
        Account account1 = new Account("Sara");
        Account account2 = new Account("Adam");
        account1.deposit(new BigDecimal("100"));
        account2.deposit(new BigDecimal("200"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> account1.transferTo(account2, new BigDecimal("150")));
    }


}
