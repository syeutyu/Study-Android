package com.example.user.junier;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.ArrayList;

public class Day extends AppCompatActivity {
    public int count;
    ArrayList<String> arr = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        CalendarView cal = (CalendarView) findViewById(R.id.cal);
        Button btn = (Button)findViewById(R.id.cancel);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                if(count<7) {

                    String num =  year + "," + (month + 1) + "," + dayOfMonth;
                    Log.v("그날의 날짜", num);
                    //Log.v("텍스트 중앙",android:layout_centerInParent="true")
                    if (num != null) {
                        arr.add(num);
                        count++;
                        Log.v("data 날짜", String.valueOf(arr.size()));
                        Log.v("count개수",String.valueOf(count));
                        Toast.makeText(Day.this, num + "이 저장되었습니다. ", Toast.LENGTH_SHORT).show();
                    } else{
                        Log.v("한번만","null");
                    }
                }
            }

        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("취소하기","클릭");
                count--;
                Log.v("Array List : ", String.valueOf(arr.size()));
                arr.remove(arr.size()-1);
                Log.v("arr",String.valueOf(arr.size()));
//                for(int i= (arr.length-1);i<=(arr.length-2);i--){
//                    arr[i] = null;
//                    Log.v("arr[i] =>",String.valueOf(arr[i]));
//                }
            }
        });


    }
}
