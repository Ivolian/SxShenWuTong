package com.unicorn.sxshenwutong.c.home;

import com.google.gson.Gson;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;
import com.unicorn.sxshenwutong.c.home.entity.HomeResponse;

import javax.inject.Inject;

public class HomeFetcher extends BaseFetcher<HomeResponse> {


    @Override
    public void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "getMaindata";
    }

    @Inject
    Gson gson;

    @Override
    protected HomeResponse map(Response response) {
        String ydbaKey = response.getParameters().get(Key.YDBAKEY);
        return gson.fromJson(ydbaKey, HomeResponse.class);
    }

}
