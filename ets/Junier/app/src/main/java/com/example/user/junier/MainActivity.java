package com.example.user.junier;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String purpose;
    public static String stringData;
    private TextInputEditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextInputEditText) findViewById(R.id.purpose);
//
//        Intent intent = getIntent();
//        stringData = intent.getStringExtra("Date");
//        Log.d("stringDate",stringData);

    }

    public void OnClick(View v){
        switch (v.getId()){
            case R.id.one : {
                purpose = text.getText().toString();
                Log.d("purpose 값 ",purpose);

                Toast.makeText(getApplicationContext(),"Day화면 출력",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,Day.class);
                startActivity(intent);

                break;
            }
            case R.id.two : {
                Toast.makeText(getApplicationContext(),"Week화면 출력",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Week.class);
                startActivity(intent);
                break;
            }
            case R.id.three : {
                Toast.makeText(getApplicationContext(),"three 출력",Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
