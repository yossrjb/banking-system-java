package com.banking;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.math.BigDecimal;
import java.util.List;
//contains methods that handle HTTP Requests
@RestController
public class BankingController
{
    private Account account=new Account("customer");
    @GetMapping("/api/balance")
    public BigDecimal retrieveBalance()
    {
        return account.getBalance();
    }
    @PostMapping("/api/withdraw")
    public BigDecimal withdraw(@RequestParam("amount") BigDecimal amount)
    {
        account.withdraw(amount);
        return account.getBalance();
    }
    @PostMapping("/api/deposit")
    public BigDecimal deposit(@RequestParam BigDecimal amount) {
        account.deposit(amount);
        return account.getBalance();
    }
    @GetMapping("/api/transactions")
    public List<Transaction> retrieveTransactions()
    {return account.getTransactions();}
    private Account recipient = new Account("Recipient");
    @PostMapping("/api/transfer")
    public BigDecimal transfer(@RequestParam BigDecimal amount)
    {
        account.transferTo(recipient, amount);
        return account.getBalance();
    }
}
