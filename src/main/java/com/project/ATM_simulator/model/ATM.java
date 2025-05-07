package com.project.ATM_simulator.model;

import com.project.ATM_simulator.auth.Authentication;
import com.project.ATM_simulator.enums.CurrencyType;

import java.util.Map;

public class ATM {
    private User user;
    private Currency currency;
    private Authentication auth;


    public ATM(User user, Currency currency, Authentication auth) {
        this.auth = auth;
        this.user = user;
        this.currency = currency;
    }

    public double viewUserBankBalance() {
        return user.getAccountBalance();
    }

    public double userBankAccountWithdrawal(double withdraw) {
        double balance = viewUserBankBalance();
        double newBalance = balance - withdraw;
        user.setAccountBalance(newBalance);
        return newBalance;
    }

   public void addToWallet(CurrencyType currencyType, double withdraw) {
        Map walletMap = user.getWalletBalancesMap();
        double newBalance = currencyExchange(currencyType, withdraw);
        walletMap.put(currencyType, newBalance);
    }

    public void withdraw(CurrencyType currencyType, double withdraw) {
        userBankAccountWithdrawal(withdraw);
        addToWallet(currencyType, withdraw);
    }

    public double currencyExchange(CurrencyType type, double withdraw) {

        double currencyValue = currency.getExchangeRate(type);
        double newCurrencyValue = withdraw * currencyValue;

        return newCurrencyValue;
    }

   public boolean authenticateUser (String email, int pinCode, User user) {

        return auth.authenticate(email, pinCode, user);

   }

}
