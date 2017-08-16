package com.unicorn.sxshenwutong.db2.base;

import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;
import com.unicorn.sxshenwutong.db.db.entity.Ajxx;

import java.util.HashMap;

public class AjxxFetcher extends BaseFetcher<Ajxx> {

    private String ajbs;

    public AjxxFetcher(String ajbs) {
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

    @Override
    protected Ajxx map(Response response) {
        String ajxx = response.getParameters().get(Key.AJXX);
        return gson.fromJson(ajxx, Ajxx.class);
    }

}
