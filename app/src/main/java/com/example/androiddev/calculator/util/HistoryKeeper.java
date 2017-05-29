package com.example.androiddev.calculator.util;

import com.example.androiddev.calculator.entity.HistoryItem;

import java.util.ArrayList;

/**
 * Created by KonstantinKlimov on 29.05.2017.
 */

public class HistoryKeeper {
    public static ArrayList<HistoryItem> historyItems = new ArrayList<>();

    public static void addHistoryItem(HistoryItem item) {
        historyItems.add(item);
    }

    public static ArrayList getHistory() {
        return historyItems;
    }
}
