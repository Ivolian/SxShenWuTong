package com.unicorn.sxshenwutong.a.base;

import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.network.GeneralService;
import com.unicorn.sxshenwutong.a.network.ParamsInitializer;
import com.unicorn.sxshenwutong.a.network.entity.Params;
import com.unicorn.sxshenwutong.a.network.entity.Response;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import pocketknife.BindExtra;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.unicorn.sxshenwutong.a.constant.Key.SUCCESS_CODE;
import static com.unicorn.sxshenwutong.a.constant.Key.YDBAKEY;


abstract public class ListFra<T> extends RefreshFra<T> {

    @Override
    protected int layoutResId() {
        return R.layout.act_list;
    }

    @Override
    protected void init(View rootView) {
        super.init(rootView);
//        clickBack();

    }


    // ===================== setTitle =====================


    @BindView(R.id.tvTitle)
    TextView tvTitle;

    protected void setTitle(String title) {
        tvTitle.setText(title);
    }


    // ===================== params =====================

    @BindExtra(Key.LBTYPE)
    String lbtype;

    @Inject
    ParamsInitializer paramsInitializer;

    private String params() {
        Params params = new Params();
        paramsInitializer.initParams(params, "getLbList", parameters());
        return params.toString();
    }

    protected HashMap<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("page", pageNo);
        parameters.put("pageSize", PAGE_SIZE);
        parameters.put(Key.LBTYPE, lbtype);
        return parameters;
    }


    // ===================== load =====================

    @Inject
    GeneralService generalService;

    @Override
    protected Observable<ListResponse<T>> load() {
        return generalService.get(params())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Func1<Response, Boolean>() {
                    @Override
                    public Boolean call(Response response) {
                        return response.getCode().equals(SUCCESS_CODE);
                    }
                })
                .map(new Func1<Response, String>() {
                    @Override
                    public String call(Response response) {
                        return response.getParameters().get(YDBAKEY);
                    }
                })
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {

                        return s != null;
                    }
                })
                .map(this::gson);
    }


    @Inject
    protected Gson gson;

    abstract protected ListResponse<T> gson(String ydbaKey);

    @BindView(R.id.tvOperation)
    protected TextView tvOperation;

    protected void setOperation(String operationLabel, Action1<Void> action1) {
        tvOperation.setVisibility(View.VISIBLE);
        tvOperation.setText(operationLabel);
        RxView.clicks(tvOperation)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(action1);
    }

}
