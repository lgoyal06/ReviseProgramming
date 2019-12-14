package com.lalit.sapient.coding.problem.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    static final Map<String, BigDecimal> usdToCurrency = new HashMap<>();

    static {
        usdToCurrency.put("INR", new BigDecimal(66.00));
        usdToCurrency.put("USD", new BigDecimal(1.00));
        usdToCurrency.put("YEN", new BigDecimal(0.45));
    }

    public static BigDecimal toUSD(String currency, BigDecimal amount) {
        return amount.divide(usdToCurrency.get(currency),2, RoundingMode.HALF_EVEN);
    }
}
