package com.unicorn.sxshenwutong.c.home;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;

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
    protected HomeResponse map(Response<LinkedTreeMap<String, String>> response) {
        String ydbaKey = response.getParameters().get(Key.YDBAKEY);
        return gson.fromJson(ydbaKey, HomeResponse.class);
    }

}
