package com.project.ATM_simulator.model.bank;

public class Account {

    private double accountBalance;

    public Account(double accountBalance) {

        this.accountBalance = accountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
