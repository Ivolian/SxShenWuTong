package com.unicorn.sxshenwutong.dsp2.base.network;

import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;
import com.unicorn.sxshenwutong.dsp2.base.entity.DspInfo;

import java.util.HashMap;

public class DspFetcher extends BaseFetcher<DspInfo> {

    private HashMap<String, Object> map;

    public DspFetcher(HashMap<String, Object> map) {
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
    protected DspInfo map(Response response) {
        return gson.fromJson(response.getParameters().get(Key.YDBAKEY), DspInfo.class);
    }
}
