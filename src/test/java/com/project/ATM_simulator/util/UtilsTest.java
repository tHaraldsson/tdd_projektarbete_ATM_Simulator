package com.project.ATM_simulator.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {



    @Test
    public void testEmailValidatorTrue() {

        String email = "bennybanan@gmail.com";
        boolean validEmail = Utils.emailValidator(email);

        assertTrue(validEmail);
    }

    @Test
    public void testEmailValidatorWithoutAt() {

        String email = "benny.mail.com";
        boolean inValidEmail = Utils.emailValidator(email);

        assertFalse(inValidEmail);
    }

    @Test
    public void testEmailValidatorWithoutDotAfterAt() {

        String email = "bennybanan@gmailcom";
        boolean inValidEmail = Utils.emailValidator(email);

        assertFalse(inValidEmail);
    }

    @Test
    public void testPinCodeValidatorTrue() {

        String pinCode = "1234";
        boolean validPinCode = Utils.pinCodeValidator(pinCode);
        assertTrue(validPinCode);
    }

    @Test
    public void testPinCodeValidatorIsNotInt() {

        String pinCode = "abcd";
        boolean invalidPincode = Utils.pinCodeValidator(pinCode);
        assertFalse(invalidPincode);
    }

    @Test
    public void testPinCodeValidatorContainsMoreThanFourDigits() {

        String pinCode = "12345";
        boolean invalidPincode = Utils.pinCodeValidator(pinCode);
        assertFalse(invalidPincode, "Should return false if pinCode contains more than four digits");
    }

    @Test
    public void testPinCodeValidatorContainsLessThanFourDigits() {

        String pinCode = "123";
        boolean invalidPincode = Utils.pinCodeValidator(pinCode);
        assertFalse(invalidPincode, "Should return false if pinCode contains less than four digits");
    }

}