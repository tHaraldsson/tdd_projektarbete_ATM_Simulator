package com.project.ATM_simulator;

import com.project.ATM_simulator.model.ATM;
import com.project.ATM_simulator.model.Bank;
import com.project.ATM_simulator.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    @Test
    public void testViewUserBankBalance() {
        Bank bank = new Bank(1000.0);
        User user = new User(bank);
        ATM atm = new ATM(user);

        double balance = atm.viewUserBankBalance();
        assertEquals(1000.0, balance);
    }
}