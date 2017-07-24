package com.example.user.simplememo;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by user on 2017-07-20.
 */

public class TextFileManager {
    private static String text= "Memo.txt";
    Context context;

    public TextFileManager(Context context){
        this.context = context;
    }

    public void save(String data){
        Log.d("시작","세이브");
        if(data == null && data.equals("")){
            return;
        }
        Log.v("save data : ",data);

        FileOutputStream strtext;
        try{
            strtext = context.openFileOutput(text,Context.MODE_PRIVATE);
            strtext.write(data.getBytes());
            strtext.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public String load(){
        try{
            FileInputStream inputStream = context.openFileInput(text);
            byte[] bytes = new byte[inputStream.available()];
            while(inputStream.read(bytes)!= -1) {}
            return new String(bytes);

        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public void delete(){
        context.deleteFile(text);
    }
}
