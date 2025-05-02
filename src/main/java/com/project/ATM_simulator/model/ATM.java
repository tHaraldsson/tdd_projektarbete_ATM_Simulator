package com.project.ATM_simulator.model;

public class ATM {
    private Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public double checkBankBalance() {
       return bank.getAccountBalance();
    }
}
