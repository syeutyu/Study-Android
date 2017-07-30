package com.example.user.junier;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class MainShow extends AppCompatActivity {
    private TabLayout tabLayout;
    TabFragment1 fragment1;
    TabFragment2 fragment2;
    TabFragment3 fragment3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_show);


                // Initializing the TabLayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Main Page "));
        tabLayout.addTab(tabLayout.newTab().setText("Plan Page"));
        tabLayout.addTab(tabLayout.newTab().setText("My Page"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        fragment1 = new TabFragment1();
        fragment2 = new TabFragment2();
        fragment3 = new TabFragment3();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment1).commit();

        // Set TabSelectedListener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment fragment = null;

                if (position == 0) {
                    fragment = fragment1;
                } else if (position == 1) {
                    fragment = fragment2;
                } else if (position == 2) {
                    fragment = fragment3;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }
}