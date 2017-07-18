package com.example.user.calendarexample;

import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

    private void setCalendar(int month){
        Cal.set(Calendar.MONTH,month-1);

        for(int i=0;i<Cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++){
            daylist.add(""+(i+1));
        }
    }


}

class GridAdapter extends BaseAdapter{
    private  List<String> list;
    private final LayoutInflater inflater;

    GridAdapter(Context context,List<String> list) {
        this.list = list;
        this.inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            view = inflater.inflate(R.layout.activity_calendar,viewGroup,false);

            holder = new ViewHolder();
            holder.tvItemGridView  = (TextView)view.findViewById(R.id.item);
            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }
        holder.tvItemGridView.setText(""+getItem(i));

            Cal = Calendar.getInstance();
    }
}

class ViewHolder extends PropertyValuesHolder{

}
