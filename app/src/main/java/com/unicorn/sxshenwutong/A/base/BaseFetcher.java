package com.unicorn.sxshenwutong.A.base;

import com.unicorn.sxshenwutong.A.app.Callback;
import com.unicorn.sxshenwutong.A.app.GeneralService;
import com.unicorn.sxshenwutong.A.app.entity.Params;
import com.unicorn.sxshenwutong.A.app.ParamsInitializer;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.unicorn.sxshenwutong.A.constant.Key.SUCCESS_CODE;
import static com.unicorn.sxshenwutong.A.constant.Key.YDBAKEY;

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

    protected Map<String, Object> parameters() {
        Map<String, Object> parameters = new HashMap<>();
        return parameters;
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
                .filter(response -> response.getCode().equals(SUCCESS_CODE))
                .map(response -> response.getParameters().get(YDBAKEY))
                .subscribe(ydbaKey -> callback.onSuccess(ydbaKey));
    }

}
