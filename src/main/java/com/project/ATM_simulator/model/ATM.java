package com.project.ATM_simulator.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATM {
    private User user;
    private Currency currency;

    public ATM(User user, Currency currency) {
        this.user = user;
        this.currency = currency;
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

    public double addToPocketBalance(double withdraw){
        double balance = user.getPocketBalance();
        double newBalance = balance + withdraw;
        user.setPocketBalance(newBalance);
        return newBalance;
    }

    public void withdraw(double withdraw){
        userBankAccountWithdrawal(withdraw);
        addToPocketBalance(withdraw);
    }

    public double currencyExchange(double withdraw, String keyValue){

        Map<String, Double> currencyMap = new HashMap();
        currencyMap.put("USD", getUSDCurrency());
        currencyMap.put("EUR", getEURCurrency());
        currencyMap.put("GBP", getGBPCurrency());
        currencyMap.put("SEK", getSEKCurrency());

        double currencyValue = currencyMap.get(keyValue);
        double newCurrencyValue = withdraw * currencyValue;

        return newCurrencyValue;
    }

    public double getGBPCurrency(){
        return currency.getGbp();
    }
    public double getEURCurrency(){
        return currency.getEur();
    }
    public double getUSDCurrency(){
        return currency.getUsd();
    }
    public double getSEKCurrency(){
        return currency.getSek();
    }
}
