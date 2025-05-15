package com.project.ATM_simulator.model;

import com.project.ATM_simulator.model.bank.BankRegistry;
import com.project.ATM_simulator.validation.IValidator;

public class Environment {
        public BankRegistry registry;
        public Currency currency;
        public IValidator emailValidator;
        public IValidator pinCodeValidator;

        public Environment(BankRegistry registry, Currency currency, IValidator emailValidator, IValidator pinCodeValidator) {
            this.registry = registry;
            this.currency = currency;
            this.emailValidator = emailValidator;
            this.pinCodeValidator = pinCodeValidator;
        }
    }


