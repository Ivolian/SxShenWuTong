package com.unicorn.sxshenwutong.b.court;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.app.entity.Response;
import com.unicorn.sxshenwutong.a.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.b.court.entity.CourtResponse;

import javax.inject.Inject;

public class CourtFetcher extends BaseFetcher<CourtResponse> {

    public CourtFetcher(Callback<CourtResponse> callback) {
        super(callback);
    }

    @Override
    public void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "getFyList";
    }

    @Inject
    Gson gson;

    @Override
    protected CourtResponse map(Response<LinkedTreeMap<String, String>> response) {
        String ydbaKey = response.getParameters().get(Key.YDBAKEY);
        return gson.fromJson(ydbaKey, CourtResponse.class);
    }

}
