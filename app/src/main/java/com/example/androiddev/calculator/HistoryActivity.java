package com.example.androiddev.calculator;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.example.androiddev.calculator.adapter.RecyclerViewAdapter;
import com.example.androiddev.calculator.util.HistoryKeeper;

/**
 * Created by KonstantinKlimov on 26.05.2017.
 */

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_landscape);
        RecyclerView historyView = (RecyclerView) findViewById(R.id.history_view);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        historyView.setLayoutManager(manager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(HistoryKeeper.getHistory());
        historyView.setAdapter(adapter);

    }
}
