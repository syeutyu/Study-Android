package com.example.user.junier;

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
    public int count;
    public ArrayList<String> arr = new ArrayList<>();

    //RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);
        CalendarView cal = (CalendarView) findViewById(R.id.cal);
        Button btn = (Button) findViewById(R.id.cancel);
        final TextView day = (TextView) findViewById(R.id.datebelow);

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String data = null;
                String daydata = null;
                Boolean check = true;
                if (count < 7) {

                    String num = year + "," + (month + 1) + "," + dayOfMonth;
                    //Log.v("텍스트 중앙",android:layout_centerInParent="true")

                    for (int i = 0; i < arr.size(); i++) {

                        if (num.equals(arr.get(i))) {
                            check = false;
                            break;
                        } else {
                            check = true;
                        }
                        
                    }
                    Log.v("check 값 : ", String.valueOf(check));

                    if (check == true) {
                        arr.add(num);
                        Log.v("data 날짜", String.valueOf(arr.size()));
                        Log.v("count개수", arr.get(count));
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
                                Log.v("Null 값 생성", "으아아아아아");
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
                        count++;
                        day.setText(TextViewHelper.shrinkWithWordUnit(day, daydata, 100));
                    } else {
                        Toast.makeText(getApplicationContext(), "중복된 일수 입니다.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "입력가능한 일수를 초과했습니다.", Toast.LENGTH_SHORT).show();
                }
            }

        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("취소하기", "클릭");
                count--;
                Log.v("Array List : ", String.valueOf(arr.size()));
                arr.remove(arr.size() - 1);
                Log.v("arr", String.valueOf(arr.size()));

            }
        });


    }
}

