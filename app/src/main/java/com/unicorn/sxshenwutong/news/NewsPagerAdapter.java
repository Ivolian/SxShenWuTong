package com.unicorn.sxshenwutong.news;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.unicorn.sxshenwutong.news.entity.NewsType;

import java.util.List;

class NewsPagerAdapter extends FragmentPagerAdapter {

    private List<NewsType> newsTypeList;

    NewsPagerAdapter(FragmentManager fm, List<NewsType> newsTypeList) {
        super(fm);
        this.newsTypeList = newsTypeList;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fra = new NewsListFra();
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("newsType", newsTypeList.get(position));
//        fra.setArguments(bundle);
        return fra;
    }

    @Override
    public int getCount() {
        return newsTypeList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return newsTypeList.get(position).getName();
    }

}
