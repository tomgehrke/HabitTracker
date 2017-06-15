package com.tomgehrke.habittracker.data;

import android.provider.BaseColumns;

public class HabitContract {

    private HabitContract() {} // Non-instantiable

    public static final class HabitAction
            implements BaseColumns {

        // Action table definition
        public static final String TABLE_NAME = "action";

        // Action columns
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_ACTION_NAME = "name";
        public static final String COLUMN_ACTION_NOTE = "note";
        public static final String COLUMN_ACTION_START_TIME = "startTime";
        public static final String COLUMN_ACTION_END_TIME = "endTime";
        public static final String COLUMN_ACTION_TYPE = "type";
        public static final String COLUMN_ACTION_KARMA = "karma";

        // Action type values
        public static final int ACTION_TYPE_GENERAL = 0;
        public static final int ACTION_TYPE_CREATIVE = 1;
        public static final int ACTION_TYPE_DIET = 2;
        public static final int ACTION_TYPE_EDUCATION = 3;
        public static final int ACTION_TYPE_FITNESS = 4;

        // Action karma values
        public static final int ACTION_KARMA_BAD = -1;
        public static final int ACTION_KARMA_GOOD = 1;
    }
}
