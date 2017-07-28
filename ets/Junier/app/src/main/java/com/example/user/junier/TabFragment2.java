package com.example.user.junier;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 2017-07-28.
 */

public class TabFragment2 extends Fragment {
    public static Button In;
    public static ImageButton btn1;
    public static ImageButton btn2;
    public static ImageButton btn3;
    TextInputEditText text;
    TextView daytext;
    public static final String tag = "로그";
    public static final int Result_Code = 1001;
    public static String purpose;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main, container, false);
        In = v.findViewById(R.id.Invite);
        text = v.findViewById(R.id.purpose);
        daytext = v.findViewById(R.id.select_day);
        btn1 = v.findViewById(R.id.one);
        btn2 = v.findViewById(R.id.two);
        btn3 = v.findViewById(R.id.three);

        In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Facebook Friend ", "Invite");
                Intent intent1 = new Intent(getActivity(), Signup.class);
                startActivity(intent1);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                purpose = text.getText().toString();
                Log.d("purpose 값 ", purpose);

                Toast.makeText(getActivity(), "Day화면 출력", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), Day.class);
                startActivityForResult(intent, Result_Code);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Week화면 출력", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), Week.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "three 출력", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(tag, "onActivityResult");
        try {
            if (requestCode == Result_Code) {
                String Date = data.getStringExtra("Date");
                Log.d("Date", Date);
                daytext.setText(Date);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

}


