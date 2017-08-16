package com.unicorn.sxshenwutong.dsp2.base.network;

import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;
import com.unicorn.sxshenwutong.dsp2.base.entity.DspInfo;

import java.util.HashMap;

public class DspFetcher extends BaseFetcher<DspInfo> {

    private String ajbs;
    private String spid;
    private String lcid;

    public DspFetcher(String ajbs, String spid, String lcid) {
        this.ajbs = ajbs;
        this.spid = spid;
        this.lcid = lcid;
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
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.AJBS, ajbs);
        map.put(Key.SPID, spid);
        map.put(Key.LCID, lcid);
        return map;
    }

    @Override
    protected DspInfo map(Response response) {
        return gson.fromJson(response.getParameters().get(Key.YDBAKEY), DspInfo.class);
    }
    
}
