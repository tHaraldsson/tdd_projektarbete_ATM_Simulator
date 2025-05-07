package com.project.ATM_simulator.model;

import com.project.ATM_simulator.enums.CurrencyType;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String email;
    private int pinCode;

    private Bank bank;
    private Wallet wallet;

    public User(Bank bank, Wallet wallet, String email, int pinCode) {
        this.email = email;
        this.pinCode = pinCode;
        this.bank = bank;
        this.wallet = wallet;
    }

    public String getEmail() {
        return email;
    }
    public int getPinCode() {
        return pinCode;
    }

    public String getWalletBalancesToString() {
        Map<CurrencyType, Double> balances = wallet.getBalances();

        for (Map.Entry<CurrencyType, Double> balance : balances.entrySet()) {
            System.out.println(balance.getKey() + ": " + balance.getValue());
        }

        return balances.toString();
    }

    public Map<CurrencyType, Double> getWalletBalancesMap() {
        return wallet.getBalances();
    }

    public double getAccountBalance() {
        return bank.getAccountBalance();
    }

    public void setAccountBalance(double accountBalance) {
        bank.setAccountBalance(accountBalance);
    }
}
