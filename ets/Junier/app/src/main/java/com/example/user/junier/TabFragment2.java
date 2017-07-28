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
import android.widget.TextView;

/**
 * Created by user on 2017-07-28.
 */

public class TabFragment2 extends Fragment {
        Button In;
        TextInputEditText text;
        TextView daytext;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.activity_main, container, false);
            In = v.findViewById(R.id.Invite);
            In.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("Facebook Friend ","Invite");
                    Intent intent1 = new Intent(getActivity(),Signup.class);
                    startActivity(intent1);
                }
            });
            text = v.findViewById(R.id.purpose);
            daytext = v.findViewById(R.id.select_day);

            return v;
        }

}


