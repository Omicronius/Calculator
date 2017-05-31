package com.example.androiddev.calculator.entity;

import java.util.Date;

/**
 * Created by KonstantinKlimov on 29.05.2017.
 */

public class HistoryItem {
    int id;
    private String date;
    private String expression;
    private String result;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HistoryItem(int id, String date, String expression, String result) {
        this.id = id;
        this.date = date;
        this.expression = expression;
        this.result = result;
    }

    public HistoryItem(String date, String expression, String result) {
        this.date = date;
        this.expression = expression;
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public String getExpression() {
        return expression;
    }

    public String getResult() {
        return result;
    }
}
