package com.unicorn.sxshenwutong;

import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.app.entity.Response;
import com.unicorn.sxshenwutong.a.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;

import java.util.HashMap;
import java.util.Map;

public class AjxxFetcher extends BaseFetcher {

    private String ajbs;

    public AjxxFetcher( String ajbs,Callback callback) {
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
    protected Map<String, Object> parameters() {
        Map<String,Object> map = new HashMap<>();
        map.put(Key.AJBS,ajbs);
        return map;
    }

    @Override
    protected Object map(Response response) {
        return null;
    }
}
