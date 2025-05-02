package com.project.ATM_simulator;

import com.project.ATM_simulator.model.ATM;
import com.project.ATM_simulator.model.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

@Test
    public void testCheckBalance(){
        Bank bank = new Bank(1000.0);
        ATM atm = new ATM(bank);

        double balance = atm.checkBalance();
        assertEquals(1000.0, balance);
    }
}