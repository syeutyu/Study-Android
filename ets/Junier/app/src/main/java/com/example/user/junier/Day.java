package com.example.user.junier;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Day extends AppCompatActivity {
    String daydata;
    public static String num;
    public ArrayList<String> arr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);
        final Context context = this;
        Button btn = (Button) findViewById(R.id.save);
        CalendarView cal = (CalendarView) findViewById(R.id.cal);
        final TextView day = (TextView) findViewById(R.id.datebelow);


        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {


            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                try {
                    String data = null;
                    daydata = null;
                    Boolean check = true;


                    num = year + "," + (month + 1) + "," + dayOfMonth;
                    //Log.v("텍스트 중앙",android:layout_centerInParent="true")

                    for (int i = 0; i < arr.size(); i++) {

                        if (num.equals(arr.get(i))) {

                            check = false;
                            break;
                        } else {
                            check = true;
                        }

                    }

                    if (arr.size() < 7) {

                        Log.v("check 값 : ", String.valueOf(check));

                        if (check == true) {

                            arr.add(num);
                            Log.v("data 날짜", String.valueOf(arr.size()));

                            Toast.makeText(Day.this, num + "이 저장되었습니다. ", Toast.LENGTH_SHORT).show();

                            for (int i = 0; i < arr.size(); i++) {

                                for (int j = 0; j <= i; j++) {
                                    if (arr.get(j) != null)
                                        data += arr.get(j) + " ";
                                }
                                data += "&";
                            }
                            Log.v("data 값 : ", data);

                            String[] ch = data.split("&");

                            for (int i = 1; i < (ch.length + 1); i++) {

                                if (ch[i - 1].contains("null")) {

                                    String[] ch2;
                                    ch2 = ch[i - 1].split("null");
                                    daydata = ch2[1];

                                } else {
                                    if (i == 7) {
                                        Log.v("오류 ", ch[i - 1]);
                                    }
                                    daydata = ch[i - 1];
                                }
                            }


                            day.setText(TextViewHelper.shrinkWithWordUnit(day, daydata, 100));

                        }
                    } else {

                        Toast.makeText(getApplicationContext(), "입력가능한 일수를 초과했습니다.", Toast.LENGTH_SHORT).show();

                    }

                    if (check == false) {

                        Toast.makeText(getApplicationContext(), "해당일을 취소합니다.", Toast.LENGTH_SHORT).show();
                        for (int i = 0; i < arr.size(); i++) {
                            if (num.equals(arr.get(i))) {
                                Log.v("해당 값을 제거 합니다.", String.valueOf(arr.get(i)));
                                arr.remove(i);
                            }

                        }
                        for (int i = 0; i < arr.size(); i++) {

                            for (int j = 0; j <= i; j++) {
                                if (arr.get(j) != null)
                                    data += arr.get(j) + " ";
                            }
                            data += "&";
                        }
                        if (data != null) {
                            Log.v("data 값 : ", data);

                            String[] ch = data.split("&");

                            for (int i = 1; i < (ch.length + 1); i++) {

                                if (ch[i - 1].contains("null")) {

                                    String[] ch2;
                                    ch2 = ch[i - 1].split("null");
                                    daydata = ch2[1];

                                } else {
                                    if (i == 7) {
                                        Log.v("오류 ", ch[i - 1]);
                                    }
                                    daydata = ch[i - 1];
                                }
                            }
                            day.setText(TextViewHelper.shrinkWithWordUnit(day, daydata, 100));

                        } else {
                            Toast.makeText(getApplicationContext(), "초기화완료", Toast.LENGTH_SHORT).show();
                            day.setText("");
                        }

                    }

                } catch (Exception e) {
                    e.getMessage();
                }
            }

        });


        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}