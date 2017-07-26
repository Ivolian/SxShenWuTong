package com.unicorn.sxshenwutong.a.network.base;

import com.google.gson.Gson;
import com.unicorn.sxshenwutong.a.network.GeneralService;
import com.unicorn.sxshenwutong.a.network.ParamsInitializer;
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
        String params = params().toString();
        return generalService.get(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(response -> response.getCode().equals(SUCCESS_CODE))
                .map(this::map);
    }

    @Inject
    ParamsInitializer paramsInitializer;

    private Params params() {
        Params params = new Params();
        paramsInitializer.initParams(params, busiCode(), parameters());
        return params;
    }

    // 默认空入参，添加入参需要重载此方法
    protected HashMap<String, Object> parameters() {
        return new HashMap<>();
    }

    // 因为泛型，无法依赖注入，由子类实现
    abstract protected void inject();

    // 业务编码
    abstract protected String busiCode();

    @Inject
    protected Gson gson;

    // 因为泛型，无法解析返回值，由子类实现
    abstract protected T map(Response response);

}
