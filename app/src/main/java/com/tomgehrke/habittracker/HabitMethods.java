package com.tomgehrke.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.tomgehrke.habittracker.data.HabitContract.HabitAction;
import com.tomgehrke.habittracker.data.HabitDbHelper;

public class HabitMethods {

    private HabitMethods() {} // Non-instantiable

    public static void insertSampleData(Context context) {

        HabitDbHelper dbHelper = new HabitDbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long insertResult;

        ContentValues actionValues = new ContentValues();

        // Drinking water example
        actionValues.put(HabitAction.COLUMN_ACTION_NAME, "Drink Water");
        actionValues.put(HabitAction.COLUMN_ACTION_TYPE, HabitAction.ACTION_TYPE_DIET);
        actionValues.put(HabitAction.COLUMN_ACTION_KARMA, HabitAction.ACTION_KARMA_GOOD);

        insertResult = db.insert(HabitAction.TABLE_NAME, null, actionValues);

        if (insertResult == -1) {
            Log.e("InsertSampleData", "There was a problem creating the water drinking example.");
        }

        actionValues.clear();

        // Exercise example
        actionValues.put(HabitAction.COLUMN_ACTION_NAME, "Exercise");
        actionValues.put(HabitAction.COLUMN_ACTION_TYPE, HabitAction.ACTION_TYPE_FITNESS);
        actionValues.put(HabitAction.COLUMN_ACTION_START_TIME, "2017-06-13 12:00:00");
        actionValues.put(HabitAction.COLUMN_ACTION_END_TIME, "2017-06-13 12:30:00");
        actionValues.put(HabitAction.COLUMN_ACTION_KARMA, HabitAction.ACTION_KARMA_GOOD);

        insertResult = db.insert(HabitAction.TABLE_NAME, null, actionValues);

        if (insertResult == -1) {
            Log.e("InsertSampleData", "There was a problem creating the exercise example.");
        }

        actionValues.clear();

        // Smoking example
        actionValues.put(HabitAction.COLUMN_ACTION_NAME, "Smoke");
        actionValues.put(HabitAction.COLUMN_ACTION_NOTE, "Had a really bad day. :(");
        actionValues.put(HabitAction.COLUMN_ACTION_KARMA, HabitAction.ACTION_KARMA_BAD);

        insertResult = db.insert(HabitAction.TABLE_NAME, null, actionValues);

        if (insertResult == -1) {
            Log.e("InsertSampleData", "There was a problem creating the smoking example.");
        }

        actionValues.clear();
    }

    public static Cursor getGoodHabits(Context context) {
        HabitDbHelper dbHelper = new HabitDbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] columns = new String[]{
                HabitAction.COLUMN_ACTION_NAME,
                HabitAction.COLUMN_ACTION_TYPE
        };

        String selection = HabitAction.COLUMN_ACTION_KARMA + "=?";
        String[] selectionArgs = new String[]{String.valueOf(HabitAction.ACTION_KARMA_GOOD)};

        Cursor goodHabits = db.query(
                HabitAction.TABLE_NAME,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        return goodHabits;
    }
}
