package com.example.user.stopwatch;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Chronometer mChronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChronometer = (Chronometer) findViewById(R.id.chronometerview);
        Button start = (Button) findViewById(R.id.start);
        Button stop = (Button)findViewById(R.id.stop);
        Button reset = (Button)findViewById(R.id.reset);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    switch(view.getId()){
        case R.id.start:
            mChronometer.setBase(SystemClock.currentThreadTimeMillis());
            mChronometer.start();
            break;
        case R.id.stop:
            mChronometer.stop();
            break;
        case R.id.reset:
            mChronometer.stop();
            mChronometer.setBase(SystemClock.elapsedRealtime());
            mChronometer.start();
            break;
    }
    }
}
