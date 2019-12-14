package com.lalit.sapient.coding.problem.model;

import java.math.BigDecimal;

public class InputFields {

    String country;
    String city;
    String currency;

    public InputFields(String country, String city, String currency, BigDecimal amount, String gender) {
        this.country = country;
        this.city = city;
        this.currency = currency;
        this.amount = amount;
        this.gender = gender;
    }

    BigDecimal amount;
    String gender;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
