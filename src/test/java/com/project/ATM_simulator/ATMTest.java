package com.project.ATM_simulator;

import com.project.ATM_simulator.model.ATM;
import com.project.ATM_simulator.model.Bank;
import com.project.ATM_simulator.model.Currency;
import com.project.ATM_simulator.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    private Bank bank;
    private User user;
    private ATM atm;
    private Currency currency;

    @BeforeEach
    void setUp() {
        bank = new Bank(1000.0);
        user = new User(bank, 0);
        currency = new Currency();
        atm = new ATM(user, currency);
    }

    @Test
    public void testViewUserBankBalance() {
        double balance = atm.viewUserBankBalance();
        assertEquals(1000.0, balance);
    }

    @Test
    public void testUserBankAccountWithdrawal() {
        double withdraw = 100;
        double expectedBalance = 1000.0 - withdraw;

        double actualBalance = atm.userBankAccountWithdrawal(withdraw);

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void testWithdraw() {
        double withdraw = 100;

        double expectedBankBalance = 1000.0 - withdraw;
        double expectedPocketBalance = 0 + withdraw;

        atm.withdraw(withdraw);

        assertEquals(expectedBankBalance, user.getAccountBalance());
        assertEquals(expectedPocketBalance, user.getPocketBalance());
    }

    @Test
    public void testExchange() {

        double withdraw = 100.0;
        String keyValue = "USD";
        double usd = 0.1037;
        double expectedPocketBalanceAfterExchange = usd * withdraw;
        double actualExchangeValue = atm.currencyExchange(withdraw, keyValue);
        System.out.println("expected: " + expectedPocketBalanceAfterExchange);
        System.out.println("actual: " + actualExchangeValue);

        assertEquals(expectedPocketBalanceAfterExchange, actualExchangeValue);
    }

    @Test
    public void testAddToPocketBalance() {
        double withdraw = 100.0;
        double usd = 0.1037;
        double expectedPocketBalance = usd * withdraw;
        String keyValue = "USD";
        double actualNewPocketBalance = atm.addToPocketBalance(withdraw, keyValue);


        assertEquals(expectedPocketBalance, actualNewPocketBalance);

    }

    @Test
    public void testUserPocketBalanceWithdrawal() {
        double withdraw = 100;
        double expectedBalance = 0 + 100;
        double actualBalance = atm.addToPocketBalance(withdraw, keyValue);


        assertEquals(expectedBalance, actualBalance);
    }


}




