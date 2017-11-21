package com.example.robin.attackontitan; /**
 * Created by robin on 26.10.2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "Log_DB";
    public static String TABLE_Name = "Einträge";
    public static String Colum_1 = "ID";
    public static String Colum_2 = "BETREFF";
    public static String Colum_3 = "DATE";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS" + DATABASE_NAME + "(" + Colum_1 + " INTEGER PRIMARY KEY AUTOINCREMENT" + ", " + Colum_2 + " TEXT, " + Colum_3 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Name);
    }

    public void insertData(String betreff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(Colum_2, betreff);
        db.insert(TABLE_Name, null, c );

    }

}
