package com.unicorn.sxshenwutong;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.app.entity.Response;
import com.unicorn.sxshenwutong.a.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.list.Ajxx;

import java.util.HashMap;

import javax.inject.Inject;

public class AjxxFetcher extends BaseFetcher<Ajxx> {

    private String ajbs;

    public AjxxFetcher(String ajbs, Callback<Ajxx> callback) {
        super(callback);
        this.ajbs = ajbs;
    }

    @Override
    public void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "getAjxx";
    }

    @Override
    protected HashMap<String, Object> parameters() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.AJBS, ajbs);
        return map;
    }

    @Inject
    Gson gson;

    @Override
    protected Ajxx map(Response<LinkedTreeMap<String, String>> response) {
        String ajxx = response.getParameters().get(Key.AJXX);
        return gson.fromJson(ajxx, Ajxx.class);
    }

}
