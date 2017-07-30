package com.example.user.junier;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by user on 2017-07-29.
 */

public class Datebase extends SQLiteOpenHelper {
    public static final String Schema = "PlanWT.db";

    public Datebase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createDB(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void createDB(SQLiteDatabase db) {
        Log.d("SQLite DB", "생성완료");
        String sql = "CREATE TABLE PlanWT (id TEXT DEFAULT '',password TEXT DEFAULT '',name TEXT DEFAULT '',date TEXT DEFAULT '',purpose TEXT DEFAULT '')"; //이부분 수정이 필요합니다
        try {
            db.execSQL(sql);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void insertDate(String data, String date) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            String sql = "INSERT INTO PlanWT (date, purpose) VALUES('" + date + "','" + data + "');";
            Log.d("Inser Date SQL", sql);
            db.execSQL(sql);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void insertSign(String id, String password, String name) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            String sql = "INSERT INTO PlanWT (id, password,name) VALUES('" + id + "','" + password + "','" + name + "')";
            Log.d("Inser Sign SQL", sql);
            db.execSQL(sql);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public String getSign(String id, String password) {
        SQLiteDatabase db = getReadableDatabase();
        String result = "";
        //WHERE id = '" + id + "' AND " + "password = '" + password + "';"
        Cursor cursor = db.rawQuery("SELECT * FROM PlanWT WHERE id ='" + id + "' AND " + "password = '" + password + "';", null);

        while (cursor.moveToNext()) {
            result += cursor.getString(0) + "/";
            result += cursor.getString(1) + "/";
            result += cursor.getString(2) + "/";
            result += cursor.getString(3) + "/";
            result += cursor.getString(4) + "/";
        }
        Log.d("내용", result);

        return result;
    }

}