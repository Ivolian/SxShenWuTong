package com.unicorn.sxshenwutong.news;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.BaseFra;
import com.unicorn.sxshenwutong.news.entity.NewsType;
import com.unicorn.sxshenwutong.news.entity.NewsTypeResponse;
import com.unicorn.sxshenwutong.news.network.NewsTypeFetcher;

import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

public class NewsFra extends BaseFra {

    @Override
    protected int layoutResId() {
        return R.layout.fra_news;
    }

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tab)
    SlidingTabLayout tab;

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
                List<NewsType> newsTypes = newsTypeResponse.getNewsTypeList();
                PagerAdapter adapter = new NewsPagerAdapter(getChildFragmentManager(), newsTypes);

                viewPager.setOffscreenPageLimit(newsTypes.size() - 1);
                viewPager.setAdapter(adapter);
                tab.setViewPager(viewPager);
            }
        });
    }

}
