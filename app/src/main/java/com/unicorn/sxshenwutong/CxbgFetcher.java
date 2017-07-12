package com.unicorn.sxshenwutong;

import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.app.entity.Response;
import com.unicorn.sxshenwutong.a.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;

import java.util.Map;

public class CxbgFetcher extends BaseFetcher {

    public CxbgFetcher(Callback callback) {
        super(callback);
    }

    @Override
    public void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "";
    }

    @Override
    protected Map<String, Object> parameters() {

        return super.parameters();
    }

    @Override
    protected Object map(Response response) {
        return null;
    }
}
