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
        if (balance < withdraw) {
            return balance; // Återvänd det ursprungliga saldot om uttaget misslyckas
        } else {

            double newBalance = balance - withdraw;
            user.setAccountBalance(newBalance);
            return newBalance;
        }
    }

    public void addToWallet(CurrencyType currencyType, double withdraw) {
        Map<CurrencyType, Double> walletMap = user.getWalletBalancesMap();
        double exchangeBalance = currencyExchange(currencyType, withdraw);
        double newBalance = walletMap.getOrDefault(currencyType, 0.0) + exchangeBalance;
        walletMap.put(currencyType, newBalance);
        System.out.println("Du växlade " + withdraw + " SEK till " + exchangeBalance + " " + currencyType);
    }

    public void withdraw(CurrencyType currencyType, double withdraw) {

        // Först kontrollera om uttaget kan genomföras baserat på kontosaldot
                userBankAccountWithdrawal(withdraw);
        if (withdraw > user.getAccountBalance()) {
            System.out.println("Otillräckligt saldo. Du kan inte ta ut mer än du har på kontot.");
        } else {
            addToWallet(currencyType, withdraw); // Lägg till växlat belopp till plånboken
        }
    }

    public double currencyExchange(CurrencyType type, double withdraw) {
        double currencyValue = currency.getExchangeRate(type);
        return withdraw * currencyValue;
    }

    public void getWalletBalancesToString() {
        user.getWalletBalancesToString();
    }

}
