package com.unicorn.sxshenwutong.c.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.unicorn.sxshenwutong.c.home.HomeFra;
import com.unicorn.sxshenwutong.c.profile.ProfileFra;
import com.unicorn.sxshenwutong.news.NewsFra;

public class MainPagerAdapter extends FragmentPagerAdapter {

    MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFra();
            case 1:
                return new NewsFra();
            default:
                return new ProfileFra();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

}
