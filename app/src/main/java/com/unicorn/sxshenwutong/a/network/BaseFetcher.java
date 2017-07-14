package com.unicorn.sxshenwutong.a.network;

import com.google.gson.internal.LinkedTreeMap;
import com.unicorn.sxshenwutong.a.network.entity.Params;
import com.unicorn.sxshenwutong.a.network.entity.Response;

import java.util.HashMap;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.unicorn.sxshenwutong.a.constant.Key.SUCCESS_CODE;

public abstract class BaseFetcher<T> {

    abstract public void inject();

    protected abstract String busiCode();

    public BaseFetcher() {
        inject();
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

    @Inject
    GeneralService generalService;

    public Observable<T> start() {
        String params = params();
         return   generalService.get(params)
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
                    });


    }

    abstract protected T map(Response<LinkedTreeMap<String, String>> response);

}
