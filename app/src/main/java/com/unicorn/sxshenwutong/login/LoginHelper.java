package com.unicorn.sxshenwutong.login;

import com.unicorn.sxshenwutong.app.Callback;
import com.unicorn.sxshenwutong.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.app.Params;
import com.unicorn.sxshenwutong.app.ParamsHelper;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginHelper {

    private String fydm;
    private String loginName;
    private String pwd;
    private Callback callback;

    public LoginHelper(String fydm, String loginName, String pwd, Callback callback) {
        this.fydm = fydm;
        this.loginName = loginName;
        this.pwd = pwd;
        this.callback = callback;
        AppComponentProvider.provide().inject(this);
    }

    @Inject
    ParamsHelper paramsHelper;

    private Params createParams() {
        Params params = new Params();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fydm", fydm);
        parameters.put("loginname", loginName);
        parameters.put("password", pwd);
        paramsHelper.initParams(params, "login", parameters);
        return params;
    }

    @Inject
    LoginService loginService;

    public void login() {
        Params loginParams = createParams();
        loginService.login(loginParams.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> callback.onSuccess(response));
    }

}
