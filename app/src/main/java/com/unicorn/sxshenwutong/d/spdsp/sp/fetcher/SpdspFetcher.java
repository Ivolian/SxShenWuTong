package com.unicorn.sxshenwutong.d.spdsp.sp.fetcher;

import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;
import com.unicorn.sxshenwutong.d.spdsp.sp.entity.SpdspInfo;

import java.util.HashMap;

public class SpdspFetcher extends BaseFetcher<SpdspInfo> {

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
    protected SpdspInfo map(Response response) {
        return gson.fromJson(response.getParameters().get(Key.YDBAKEY), SpdspInfo.class);
    }
}
