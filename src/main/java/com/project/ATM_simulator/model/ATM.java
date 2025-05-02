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
        double newBalance = balance - withdraw;
        user.setAccountBalance(newBalance);
        return newBalance;
    }

    public double withdrawPocketBalance(double withdraw){
        double balance = user.getPocketBalance();
        double newBalance = balance + withdraw;
        user.setPocketBalance(newBalance);
        return newBalance;
    }

    public void withdraw(double withdraw){
        userBankAccountWithdrawal(withdraw);
        withdrawPocketBalance(withdraw);
    }
}
