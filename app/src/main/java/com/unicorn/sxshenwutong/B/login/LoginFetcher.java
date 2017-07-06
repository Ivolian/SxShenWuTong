package com.unicorn.sxshenwutong.B.login;

import com.unicorn.sxshenwutong.A.app.Callback;
import com.unicorn.sxshenwutong.A.base.BaseFetcher;
import com.unicorn.sxshenwutong.dagger.AppComponentProvider;

import java.util.HashMap;
import java.util.Map;

public class LoginFetcher extends BaseFetcher {

    private String fydm;
    private String loginName;
    private String pwd;

    public LoginFetcher( String fydm, String loginName, String pwd,Callback callback) {
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
    protected Map<String, Object> parameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fydm", fydm);
        parameters.put("loginname", loginName);
        parameters.put("password", pwd);
        return parameters;
    }

}
