package com.example.knowlage_calauter_f;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
      SQLiteDatabase go = this.getWritableDatabase();
      String ints = "Insert into "+TABLE_CALA + " values ('10/10' , 100)";

      go.execSQL(ints);
      go.close();
  }
    public void save_data2(int new_pay) {
        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "INSERT INTO " + TABLE_CALA +
                " (" + COLUMN_DATE + ", " + COLUMN_PAY + ") " +
                "VALUES (?, ?)";

        db.rawQuery(sql, new String[]{getCurrentDate(), String.valueOf(new_pay)});
        db.close();
    }

    public void save_data3(int new_pay) {
        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "INSERT INTO " + TABLE_CALA +
                " (" + COLUMN_DATE + ", " + COLUMN_PAY + ") " +
                "VALUES (?, ?)";

        db.execSQL(sql, new Object[]{getCurrentDate(), new_pay});
        db.close();
    }

    public void save_data4(int new_pay) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE, getCurrentDate());
        values.put(COLUMN_PAY, new_pay);

       db.insert(TABLE_CALA, null, values);
        db.close();
    }

    private String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date());
    }

}
