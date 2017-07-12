package com.unicorn.sxshenwutong;

import com.google.gson.internal.LinkedTreeMap;
import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.app.entity.Response;
import com.unicorn.sxshenwutong.a.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;

import java.util.HashMap;
import java.util.Map;

public class NextNodeFetcher extends BaseFetcher<Object> {
    public NextNodeFetcher(Callback<Object> callback) {
        super(callback);
    }

    @Override
    public void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "getLcNextNodes";
    }

    @Override
    protected Map<String, Object> parameters() {
        Map<String,Object> map = new HashMap<>();
        map.put("lcid","CQ_DSP_SPGL_SP_AJJZPSP");
        return map;
    }

    @Override
    protected Object map(Response<LinkedTreeMap<String, String>> response) {
        return null;
    }
}
