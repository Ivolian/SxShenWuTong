package com.unicorn.sxshenwutong.code;

import com.unicorn.sxshenwutong.app.Callback;
import com.unicorn.sxshenwutong.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.app.Params;
import com.unicorn.sxshenwutong.app.ParamsHelper;
import com.unicorn.sxshenwutong.login.LoginService;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class CodeHelper {

    private String bxh;
    private Callback callback;

    public CodeHelper(String bxh, Callback callback) {
        this.bxh = bxh;
        this.callback = callback;
        AppComponentProvider.provide().inject(this);
    }

    @Inject
    ParamsHelper paramsHelper;

    private Params createParams() {
        Params params = new Params();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("bxh", bxh);
        paramsHelper.initParams(params, "getBm", parameters);
        return params;
    }

    @Inject
    LoginService loginService;

    public void getCode() {
        Params params = createParams();
        loginService.login(params.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> callback.onSuccess(response));
    }

}
