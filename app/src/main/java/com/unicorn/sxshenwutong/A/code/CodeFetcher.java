package com.unicorn.sxshenwutong.A.code;

import com.unicorn.sxshenwutong.A.app.Callback;
import com.unicorn.sxshenwutong.A.base.BaseFetcher;
import com.unicorn.sxshenwutong.dagger.AppComponentProvider;

import java.util.HashMap;
import java.util.Map;


public class CodeFetcher extends BaseFetcher {

    private String bxh;

    public CodeFetcher( String bxh,Callback callback) {
        super(callback);
        this.bxh = bxh;
    }

    @Override
    public void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "getBm";
    }

    @Override
    protected Map<String, Object> parameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("bxh", bxh);
        return parameters;
    }

}
