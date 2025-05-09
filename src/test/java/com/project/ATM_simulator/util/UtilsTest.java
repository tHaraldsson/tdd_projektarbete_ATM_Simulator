package com.project.ATM_simulator.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    public void testEmailValidatorTrue() {

        String email = "bennybanan@gmail.com";
        boolean validEmail = emailValidator(email);

        assertTrue(validEmail);
    }

    @Test
    public void testEmailValidatorWithoutAt() {

        String email = "benny.mail.com";
        boolean inValidEmail = emailValidator(email);

        assertFalse(inValidEmail);
    }

    @Test
    public void testEmailValidatorWithoutDotAfterAt() {

        String email = "bennybanan@gmailcom";
        boolean inValidEmail = emailValidator(email);

        assertFalse(inValidEmail);
    }

    @Test
    public void testPinCodeValidatorTrue() {

        int pinCode = 1234;
        boolean validPinCode = pinCodeValidator(pinCode);
        assertTrue(validPinCode);
    }

    @Test
    public void testPinCodeValidatorIsNotInt() {

        String pinCode = "abcd";
        boolean invalidPincode = pinCodeValidator(pinCode);
        assertFalse(invalidPincode);
    }

    @Test
    public void testPinCodeValidatorContainsMoreThanFourDigits() {

        int pinCode = 12345;
        boolean invalidPincode = pinCodeValidator(pinCode);
        assertFalse(invalidPincode, "Should return false if pinCode contains more than four digits");
    }

    @Test
    public void testPinCodeValidatorContainsLessThanFourDigits() {

        int pinCode = 123;
        boolean invalidPincode = pinCodeValidator(pinCode);
        assertFalse(invalidPincode, "Should return false if pinCode contains less than four digits");
    }

}