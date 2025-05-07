package com.project.ATM_simulator.model;

import com.project.ATM_simulator.enums.CurrencyType;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Currency {

    private final Map<CurrencyType, Double> exchangeRates;


    public Currency() {
        exchangeRates = new EnumMap<>(CurrencyType.class);
        exchangeRates.put(CurrencyType.USD, 0.1037);
        exchangeRates.put(CurrencyType.EUR, 0.087);
        exchangeRates.put(CurrencyType.GBP, 0.074);
        exchangeRates.put(CurrencyType.SEK, 1.0);
    }

    public double getExchangeRate(CurrencyType currencyType) {
        return exchangeRates.get(currencyType);
    }



}
