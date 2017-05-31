package com.example.androiddev.calculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.androiddev.calculator.adapter.RecyclerViewAdapter;
import com.example.androiddev.calculator.entity.HistoryItem;
import com.example.androiddev.calculator.util.DBHelper;
import com.example.androiddev.calculator.util.HistoryKeeper;
import com.example.androiddev.calculator.util.RecyclerItemClickListener;

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
        final ArrayList<HistoryItem> history = new ArrayList<>();
        final DBHelper dbHelper = new DBHelper(historyView.getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.query("calcHistory", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            int idColIndex = c.getColumnIndex("id");
            int dateColIndex = c.getColumnIndex("date");
            int expressionColIndex = c.getColumnIndex("expression");
            int resultColIndex = c.getColumnIndex("result");
            do {
                int id = c.getInt(idColIndex);
                String date = c.getString(dateColIndex);
                String expression = c.getString(expressionColIndex);
                String result = c.getString(resultColIndex);
                history.add(new HistoryItem(id ,date, expression, result));
            } while (c.moveToNext());
        }
        db.close();
        final RecyclerViewAdapter adapter = new RecyclerViewAdapter(history);
        historyView.setAdapter(adapter);
        historyView.addOnItemTouchListener(new RecyclerItemClickListener(historyView.getContext(), historyView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String expression = ((TextView) view.findViewById(R.id.expression_text_view)).getText().toString();
                Intent intent = new Intent();
                intent.putExtra("expression", expression);
                setResult(RESULT_OK, intent);
                finish();
            }

            @Override
            public void onLongItemClick(final View view, final int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder
                        .setMessage(R.string.confirm_delete)
                        .setCancelable(false)
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String expression = ((TextView) view.findViewById(R.id.expression_text_view)).getText().toString();
                                SQLiteDatabase db = dbHelper.getWritableDatabase();
                                HistoryItem hi = history.get(position);
                                //db.execSQL("delete from "+ "calcHistory");

                                Log.i("debug", "id element for deleting =" + hi.getId());
                                Log.i("debug", "position =" + position);

                                int id = db.delete("calcHistory", "id" + "=" + hi.getId(), null);
                                Log.i("debug", "deleting .. id =" + id);

                                db.close();
                                adapter.notifyItemRemoved(position);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        }));
    }
}
