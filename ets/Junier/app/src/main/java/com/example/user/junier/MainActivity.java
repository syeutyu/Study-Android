package com.example.user.junier;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String tag = "로그";
    public static final int Result_Code = 1001;
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

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.one: {
                purpose = text.getText().toString();
                Log.d("purpose 값 ", purpose);

                Toast.makeText(getApplicationContext(), "Day화면 출력", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Day.class);
                startActivityForResult(intent, Result_Code);

                break;
            }
            case R.id.two: {
                Toast.makeText(getApplicationContext(), "Week화면 출력", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Week.class);
                startActivity(intent);
                break;
            }
            case R.id.three: {
                Toast.makeText(getApplicationContext(), "three 출력", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(tag, "onActivityResult");
        Log.d(tag,String.valueOf(requestCode));
        Log.d(tag,String.valueOf(resultCode));


        if (requestCode == 1) {

            String Date = data.getStringExtra("Date");
            Log.d("String data", Date);
        }
    }


}
