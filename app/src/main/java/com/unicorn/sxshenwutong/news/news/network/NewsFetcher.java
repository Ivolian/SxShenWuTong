package com.unicorn.sxshenwutong.news.news.network;

import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;
import com.unicorn.sxshenwutong.news.newsList.entity.News;

import java.util.HashMap;

public class NewsFetcher extends BaseFetcher<News> {
    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "getNews";
    }

    private String newsId;

    public NewsFetcher(String newsId) {
        this.newsId = newsId;
    }

    @Override
    protected HashMap<String, Object> parameters() {
        HashMap<String, Object> map = super.parameters();
        map.put(Key.NEWS_ID, newsId);
        return map;
    }

    @Override
    protected News map(Response response) {
        return null;
    }

}
