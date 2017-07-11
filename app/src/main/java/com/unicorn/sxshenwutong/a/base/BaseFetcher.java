package com.unicorn.sxshenwutong.a.base;

import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.app.GeneralService;
import com.unicorn.sxshenwutong.a.app.ParamsInitializer;
import com.unicorn.sxshenwutong.a.app.entity.Params;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.unicorn.sxshenwutong.a.constant.Key.SUCCESS_CODE;
import static com.unicorn.sxshenwutong.a.constant.Key.YDBAKEY;

public abstract class BaseFetcher {

    abstract public void inject();

    protected abstract String busiCode();

    private Callback callback;

    public BaseFetcher(Callback callback) {
        inject();
        this.callback = callback;
    }

    @Inject
    ParamsInitializer paramsInitializer;

    protected Map<String, Object> parameters() {
        return new HashMap<>();
    }

    private String params() {
        Params params = new Params();
        paramsInitializer.initParams(params, busiCode(), parameters());
        return params.toString();
    }

    @Inject
    GeneralService generalService;

    public void start() {
        generalService.get(params())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(response -> response.getCode().equals(SUCCESS_CODE))
                .map(response -> response.getParameters().get(YDBAKEY))
                .subscribe(ydbaKey -> callback.onSuccess(ydbaKey));
    }

}
