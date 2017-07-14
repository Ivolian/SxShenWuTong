package com.unicorn.sxshenwutong.b.court;

import com.google.gson.Gson;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;
import com.unicorn.sxshenwutong.b.court.entity.CourtResponse;

import javax.inject.Inject;

public class CourtFetcher extends BaseFetcher<CourtResponse> {


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
    protected CourtResponse map(Response response) {
        String ydbaKey = response.getParameters().get(Key.YDBAKEY);
        return gson.fromJson(ydbaKey, CourtResponse.class);
    }

}
