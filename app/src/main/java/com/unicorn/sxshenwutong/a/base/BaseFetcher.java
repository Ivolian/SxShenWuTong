package com.unicorn.sxshenwutong.a.base;

import com.google.gson.internal.LinkedTreeMap;
import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.app.GeneralService;
import com.unicorn.sxshenwutong.a.app.ParamsInitializer;
import com.unicorn.sxshenwutong.a.app.entity.Params;
import com.unicorn.sxshenwutong.a.app.entity.Response;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.unicorn.sxshenwutong.a.constant.Key.SUCCESS_CODE;

public abstract class BaseFetcher<T> {

    abstract public void inject();

    protected abstract String busiCode();

    private Callback<T> callback;

    public BaseFetcher(Callback<T> callback) {
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
                .filter(new Func1<Response<LinkedTreeMap<String, String>>, Boolean>() {
                    @Override
                    public Boolean call(Response<LinkedTreeMap<String, String>> response) {
                        return response.getCode().equals(SUCCESS_CODE);
                    }
                })
                .map(new Func1<Response<LinkedTreeMap<String, String>>, T>() {
                    @Override
                    public T call(Response<LinkedTreeMap<String, String>> response) {
                        return map(response);
                    }
                })
                .subscribe(t -> callback.onSuccess(t));
    }

    abstract protected T map(Response<LinkedTreeMap<String, String>> response);

}
