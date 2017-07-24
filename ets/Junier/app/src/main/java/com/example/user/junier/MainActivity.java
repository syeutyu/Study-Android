package com.example.user.junier;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnClick(View v){
        switch (v.getId()){
            case R.id.one : {
                Toast.makeText(getApplicationContext(),"Day화면 출력",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,Day.class);
                startActivity(intent);

                break;
            }
            case R.id.two : {
                Toast.makeText(getApplicationContext(),"two 출력",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.three : {
                Toast.makeText(getApplicationContext(),"three 출력",Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
