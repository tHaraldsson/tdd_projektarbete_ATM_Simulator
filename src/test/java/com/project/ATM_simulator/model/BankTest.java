package com.project.ATM_simulator.model;

import com.project.ATM_simulator.model.bank.Account;
import com.project.ATM_simulator.model.bank.Bank;
import com.project.ATM_simulator.model.bank.BankRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private Bank bank;
    private Wallet wallet;
    private User user;
    private BankRegistry bankRegistry;
    private Account account;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        wallet = new Wallet();
        account = new Account(1000.0);
        user = new User("bennybanan@gmail.com", 1234, "benny", wallet, account);
        bankRegistry = new BankRegistry();
        bank.addUser(user);
        bankRegistry.registerBank(bank);
    }

    @Test
    public void testAuthentication() {
        String expectedEmail = "bennybanan@gmail.com";
        int expectedPinCode = 1234;

        boolean trueIfAuthorized = bank.authenticate(expectedEmail, expectedPinCode);
        assertTrue(trueIfAuthorized, "Should pass with correct credentials");
    }

    @Test
    public void testAuthenticationFalse() {
        String faultyEmail = "faultybennybenassi@hotmail.com";
        int faultyPinCode = 4444;

        boolean falseIfNotAuthorized = bank.authenticate(faultyEmail, faultyPinCode);
        assertFalse(falseIfNotAuthorized, "Should pass with faulty credentials");
    }
}