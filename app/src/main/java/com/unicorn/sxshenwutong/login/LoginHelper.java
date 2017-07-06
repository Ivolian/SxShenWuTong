package com.unicorn.sxshenwutong.login;

import com.unicorn.sxshenwutong.app.Callback;
import com.unicorn.sxshenwutong.app.GeneralService;
import com.unicorn.sxshenwutong.app.ParamsInitializer;
import com.unicorn.sxshenwutong.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.app.Params;

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
    ParamsInitializer paramsInitializer;

    private Params createParams() {
        Params params = new Params();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fydm", fydm);
        parameters.put("loginname", loginName);
        parameters.put("password", pwd);
        paramsInitializer.initParams(params, "start", parameters);
        return params;
    }

    @Inject
    GeneralService generalService;

    public void login() {
        Params params = createParams();
        generalService.get(params.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> callback.onSuccess(response));
    }

}
