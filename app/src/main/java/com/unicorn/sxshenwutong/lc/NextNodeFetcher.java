package com.unicorn.sxshenwutong.lc;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.app.entity.Response;
import com.unicorn.sxshenwutong.a.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;

import java.util.HashMap;

import javax.inject.Inject;

public class NextNodeFetcher extends BaseFetcher<NextNodeResponse> {

    public NextNodeFetcher(Callback<NextNodeResponse> callback) {
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
    protected HashMap<String, Object> parameters() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("lcid", "CQ_DSP_SPGL_SP_AJJZPSP");
        return map;
    }

    @Inject
    Gson gson;

    @Override
    protected NextNodeResponse map(Response<LinkedTreeMap<String, String>> response) {
        return gson.fromJson(response.getParameters().get(Key.YDBAKEY), NextNodeResponse.class);
    }

}
