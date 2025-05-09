package com.project.ATM_simulator.app;

import com.project.ATM_simulator.model.*;
import com.project.ATM_simulator.model.bank.Account;
import com.project.ATM_simulator.model.bank.Bank;
import com.project.ATM_simulator.model.bank.BankRegistry;
import com.project.ATM_simulator.util.Utils;

import java.util.Scanner;

public class SetupEnvironment {

    public void initialize() {

        Wallet bennysWallet = new Wallet();
        Wallet fridasWallet = new Wallet();

        Account bennysAccount = new Account(10000);
        Account fridasAccount = new Account(15000);

        Currency currency = new Currency();

        Bank swedbank = new Bank();
        Bank handelsbanken = new Bank();

        User benny = new User("bennyandersson@gmail.com", 2879, "Benny", bennysWallet, bennysAccount);
        User frida = new User("fridasvensson@hotmail.com", 5931, "Frida", fridasWallet, fridasAccount);

        swedbank.addUser(benny);
        handelsbanken.addUser(frida);

        BankRegistry registry = new BankRegistry();
        registry.registerBank(swedbank);
        registry.registerBank(handelsbanken);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ange e-post: ");
        String email = Utils.stringInputScanner();
        System.out.print("Ange pinkod: ");
        int pinCode = Utils.intInputScanner();


        User loggedInUser = registry.authenticateUser(email, pinCode);
        if (loggedInUser != null) {
            Bank userBank = registry.getUserBank(loggedInUser);
            ATM atm = new ATM(loggedInUser, currency, userBank);
            System.out.println("Välkommen, " + loggedInUser.getName());

        } else {
            System.out.println("Fel inloggning!");
        }
    }
}
