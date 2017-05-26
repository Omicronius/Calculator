package com.example.androiddev.calculator;

import android.app.Activity;
import android.content.res.Configuration;
import android.widget.ListView;

/**
 * Created by KonstantinKlimov on 26.05.2017.
 */

public class HistoryActivity extends Activity {
    ListView listView;
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.history);
        } else {
            setContentView(R.layout.history_landscape);
        }
        listView = (ListView) findViewById(R.id.historyList);
    }
}
