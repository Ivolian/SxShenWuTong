package com.unicorn.sxshenwutong;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.unicorn.sxshenwutong.a.network.Callback;
import com.unicorn.sxshenwutong.a.network.entity.Response;
import com.unicorn.sxshenwutong.a.network.BaseSubmitter;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;

import java.util.HashMap;

import javax.inject.Inject;

public class SxbgSubmitter extends BaseSubmitter<CxbgResponse> {

    private HashMap<String, Object> map;

    public SxbgSubmitter(HashMap<String, Object> map, Callback<CxbgResponse> callback) {
        super(callback);
        this.map = map;
    }

    @Override
    public void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "saveSxbgsq";
    }

    @Override
    protected HashMap<String, Object> parameters() {
        return map;
    }

    @Override
    protected CxbgResponse map(Response<LinkedTreeMap<String, String>> response) {
        String ydbaKey = response.getParameters().get(Key.YDBAKEY);
        return gson.fromJson(ydbaKey, CxbgResponse.class);
    }

    @Inject
    Gson gson;

}
