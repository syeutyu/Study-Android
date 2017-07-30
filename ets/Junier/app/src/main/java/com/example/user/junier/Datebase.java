package com.example.user.junier;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by user on 2017-07-29.
 */

public class Datebase extends SQLiteOpenHelper{

    public static final String Schema = "PlanW";

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

    public void createDB(SQLiteDatabase db){
        String sql = "CREATE TABLE" + Schema + "(id text,password text,name text,date text,purpose text)"; //이부분 수정이 필요합니다
        try{
            db.execSQL(sql);
        }catch(SQLException e){
            e.getMessage();
        }
    }

    public void insertDate(SQLiteDatabase db,String data,String date){
        db.beginTransaction();
        try{
            String sql = "insert into"+ Schema +"(date, purpose)"+"values('"+date+"','"+data+"')";
            Log.d("Inser Date SQL",sql);
            db.execSQL(sql);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.getMessage();
        }
        finally {
            db.endTransaction();;
        }
    }

    public void insertSign(SQLiteDatabase db,String id,String password,String name){
        db.beginTransaction();
        try{
            String sql = "insert into"+Schema+"(id, password,name)"+"values('"+id+"','"+password+"','"+name+"')";
            Log.d("Inser Sign SQL",sql);
            db.execSQL(sql);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.getMessage();
        }finally {
            db.endTransaction();
        }
    }

}
