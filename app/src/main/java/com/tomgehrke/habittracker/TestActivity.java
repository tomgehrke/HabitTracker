package com.tomgehrke.habittracker;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button insertButton = (Button) findViewById(R.id.insert_button);
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HabitMethods.insertSampleData(TestActivity.this);
            }
        });

        Button selectButton = (Button) findViewById(R.id.select_button);
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor goodHabits= HabitMethods.getGoodHabits(TestActivity.this);

                TextView outputTextView = (TextView) findViewById(R.id.output_textview);

                outputTextView.setText("name - type\n");
                while (goodHabits.moveToNext()) {
                    outputTextView.append(goodHabits.getString(0) + "-" + goodHabits.getInt(1) + "\n");
                }
            }
        });
    }
}
