package com.unicorn.sxshenwutong.base;

import com.unicorn.sxshenwutong.app.Callback;
import com.unicorn.sxshenwutong.app.GeneralService;
import com.unicorn.sxshenwutong.app.Params;
import com.unicorn.sxshenwutong.app.ParamsInitializer;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public abstract class BaseFetcher {

    abstract public void inject();

    private Callback callback;

    public BaseFetcher(Callback callback) {
        inject();
        this.callback = callback;
    }

    @Inject
    ParamsInitializer paramsInitializer;

    protected abstract String busiCode();

    protected Map<String,Object> parameters(){
        Map<String, Object> parameters = new HashMap<>();
    return  parameters;
    }

    private Params createParams() {
        Params params = new Params();
        paramsInitializer.initParams(params, busiCode(), parameters());
        return params;
    }

    @Inject
    GeneralService generalService;

    public void start() {
        Params params = createParams();
        generalService.get(params.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> callback.onSuccess(response));
    }

}
