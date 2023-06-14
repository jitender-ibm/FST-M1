package testPackage;

import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BankAccount {
    private Integer balance;

    public BankAccount(Integer initialBalance) {
        balance = initialBalance;
    }

     public Integer withdraw(Integer amount) {
        if (balance < amount) {
            throw new NotEnoughFundsException(amount, balance);
        }
        balance -= amount;
        return balance;
    }
}