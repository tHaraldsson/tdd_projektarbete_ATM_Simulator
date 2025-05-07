package com.project.ATM_simulator;

import com.project.ATM_simulator.auth.Authentication;
import com.project.ATM_simulator.enums.CurrencyType;
import com.project.ATM_simulator.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    private Bank bank;
    private Wallet wallet;
    private User user;
    private ATM atm;
    private Currency currency;
    private Authentication auth;

    @BeforeEach
    void setUp() {
        bank = new Bank(1000.0);
        wallet = new Wallet();
        user = new User(bank, wallet, "", 0);
        currency = new Currency();
        auth = new Authentication();
        atm = new ATM(user, currency, auth);
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
    public void testExchange() {

        double withdraw = 100.0;
        CurrencyType currencyType = CurrencyType.USD;
        double usd = 0.1037;
        double expectedPocketBalanceAfterExchange = usd * withdraw;
        double actualExchangeValue = atm.currencyExchange(currencyType, withdraw);
        System.out.println("expected: " + expectedPocketBalanceAfterExchange);
        System.out.println("actual: " + actualExchangeValue);

        assertEquals(expectedPocketBalanceAfterExchange, actualExchangeValue);
    }

    @Test
    public void testAddToWallet() {
        double withdraw = 100.0;
        double usd = 0.1037;
        double expectedWalletBalance = usd * withdraw;
        CurrencyType currencyType = CurrencyType.USD;
        atm.addToWallet(currencyType, withdraw);
        double actualWalletBalance = user.getWalletBalancesMap().get(currencyType);

        assertEquals(expectedWalletBalance, actualWalletBalance);
    }

    @Test
    public void testAuthenticationTrue() {
        String email = "bennybanan@gmail.com";
        int pinCode = 1234;
        User benny = new User(bank, wallet, email, pinCode);

        boolean trueIfAuthorized = atm.authenticateUser(email, pinCode, benny);
    assertTrue(trueIfAuthorized, "Should pass with correct credentials");
}

@Test
    public void testAuthenticationFalse() {

        User benny = new User(bank, wallet, "bennybanan@gmail.com", 1234);

        boolean falseIfNotAuthorized = atm.authenticateUser("bennybenassi@hotmail.com", 4444, benny);
        assertFalse(falseIfNotAuthorized, "Should pass with faulty credentials");
    }

}




