package com.example.user.simplememo;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by user on 2017-07-20.
 */

class TextFileManager {
    private static String text= "Memo.txt";
    Context context;

    public TextFileManager(Context context){
        this.context = context;
    }

    public void save(String data){
        if(data == null && data.equals("")){
            return;
        }

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
            while(inputStream.read(bytes)!=1){

            }
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
