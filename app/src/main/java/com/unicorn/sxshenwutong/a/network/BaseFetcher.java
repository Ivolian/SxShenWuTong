package com.unicorn.sxshenwutong.a.network;

import com.unicorn.sxshenwutong.a.network.entity.Params;
import com.unicorn.sxshenwutong.a.network.entity.Response;

import java.util.HashMap;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.unicorn.sxshenwutong.a.constant.Key.SUCCESS_CODE;

public abstract class BaseFetcher<T> {

    public BaseFetcher() {
        inject();
    }

    @Inject
    GeneralService generalService;

    public Observable<T> start() {
        String params = params();
        return generalService.get(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(response -> response.getCode().equals(SUCCESS_CODE))
                .map(this::map);
    }

    @Inject
    ParamsInitializer paramsInitializer;

    protected HashMap<String, Object> parameters() {
        return new HashMap<>();
    }

    private String params() {
        Params params = new Params();
        paramsInitializer.initParams(params, busiCode(), parameters());
        return params.toString();
    }

    abstract public void inject();

    protected abstract String busiCode();

    abstract protected T map(Response response);

}
