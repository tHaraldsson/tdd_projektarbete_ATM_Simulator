package com.project.ATM_simulator.model;

import com.project.ATM_simulator.model.bank.Account;
import com.project.ATM_simulator.model.bank.Bank;
import com.project.ATM_simulator.model.bank.BankRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankRegistryTest {

    private Bank bank;
    private Wallet wallet;
    private BankRegistry bankRegistry;
    private Account account;

    @BeforeEach
    void setUp() {
        bankRegistry = new BankRegistry();
        bank = new Bank();
        bankRegistry.registerBank(bank);
        account = new Account(1000.0);
        wallet = new Wallet();
    }

    @Test
    void registerBank() {

        User user = new User("bennybanan@gmail.com", 1234, "benny", wallet, account);
        bank.addUser(user);

        Bank actualBank = bankRegistry.getUserBank(user);
        assertSame(bank, actualBank, "Should pass if the bank has been successfully added to bank registry." +
                "getUserBank() successfully fetched from bank registry");
    }

    @Test
    public void testAuthenticateUser() {
        String expectedEmail = "test@gmail.com";
        int expectedPinCode = 1111;

        User expectedUser = new User(expectedEmail, expectedPinCode, "expected user", wallet, account);
        bank.addUser(expectedUser);

        User actualUser = bankRegistry.authenticateUser(expectedEmail, expectedPinCode);

        assertSame(expectedUser, actualUser, "authenticateUser() should return the exact same User instance that was registered");
    }

}