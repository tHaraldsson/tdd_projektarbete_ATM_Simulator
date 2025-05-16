package com.project.ATM_simulator.model;

import com.project.ATM_simulator.enums.CurrencyType;
import com.project.ATM_simulator.model.bank.Account;

import java.util.Map;

public class User {

    private String email;
    private int pinCode;
    private String name;
    private Wallet wallet;
    private Account account;

    public User(String email, int pinCode, String name, Wallet wallet, Account account) {
        this.email = email;
        this.pinCode = pinCode;
        this.name = name;
        this.wallet = wallet;
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public int getPinCode() {
        return pinCode;
    }

    public String getName() {
        return name;
    }

    public double getAccountBalance(){
        return account.getAccountBalance();
    }

    public void setAccountBalance(double balance){
        account.setAccountBalance(balance);
    }

    public void getWalletBalancesToString() {
        Map<CurrencyType, Double> balances = wallet.getBalances();
        System.out.println("Du har: ");
        for (Map.Entry<CurrencyType, Double> balance : balances.entrySet()) {
            System.out.println(balance.getKey() + ": " + balance.getValue());
        }
    }

    public Map<CurrencyType, Double> getWalletBalancesMap() {
        return wallet.getBalances();
    }
}
