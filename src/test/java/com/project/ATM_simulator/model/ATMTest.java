package com.project.ATM_simulator.model;

import com.project.ATM_simulator.enums.CurrencyType;
import com.project.ATM_simulator.model.bank.Account;
import com.project.ATM_simulator.model.bank.Bank;
import com.project.ATM_simulator.model.bank.BankRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    private Bank bank;
    private Wallet wallet;
    private User user;
    private ATM atm;
    private Currency currency;
    private BankRegistry bankRegistry;
    private Account account;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        wallet = new Wallet();
        account = new Account(1000.0);
        user = new User("bennybanan@gmail.com", 1234, "benny", wallet, account);
        currency = new Currency();
        atm = new ATM(user, currency, bank);
        bankRegistry = new BankRegistry();
        bank.addUser(user);
        bankRegistry.registerBank(bank);
    }

    @Test
    public void testViewUserBankBalance() {
        double balance = atm.getAccountBalance();
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

}
