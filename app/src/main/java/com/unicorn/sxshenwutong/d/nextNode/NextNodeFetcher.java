package com.unicorn.sxshenwutong.d.nextNode;

import com.google.gson.Gson;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;

import java.util.HashMap;

import javax.inject.Inject;

public class NextNodeFetcher extends BaseFetcher<NextNodeResponse> {

    private String lcid;

    public NextNodeFetcher(String lcid) {
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
    protected NextNodeResponse map(Response response) {
        return gson.fromJson(response.getParameters().get(Key.YDBAKEY), NextNodeResponse.class);
    }

}
