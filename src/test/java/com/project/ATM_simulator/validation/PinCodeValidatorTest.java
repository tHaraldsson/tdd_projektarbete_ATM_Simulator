package com.project.ATM_simulator.validation;

import com.project.ATM_simulator.model.User;
import com.project.ATM_simulator.model.Wallet;
import com.project.ATM_simulator.model.bank.Account;
import com.project.ATM_simulator.model.bank.Bank;
import com.project.ATM_simulator.model.bank.BankRegistry;
import com.project.ATM_simulator.util.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PinCodeValidatorTest {

    private IValidator pinCodeValidator;

    @BeforeEach
    void setUp() {
        pinCodeValidator = new PinCodeValidator();
    }

    @Test
    public void testPinCodeValidatorTrue() {

        String pinCode = "1234";
        boolean validPinCode = pinCodeValidator.validate(pinCode);
        assertTrue(validPinCode);
    }

    @Test
    public void testPinCodeValidatorIsNotInt() {

        String pinCode = "abcd";
        boolean invalidPincode = pinCodeValidator.validate(pinCode);
        assertFalse(invalidPincode);
    }

    @Test
    public void testPinCodeValidatorContainsMoreThanFourDigits() {

        String pinCode = "12345";
        boolean invalidPincode = pinCodeValidator.validate(pinCode);
        assertFalse(invalidPincode, "Should return false if pinCode contains more than four digits");
    }

    @Test
    public void testPinCodeValidatorContainsLessThanFourDigits() {

        String pinCode = "123";
        boolean invalidPincode = pinCodeValidator.validate(pinCode);
        assertFalse(invalidPincode, "Should return false if pinCode contains less than four digits");
    }

}