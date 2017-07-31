package com.unicorn.sxshenwutong.b.login.network;

import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseSubmitter;
import com.unicorn.sxshenwutong.a.network.entity.Response;
import com.unicorn.sxshenwutong.b.login.entity.LoginResponse;

import java.util.HashMap;

public class LoginSubmitter extends BaseSubmitter<LoginResponse> {

    private final String fydm;
    private final String loginName;
    private final String pwd;

    public LoginSubmitter(String fydm, String loginName, String pwd) {
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
        parameters.put(Key.FYDM, fydm);
        parameters.put("loginname", loginName);
        parameters.put("password", pwd);
        return parameters;
    }

    @Override
    protected LoginResponse map(Response response) {
        String ydbaKey = response.getParameters().get(Key.YDBAKEY);
        return gson.fromJson(ydbaKey, LoginResponse.class);
    }

}
