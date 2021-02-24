package com.bts.test.model;

import java.util.HashMap;

public class DataApi {

    private String currencyName;

    private String ratesDate;

    private HashMap<String,Object> exchangeRate;

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getRatesDate() {
        return ratesDate;
    }

    public void setRatesDate(String ratesDate) {
        this.ratesDate = ratesDate;
    }

    public HashMap<String, Object> getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(HashMap<String, Object> exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
