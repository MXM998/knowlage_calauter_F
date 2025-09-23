package com.example.knowlage_calauter_f;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Save_cala  extends SQLiteOpenHelper {

    private static  String DATABASE_NAME = "MXM_calac";
    private static  int DATABASE_VERSION = 1;

    public static final String TABLE_CALA = "CALAUTER";
    public static final String COLUMN_ID_CALA = "CL_ID";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_PAY = "pay";

    public Save_cala(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        String create_table =  "CREATE TABLE " + TABLE_CALA + "("
                + COLUMN_ID_CALA + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_DATE + " TEXT, "
                + COLUMN_PAY + " INTEGER)";
        DB.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_CALA);
        onCreate(DB);
    }

  public  void save_data(int new_pay)
  {

  }
}
