package com.unicorn.sxshenwutong.court;

import com.unicorn.sxshenwutong.app.Callback;
import com.unicorn.sxshenwutong.base.BaseFetcher;
import com.unicorn.sxshenwutong.dagger.AppComponentProvider;

public class CourtFetcher extends BaseFetcher {

    public CourtFetcher(Callback callback) {
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

}
