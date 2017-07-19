package com.example.user.adapterexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //ArrayList<String> arr;
    ListView listView;
    ArrayAdapter<CharSequence> adapter;
    //ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //데이터 분리
        adapter = ArrayAdapter.createFromResource(this,R.array.weather,android.R.layout.simple_expandable_list_item_1);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
//        arr = new ArrayList<>();
//        arr.add("월");
//        arr.add("화");
//        arr.add("수");
//        arr.add("목");
//        arr.add("금");
//        arr.add("토");
//        arr.add("일");
//
//        adapter = new ArrayAdapter<String>(MainActivity.this ,android.R.layout.simple_list_item_1, arr);
//        listView = (ListView) findViewById(R.id.listView);
//        listView.setAdapter(adapter);



    }
}
