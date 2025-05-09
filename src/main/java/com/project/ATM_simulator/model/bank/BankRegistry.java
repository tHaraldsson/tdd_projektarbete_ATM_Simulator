package com.project.ATM_simulator.model.bank;

import com.project.ATM_simulator.model.User;

import java.util.ArrayList;
import java.util.List;

public class BankRegistry {
    private List<Bank> banks = new ArrayList<>();

    public void registerBank(Bank bank) {
        banks.add(bank);
    }

    public User authenticateUser(String email, int pinCode) {
        for (Bank bank : banks) {
            if (bank.authenticate(email, pinCode)) {
                return bank.getUsers().get(email);
            }
        }
        return null;
    }

    public Bank getUserBank(User user) {
        for (Bank bank : banks) {
            if (bank.getUsers().containsValue(user)) {
                return bank;
            }
        }
        return null;
    }
}
