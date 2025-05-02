package com.project.ATM_simulator;

import com.project.ATM_simulator.model.ATM;
import com.project.ATM_simulator.model.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    @Test
    public void testCheckBankBalance() {
        Bank bank = new Bank(1000.0);
        ATM atm = new ATM(bank);

        double balance = atm.checkBankBalance();
        assertEquals(1000.0, balance);
    }

    @Test
    public void testCheckBankBalanceWithUser() {
        Bank bank = new Bank(1000.0);
        User user = new User(bank);
        ATM atm = new ATM(user);

        double balance = atm.checkUserBalance();
        assertEquals(1000.0, balance);

    }
}