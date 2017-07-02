package com.unicorn.sxshenwutong.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.unicorn.sxshenwutong.ProfileFragment;

public class MainPagerAdapter extends FragmentPagerAdapter {

    MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

        }
        return new ProfileFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }

}
