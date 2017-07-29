package com.example.user.junier;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signin extends AppCompatActivity {
    public EditText login;
    public EditText password;
    public Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        setting();
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    //테이블에서 정보찾고 있으면 메인 이동 없을경우 에러 snackbar 띄워주기
            }
        });
    }

    public void setting(){
        login = (EditText)findViewById(R.id.input_email);
        password = (EditText)findViewById(R.id.input_password);
        loginbtn = (Button)findViewById(R.id.login);
    }
}
