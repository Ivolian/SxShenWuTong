package com.unicorn.sxshenwutong.d;

import com.unicorn.sxshenwutong.SimpleResponse;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseSubmitter;
import com.unicorn.sxshenwutong.a.network.entity.Response;

import java.util.HashMap;

abstract public class SpdbSubmitter extends BaseSubmitter<SimpleResponse> {

    protected HashMap<String,Object> map;

    public SpdbSubmitter(HashMap<String, Object> map) {
        this.map = map;
    }

    public HashMap<String, Object> getMap() {
        return map;
    }

    public void setMap(HashMap<String, Object> map) {
        this.map = map;
    }

    @Override
    public void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected SimpleResponse map(Response response) {
        String ydbaKey = response.getParameters().get(Key.YDBAKEY);
        return gson.fromJson(ydbaKey, SimpleResponse.class);
    }

    @Override
    protected HashMap<String, Object> parameters() {
        return map;
    }

}
