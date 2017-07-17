package com.unicorn.sxshenwutong.c.spdsp;

import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;

import java.util.HashMap;

public class SpFetcher extends BaseFetcher<SpdspFull> {

    private HashMap<String, Object> map;

    public SpFetcher(HashMap<String, Object> map) {
        this.map = map;
    }

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "getSpxx";
    }

    @Override
    protected HashMap<String, Object> parameters() {
        return map;
    }

    @Override
    protected SpdspFull map(Response response) {
        String ajxx = response.getParameters().get(Key.YDBAKEY);
        return gson.fromJson(ajxx, SpdspFull.class);
    }
}
