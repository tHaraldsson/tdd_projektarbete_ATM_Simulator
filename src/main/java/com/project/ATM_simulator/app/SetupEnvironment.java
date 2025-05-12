package com.project.ATM_simulator.app;

import com.project.ATM_simulator.model.*;
import com.project.ATM_simulator.model.bank.Account;
import com.project.ATM_simulator.model.bank.Bank;
import com.project.ATM_simulator.model.bank.BankRegistry;
import com.project.ATM_simulator.util.Utils;

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


        loginATM (registry, currency);

    }

    public void loginATM(BankRegistry registry, Currency currency) {

        boolean running = true;
        while (running) {
            // E-postvalidering
            String email;
            do {
                System.out.print("Ange e-post: ");
                email = Utils.stringInputScanner();
            } while (!Utils.emailValidator(email));

            // Pinkodsvalidering
            String stringPincode;
            int intPincode;
            int attempts = 0;
            final int MAX_ATTEMPTS = 3;

            // Körs så länge pinCodeValidator returnerar false
            do {
                System.out.print("Ange pinkod: ");
                // Returnerar en String
                stringPincode = Utils.stringInputScanner();
                attempts++;

                if (attempts >= MAX_ATTEMPTS) {
                    System.out.println("För många felaktiga försök. Avslutar.");
                return;
                }

            } while (!Utils.pinCodeValidator(stringPincode) && attempts < MAX_ATTEMPTS);
            // Parsar en String och returnerar int
            int intPinCode = Utils.intParser(stringPincode);

            User loggedInUser = registry.authenticateUser(email, intPinCode);
            if (loggedInUser != null) {
                System.out.println("Välkommen, " + loggedInUser.getName());
                ATM ATMWithLoggedInUser = new ATM(loggedInUser, currency, registry.getUserBank(loggedInUser));
                interact(ATMWithLoggedInUser);
                running = false;
            } else {
                System.out.println("Användaren hittades inte. Vänligen kontrollera att du angivit rätt e-post och pinkod");
            }
        }
    }

    
}
