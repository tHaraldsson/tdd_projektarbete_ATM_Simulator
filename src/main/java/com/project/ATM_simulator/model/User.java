package com.project.ATM_simulator.model;

public class User {
    private Bank bank;
    private double pocketBalance;

    public User(Bank bank, double pocketBalance) {
        this.bank = bank;
        this.pocketBalance = pocketBalance;
    }

    public double getAccountBalance() {
        return bank.getAccountBalance();
    }

    public double getPocketBalance() {
        return pocketBalance;
    }

    public void setPocketBalance(double pocketBalance) {
        this.pocketBalance = pocketBalance;
    }
}
