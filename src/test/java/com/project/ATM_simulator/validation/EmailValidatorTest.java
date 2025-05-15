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

class EmailValidatorTest {

    private IValidator emailValidator;

    @BeforeEach
    void setUp() {
        emailValidator = new EmailValidator();
    }

    @Test
    public void testEmailValidatorTrue() {

        String email = "bennybanan@gmail.com";
        boolean validEmail = emailValidator.validate(email);

        assertTrue(validEmail);
    }

    @Test
    public void testEmailValidatorWithoutAt() {

        String email = "benny.mail.com";
        boolean inValidEmail = emailValidator.validate(email);

        assertFalse(inValidEmail);
    }

    @Test
    public void testEmailValidatorWithoutDotAfterAt() {

        String email = "bennybanan@gmailcom";
        boolean inValidEmail = emailValidator.validate(email);

        assertFalse(inValidEmail);
    }
}