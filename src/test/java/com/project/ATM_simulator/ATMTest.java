package com.project.ATM_simulator;

import com.project.ATM_simulator.model.ATM;
import com.project.ATM_simulator.model.Bank;
import com.project.ATM_simulator.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    private Bank bank;
    private User user;
    private ATM atm;

    @BeforeEach
    void setUp() {
       bank = new Bank(1000.0);
       user = new User(bank, 0);
       atm = new ATM(user);
    }

    @Test
    public void testViewUserBankBalance() {
        double balance = atm.viewUserBankBalance();
        assertEquals(1000.0, balance);
    }

    @Test
    public void testUserBankAccountWithdrawal() {
        double bankAccountBalance = atm.viewUserBankBalance();
        double withdraw = 100;
        double bankAccountAfterWithdrawal = atm.userBankAccountWithdrawal(withdraw);
        assertEquals(bankAccountBalance - withdraw, bankAccountAfterWithdrawal);
    }

    @Test
    public void testUserAddPocketBalance() {
    double pocketBalance = user.getPocketBalance();
    double withdraw = 100;
    double pocketBalanceAfterWithdrawal = atm.withdrawPocketBalance(withdraw);
    assertEquals(pocketBalance + withdraw, pocketBalanceAfterWithdrawal);
    }

}