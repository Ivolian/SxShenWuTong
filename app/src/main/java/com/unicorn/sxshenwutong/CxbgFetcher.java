package com.unicorn.sxshenwutong;

import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.app.GeneralService2;
import com.unicorn.sxshenwutong.a.app.entity.Response;
import com.unicorn.sxshenwutong.a.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;

import java.util.HashMap;

import javax.inject.Inject;

public class CxbgFetcher extends BaseFetcher<Object> {

    private HashMap<String, Object> map;

    public CxbgFetcher(HashMap<String, Object> map, Callback<Object> callback) {
        super(callback);
        this.map = map;
    }

    @Override
    public void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "saveJzpsq";
    }

    @Override
    protected HashMap<String, Object> parameters() {
        return map;
    }

    @Override
    protected Object map(Response response) {
        return map;
    }

    @Inject
    GeneralService2 generalService2;


}
