package com.banking;

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

    }


}
