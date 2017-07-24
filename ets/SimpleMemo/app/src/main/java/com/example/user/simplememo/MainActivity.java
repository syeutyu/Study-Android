package com.example.user.simplememo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextFileManager manager = new TextFileManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.memo_edit);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.savebtn : {
                String memo = editText.getText().toString();
                Log.v("저장 memo : " ,memo);
                manager.save(memo);
                editText.setText("");

                Toast.makeText(this,"저장완료",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.loadbtn : {
                Log.v("불러오기","시작");
                String text = manager.load();
                editText.setText(text);

                Toast.makeText(this,"불러오기 완료",Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.deletebtn : {
                manager.delete();
                editText.setText("");

                Toast.makeText(this,"삭제 완료",Toast.LENGTH_SHORT).show();
                break;
            }

            default:{

            }

        }
    }
}

