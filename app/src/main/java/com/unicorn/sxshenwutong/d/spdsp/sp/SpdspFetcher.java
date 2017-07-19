package com.unicorn.sxshenwutong.d.spdsp.sp;

import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;

import java.util.HashMap;

public class SpdspFetcher extends BaseFetcher<Spdsp> {

    private HashMap<String, Object> map;

    public SpdspFetcher(HashMap<String, Object> map) {
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
    protected Spdsp map(Response response) {
        String ydbaKey = response.getParameters().get(Key.YDBAKEY);
        return gson.fromJson(ydbaKey, Spdsp.class);
    }
}
