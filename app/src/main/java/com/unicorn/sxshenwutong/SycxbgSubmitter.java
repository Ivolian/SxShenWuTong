package com.unicorn.sxshenwutong;

import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseSubmitter;
import com.unicorn.sxshenwutong.a.network.entity.Response;

import java.util.HashMap;

public class SycxbgSubmitter extends BaseSubmitter<SimpleResponse> {

    private HashMap<String, Object> map;

    public SycxbgSubmitter(HashMap<String, Object> map) {
        this.map = map;
    }

    @Override
    public void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "saveJzpsq";
    }

    @Override
    protected HashMap<String, Object> parameters() {
        return map;
    }

    @Override
    protected SimpleResponse map(Response response) {
        String ydbaKey = response.getParameters().get(Key.YDBAKEY);
        return gson.fromJson(ydbaKey, SimpleResponse.class);
    }

}
