package com.unicorn.sxshenwutong;

import com.google.gson.Gson;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseSubmitter;
import com.unicorn.sxshenwutong.a.network.entity.Response;

import java.util.HashMap;

import javax.inject.Inject;

public class CxbgSubmitter extends BaseSubmitter<CxbgResponse> {

    private HashMap<String, Object> map;

    public CxbgSubmitter(HashMap<String, Object> map) {
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
    protected CxbgResponse map(Response response) {
        String ydbaKey = response.getParameters().get(Key.YDBAKEY);
        return gson.fromJson(ydbaKey, CxbgResponse.class);
    }

    @Inject
    Gson gson;

}
