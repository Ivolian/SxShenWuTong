package com.unicorn.sxshenwutong.news;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.BaseFra;
import com.unicorn.sxshenwutong.news.newsType.entity.NewsType;
import com.unicorn.sxshenwutong.news.newsType.entity.NewsTypeResponse;
import com.unicorn.sxshenwutong.news.newsType.network.NewsTypeFetcher;

import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

public class NewsFra extends BaseFra {

    @Override
    protected int layoutResId() {
        return R.layout.fra_news;
    }

    @Override
    protected void init(View rootView) {
        new NewsTypeFetcher().start().subscribe(new Subscriber<NewsTypeResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(NewsTypeResponse newsTypeResponse) {
                init(newsTypeResponse.getNewsTypeList());
            }
        });
    }

    private void init(List<NewsType> newsTypes) {
        viewPager.setOffscreenPageLimit(newsTypes.size() - 1);
        viewPager.setAdapter(new NewsPagerAdapter(getChildFragmentManager(), newsTypes));
        tab.setupWithViewPager(viewPager);
    }

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tab)
    TabLayout tab;

}
