package com.project.ATM_simulator.model;

import com.project.ATM_simulator.enums.CurrencyType;
import com.project.ATM_simulator.model.bank.Bank;

import java.util.Map;

public class ATM {
    private User user;
    private Currency currency;
    private Bank bank;

    public ATM(User user, Currency currency, Bank bank) {
        this.user = user;
        this.currency = currency;
        this.bank = bank;
    }

    public double getAccountBalance() {
        return bank.getAccountBalance(user);
    }

    public double userBankAccountWithdrawal(double withdraw) {
        double balance = getAccountBalance();
        double newBalance = balance - withdraw;
        user.setAccountBalance(newBalance);
        return newBalance;
    }

    public void addToWallet(CurrencyType currencyType, double withdraw) {
        Map<CurrencyType, Double> walletMap = user.getWalletBalancesMap();
        double newBalance = currencyExchange(currencyType, withdraw);
        walletMap.put(currencyType, newBalance);
    }

    public void withdraw(CurrencyType currencyType, double withdraw) {
        userBankAccountWithdrawal(withdraw);
        addToWallet(currencyType, withdraw);
    }

    public double currencyExchange(CurrencyType type, double withdraw) {
        double currencyValue = currency.getExchangeRate(type);
        return withdraw * currencyValue;
    }

}
