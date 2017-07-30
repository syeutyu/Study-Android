package com.example.user.junier;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.user.junier.TabFragment2.version;

public class Signin extends AppCompatActivity {
    public EditText login;
    public EditText password;
    public Button loginbtn;
    Datebase helper;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        startActivity(new Intent(this,SplashActivity.class));
        helper = new Datebase(getApplicationContext(),Datebase.Schema,null,version);

        setting();
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = login.getText().toString();
                String pw = password.getText().toString();
                Log.d(id+","+pw," 을 이용해서 정보 검색");
                String user = helper.getSign(id,pw);
                Log.d("찾은 데이터 ",user);
            }
        });
    }

    public void setting(){
        login = (EditText)findViewById(R.id.input_email);
        password = (EditText)findViewById(R.id.input_password);
        loginbtn = (Button)findViewById(R.id.login);
    }
    public void SignUp(View v){
        Log.d("회원가입창","이동");
        Intent intent = new Intent(getApplicationContext(),Signup.class);
        startActivity(intent);
        finish();
    }
}
