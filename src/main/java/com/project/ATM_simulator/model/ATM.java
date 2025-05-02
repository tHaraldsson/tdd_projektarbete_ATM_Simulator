package com.project.ATM_simulator.model;

public class ATM {
    private User user;

    public ATM(User user) {
        this.user = user;
    }

    public double viewUserBankBalance() {
       return user.getAccountBalance();
    }

    public double userBankAccountWithdrawal(double withdraw){
        double balance = viewUserBankBalance();
        return balance - withdraw;
    }
}
