package com.tomgehrke.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tomgehrke.habittracker.data.HabitContract.HabitAction;

public class HabitDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "habit_tracker.db";
    private static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // String to CREATE the Action table
        String SQL_CREATE_ACTION_TABLE = "CREATE TABLE " + HabitAction.TABLE_NAME + "("
                + HabitAction._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitAction.COLUMN_ACTION_NAME + " TEXT NOT NULL, "
                + HabitAction.COLUMN_ACTION_NOTE + " TEXT NOT NULL DEFAULT '', "
                + HabitAction.COLUMN_ACTION_START_TIME + " TIMESTAMP NOT NULL DEFAULT (datetime('now','localtime')), "
                + HabitAction.COLUMN_ACTION_END_TIME + " TIMESTAMP, "
                + HabitAction.COLUMN_ACTION_TYPE + " INTEGER NOT NULL DEFAULT 0, "
                + HabitAction.COLUMN_ACTION_KARMA + " INTEGER NOT NULL DEFAULT " + HabitAction.ACTION_KARMA_GOOD + ")";

        db.execSQL(SQL_CREATE_ACTION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // If we create a new version of the database, we'll handle modifying the schema here.
    }
}
