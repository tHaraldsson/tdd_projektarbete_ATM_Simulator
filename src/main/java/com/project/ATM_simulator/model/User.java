package com.project.ATM_simulator.model;

public class User {
    Bank bank;

    public User(Bank bank) {
        this.bank = bank;
    }

    public double getAccountBalance() {
        return bank.getAccountBalance();
    }
}
