package com.project.ATM_simulator.validation;

public class EmailValidator implements IValidator {
    @Override
    public boolean validate(String email) {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            System.out.println("Något gick fel. Mailadressen måste innehålla '@' och '.'");
            return false;
        }

        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');

        if (atIndex > 0 && dotIndex > atIndex + 1 && dotIndex < email.length() - 1) {
            return true;
        } else {
            System.out.println("Kontrollera att @ kommer före sista punkten, och inte först eller sist");
            return false;
        }
    }
}
