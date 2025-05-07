package com.project.ATM_simulator.model;

import com.project.ATM_simulator.enums.CurrencyType;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Wallet {

        private final Map<CurrencyType, Double> balances;


        public Wallet() {
            balances = new EnumMap<>(CurrencyType.class);
        }

        public Map<CurrencyType, Double> getBalances() {
            return balances;
        }
    }

