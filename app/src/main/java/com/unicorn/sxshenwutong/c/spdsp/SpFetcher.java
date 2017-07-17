package com.unicorn.sxshenwutong.c.spdsp;

import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;

import java.util.HashMap;

public class SpFetcher extends BaseFetcher {

    HashMap<String,Object> map;

    public SpFetcher(HashMap<String, Object> map) {
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
    protected Object map(Response response) {
        return new Object();
    }
}
