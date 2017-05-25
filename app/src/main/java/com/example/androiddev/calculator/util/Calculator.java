package com.example.androiddev.calculator.util;

import android.icu.math.BigDecimal;

/**
 * Created by KonstantinKlimov on 25.05.2017.
 */

public class Calculator {
    public String calculate(String argument, Operations operation) {
        BigDecimal value = new BigDecimal(argument);
        String result = "";
        switch (operation) {
            case SQRT: {
                double temp = Math.sqrt(Double.parseDouble(value.toString()));
                result = "" + temp;
                break;
            }
            case POW_2: {
                result = value.multiply(value).toString();
                break;
            }
            default:
                break;
        }
        return result;
    }

    public String calculate(String argument1, String argument2, Operations operation) {
        BigDecimal value1 = new BigDecimal(argument1);
        BigDecimal value2 = new BigDecimal(argument2);
        String result = "";
        switch (operation) {
            case ADD: {
                result = value1.add(value2).toString();
                break;
            }
            case SUBTRACT: {
                result = value1.subtract(value2).toString();
                break;
            }
            case MULTIPLY: {
                result = value1.multiply(value2).toString();
                break;
            }
            case DIVIDE: {
                if ("0".equals(value2)) {
                    result = "Illegal operation.";
                } else {
                    result = value1.divide(value2, 5, BigDecimal.ROUND_HALF_UP).toString();
                }
                break;
            }
            case POW_Y: {
                result = value1.pow(value2).toString();
                break;
            }
            default:
                break;
        }
        return result;
    }
}
