package com.project.ATM_simulator.app;

import com.project.ATM_simulator.enums.CurrencyType;
import com.project.ATM_simulator.model.*;
import com.project.ATM_simulator.model.bank.Account;
import com.project.ATM_simulator.model.bank.Bank;
import com.project.ATM_simulator.model.bank.BankRegistry;
import com.project.ATM_simulator.util.Utils;
import com.project.ATM_simulator.validation.EmailValidator;
import com.project.ATM_simulator.validation.IValidator;
import com.project.ATM_simulator.validation.PinCodeValidator;

public class ATMSimulator {

    public Environment setupEnvironment() {

        Wallet bennysWallet = new Wallet();
        Wallet fridasWallet = new Wallet();

        Account bennysAccount = new Account(10000);
        Account fridasAccount = new Account(15000);

        Currency currency = new Currency();

        Bank swedbank = new Bank();
        Bank handelsbanken = new Bank();

        User benny = new User("bennyandersson@gmail.com", 2879, "Benny", bennysWallet, bennysAccount);
        User frida = new User("fridasvensson@hotmail.com", 5931, "Frida", fridasWallet, fridasAccount);

        IValidator pinCodeValidator = new PinCodeValidator();
        IValidator emailValidator = new EmailValidator();

        swedbank.addUser(benny);
        handelsbanken.addUser(frida);

        BankRegistry registry = new BankRegistry();
        registry.registerBank(swedbank);
        registry.registerBank(handelsbanken);

        return new Environment(registry, currency, emailValidator, pinCodeValidator);


    }

    public ATM loginATM(BankRegistry registry, Currency currency, IValidator emailValidator, IValidator pinCodeValidator) {
        int attemptsWithFourDigits = 0;
        int attemptsWithWrongDigits = 0;
        final int MAX_ATTEMPTS = 3;
        boolean running = true;
        while (running) {
            // E-postvalidering
            String email;
            do {
                System.out.print("Ange e-post: ");
                email = Utils.stringInputScanner();
            } while (!emailValidator.validate(email));

            // Pinkodsvalidering
            String stringPincode;
            int intPinCode;


            // Körs så länge pinCodeValidator returnerar false
            do {
                System.out.print("Ange pinkod: ");
                // Returnerar en String
                stringPincode = Utils.stringInputScanner();
                attemptsWithWrongDigits++;

                if (attemptsWithWrongDigits >= MAX_ATTEMPTS || attemptsWithFourDigits >= MAX_ATTEMPTS) {
                    System.out.println("För många felaktiga försök. Avslutar.");
                    return null;
                }
// TODO GÖR OM SKITEN TILL EN METOD (NEDAN)
            } while (!pinCodeValidator.validate(stringPincode) && (attemptsWithWrongDigits < MAX_ATTEMPTS || attemptsWithFourDigits < MAX_ATTEMPTS));
            // Parsar en String och returnerar int
            intPinCode = Utils.intParser(stringPincode);

            User loggedInUser = registry.authenticateUser(email, intPinCode);
            if (loggedInUser != null) {
                System.out.println("Välkommen, " + loggedInUser.getName());
                return new ATM(loggedInUser, currency, registry.getUserBank(loggedInUser));
            } else {
                System.out.println("Användaren hittades inte. Vänligen kontrollera att du angivit rätt e-post och pinkod");
                attemptsWithFourDigits++;
            }
        }
        return null;
    }

    public void interact(ATM ATMWithLoggedInUser) {

        boolean running = true;
        while (running) {

            System.out.println("Vad vill du ha hjälp med?");
            System.out.println("1) Ta ut pengar (USD/EUR/GBP/SEK)");
            System.out.println("2) Se saldo på konto");
            System.out.println("3) Se saldo i plånbok");
            System.out.println("4) Avsluta");
            String stringUserInput = Utils.stringInputScanner();
            String parseUserInput;
            double doubleUserInput;
            switch (stringUserInput) {

                case "1" -> {
                    System.out.println("Vilken valuta vill du ta ut pengar i? (USD, EUR, GBP, SEK): ");
                    String currencyInput = Utils.stringInputScanner().toUpperCase();

                    try {
                        CurrencyType selectedCurrency = CurrencyType.valueOf(currencyInput);
                        System.out.println("Hur mycket SEK vill du växla?");
                        parseUserInput = Utils.stringInputScanner();
                        doubleUserInput = Utils.doubleParser(parseUserInput);

                        ATMWithLoggedInUser.withdraw(selectedCurrency, doubleUserInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ogiltig valutainmatning.");
                    }

                }
                case "2" -> {
                    System.out.println("Du har " + ATMWithLoggedInUser.getAccountBalance() + "kr på kontot");
                }
                case "3" -> {
                    ATMWithLoggedInUser.getWalletBalancesToString();
                }
                case "4" -> {
                    System.out.println("Avslutar...");
                    running = false;
                }

            }
        }

    }

    public void runEnvironment() {

        Environment env = setupEnvironment();
        ATM ATMWithLoggedInUser = loginATM(env.registry, env.currency, env.emailValidator, env.pinCodeValidator);
        interact(ATMWithLoggedInUser);

    }

}
