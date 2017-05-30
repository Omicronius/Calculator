package com.example.androiddev.calculator;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.androiddev.calculator.adapter.RecyclerViewAdapter;
import com.example.androiddev.calculator.entity.HistoryItem;
import com.example.androiddev.calculator.util.DBHelper;
import com.example.androiddev.calculator.util.HistoryKeeper;

import java.util.ArrayList;

/**
 * Created by KonstantinKlimov on 26.05.2017.
 */

public class HistoryActivity extends AppCompatActivity {
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_landscape);
        RecyclerView historyView = (RecyclerView) findViewById(R.id.history_view);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        historyView.setLayoutManager(manager);
        ArrayList<HistoryItem> history = new ArrayList<>();
        DBHelper dbHelper = new DBHelper(historyView.getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.query("calcHistory", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            int dateColIndex = c.getColumnIndex("date");
            int expressionColIndex = c.getColumnIndex("expression");
            int resultColIndex = c.getColumnIndex("result");
            do {
                String date = c.getColumnName(dateColIndex);
                String expression = c.getColumnName(expressionColIndex);
                String result = c.getColumnName(resultColIndex);
                HistoryItem hi = new HistoryItem(date, expression, result);
                history.add(hi);
            } while (c.moveToNext());
        }
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(history);
        historyView.setAdapter(adapter);
    }
}
