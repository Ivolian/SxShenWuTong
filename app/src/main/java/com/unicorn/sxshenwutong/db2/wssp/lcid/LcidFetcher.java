package com.unicorn.sxshenwutong.db2.wssp.lcid;

import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;

import java.util.HashMap;

public class LcidFetcher extends BaseFetcher<LcidResponse> {

    private String ajbs;

    public LcidFetcher(String ajbs) {
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
    protected LcidResponse map(Response response) {
        String ydbaKey = response.getParameters().get(Key.YDBAKEY);
        return gson.fromJson(ydbaKey, LcidResponse.class);
    }


}
