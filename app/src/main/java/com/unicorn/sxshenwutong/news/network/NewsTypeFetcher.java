package com.unicorn.sxshenwutong.news.network;

import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;
import com.unicorn.sxshenwutong.news.entity.NewsTypeResponse;

public class NewsTypeFetcher extends BaseFetcher<NewsTypeResponse> {

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "getNewsTypeList";
    }

    @Override
    protected NewsTypeResponse map(Response response) {
        String ydbaKey = response.getParameters().get(Key.YDBAKEY);
        return gson.fromJson(ydbaKey, NewsTypeResponse.class);
    }

}
