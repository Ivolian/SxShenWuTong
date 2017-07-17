package com.unicorn.sxshenwutong;

import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseSubmitter;
import com.unicorn.sxshenwutong.a.network.entity.Response;

import java.util.HashMap;

public class SpSubmitter extends BaseSubmitter<SimpleResponse> {

    private HashMap<String,Object> map;

    public SpSubmitter(HashMap<String, Object> map) {
        this.map = map;
    }

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "savesp";
    }

    @Override
    protected HashMap<String, Object> parameters() {
        return map;
    }

    @Override
    protected SimpleResponse map(Response response) {
        return new SimpleResponse();
    }

}
