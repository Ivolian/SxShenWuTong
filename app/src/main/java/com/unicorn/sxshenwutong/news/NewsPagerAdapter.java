package com.unicorn.sxshenwutong.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.news.newsList.NewsListFra;
import com.unicorn.sxshenwutong.news.newsType.entity.NewsType;

import java.util.List;

class NewsPagerAdapter extends FragmentPagerAdapter {

    private List<NewsType> newsTypes;

    NewsPagerAdapter(FragmentManager fm, List<NewsType> newsTypes) {
        super(fm);
        this.newsTypes = newsTypes;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fra = new NewsListFra();
        Bundle args = new Bundle();
        args.putSerializable(Key.NEWS_TYPE, newsTypes.get(position));
        fra.setArguments(args);
        return fra;
    }

    @Override
    public int getCount() {
        return newsTypes.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return newsTypes.get(position).getName();
    }

}
