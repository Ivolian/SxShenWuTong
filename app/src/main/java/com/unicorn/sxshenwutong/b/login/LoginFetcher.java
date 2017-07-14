package com.unicorn.sxshenwutong.b.login;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.unicorn.sxshenwutong.a.network.Callback;
import com.unicorn.sxshenwutong.a.network.entity.Response;
import com.unicorn.sxshenwutong.a.network.BaseFetcher;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.b.login.entity.LoginResponse;

import java.util.HashMap;

import javax.inject.Inject;

public class LoginFetcher extends BaseFetcher<LoginResponse> {

    private String fydm;
    private String loginName;
    private String pwd;

    public LoginFetcher(String fydm, String loginName, String pwd,
                        Callback<LoginResponse> callback) {
        super(callback);
        this.fydm = fydm;
        this.loginName = loginName;
        this.pwd = pwd;
    }

    @Override
    public void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "login";
    }

    @Override
    protected HashMap<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("fydm", fydm);
        parameters.put("loginname", loginName);
        parameters.put("password", pwd);
        return parameters;
    }

    @Inject
    Gson gson;

    @Override
    protected LoginResponse map(Response<LinkedTreeMap<String, String>> response) {
        String ydbaKey = response.getParameters().get(Key.YDBAKEY);
        return gson.fromJson(ydbaKey, LoginResponse.class);
    }

}
