package com.project.ATM_simulator.validation;

public class PinCodeValidator implements IValidator {
    @Override
    public boolean validate(String pinCode) {
        if (pinCode != null && pinCode.length() == 4 && pinCode.matches("\\d+")) {
            return true;
        } else {
            System.out.println("Ett fel har inträffat. Pinkoden måste vara 4 siffror");
            return false;
        }
    }
}
