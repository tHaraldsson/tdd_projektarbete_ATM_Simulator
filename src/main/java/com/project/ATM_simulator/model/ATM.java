package com.project.ATM_simulator.model;

public class ATM {
    private User user;

    public ATM(User user) {
        this.user = user;
    }

    public double viewUserBankBalance() {
       return user.getAccountBalance();
    }
}
