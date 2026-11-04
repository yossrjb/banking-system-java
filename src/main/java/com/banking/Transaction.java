package com.banking;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {
    private String type;
    private BigDecimal amount;
    private LocalDateTime date;
    public  Transaction(String type, BigDecimal amount) {
        this.type = type;
        this.amount = amount;
        this.date=LocalDateTime.now();
    }
    public BigDecimal getAmount() {
         return this.amount;
    }
    @Override
    public String toString() {
        return this.type + "|" + this.amount + "|" + this.date;
    }

}
