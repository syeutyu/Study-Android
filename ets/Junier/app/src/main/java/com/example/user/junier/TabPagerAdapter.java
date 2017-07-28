package com.example.user.junier;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by user on 2017-07-28.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    // Count number of tabs
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        // Returning the current tabs
        switch (position) {
            case 0:
                Log.d("실행",String.valueOf(position));

                TabFragment1 tabFragment1 = new TabFragment1();
                return tabFragment1;
            case 1:
                Log.d("실행",String.valueOf(position));

                TabFragment2 tabFragment2 = new TabFragment2();
                return tabFragment2;
            case 2:
                Log.d("실행",String.valueOf(position));
                TabFragment3 tabFragment3 = new TabFragment3();
                return tabFragment3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
