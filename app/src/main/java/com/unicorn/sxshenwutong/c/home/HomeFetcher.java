package com.unicorn.sxshenwutong.c.home;

import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;

public class HomeFetcher extends BaseFetcher {

    public HomeFetcher(Callback callback) {
        super(callback);
    }

    @Override
    public void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "getMaindata";
    }

}
