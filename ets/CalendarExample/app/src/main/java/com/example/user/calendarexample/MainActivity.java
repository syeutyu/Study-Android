package com.example.user.calendarexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView tvDate;
    private GridAdapter gridAdapter;
    private ArrayList<String> daylist;
    private GridView gridview;
    private Calendar Cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDate = (TextView) findViewById(R.id.Label);
        gridview = (GridView) findViewById(R.id.grid);

        long now = System.currentTimeMillis();

        final Date date = new Date(now);
        final SimpleDateFormat yeartime = new SimpleDateFormat("yyyy", Locale.KOREA);
        final SimpleDateFormat monthtime = new SimpleDateFormat("MM", Locale.KOREA);
        final SimpleDateFormat daytime = new SimpleDateFormat("dd", Locale.KOREA);

        tvDate.setText(yeartime.format(date)+" / "+monthtime.format(date));

        daylist  = new ArrayList<String>();
        daylist.add("일");
        daylist.add("월");
        daylist.add("화");
        daylist.add("수");
        daylist.add("목");
        daylist.add("금");
        daylist.add("토");

        Cal = Calendar.getInstance();

        Cal.set(Integer.parseInt(yeartime.format(date)),Integer.parseInt(monthtime.format(date))-1,1);
        int daynum = Cal.get(Calendar.DAY_OF_WEEK);

        for(int i=0;i<daynum;i++){
            daylist.add("");
        }
        setCalendar(Cal.get(Calendar.MONTH)+1);
        gridAdapter = new GridAdapter(getApplicationContext(),daylist);
        gridview.setAdapter(gridAdapter);


    }
}
