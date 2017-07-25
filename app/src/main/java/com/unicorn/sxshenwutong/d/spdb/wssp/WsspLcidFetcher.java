package com.unicorn.sxshenwutong.d.spdb.wssp;

import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;

import java.util.HashMap;

public class WsspLcidFetcher extends BaseFetcher {

    private String ajbs;

    public WsspLcidFetcher(String ajbs) {
        this.ajbs = ajbs;
    }

    @Override
    protected HashMap<String, Object> parameters() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.AJBS, ajbs);
        return map;
    }

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "getWsspLcid";
    }

    @Override
    protected Object map(Response response) {
        return null;
    }

}
