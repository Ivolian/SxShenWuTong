package com.unicorn.sxshenwutong.lc;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.unicorn.sxshenwutong.a.network.Callback;
import com.unicorn.sxshenwutong.a.network.entity.Response;
import com.unicorn.sxshenwutong.a.network.BaseFetcher;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;

import java.util.HashMap;

import javax.inject.Inject;

public class NextNodeFetcher extends BaseFetcher<NextNodeResponse> {

    private String lcid;

    public NextNodeFetcher(String lcid,Callback<NextNodeResponse> callback) {
        super(callback);
        this.lcid = lcid;
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
        map.put("lcid", lcid);
        return map;
    }

    @Inject
    Gson gson;

    @Override
    protected NextNodeResponse map(Response<LinkedTreeMap<String, String>> response) {
        return gson.fromJson(response.getParameters().get(Key.YDBAKEY), NextNodeResponse.class);
    }

}
