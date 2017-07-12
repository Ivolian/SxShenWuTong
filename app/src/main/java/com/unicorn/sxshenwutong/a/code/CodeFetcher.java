package com.unicorn.sxshenwutong.a.code;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.app.entity.Response;
import com.unicorn.sxshenwutong.a.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.code.entity.CodeResponse;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;


public class CodeFetcher extends BaseFetcher<CodeResponse> {

    private String bxh;

    public CodeFetcher(String bxh, Callback<CodeResponse> callback) {
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

    @Inject
    Gson gson;

    @Override
    protected CodeResponse map(Response<LinkedTreeMap<String, String>> response) {
        String ydbaKey = response.getParameters().get(Key.YDBAKEY);
        return gson.fromJson(ydbaKey, CodeResponse.class);
    }

}
