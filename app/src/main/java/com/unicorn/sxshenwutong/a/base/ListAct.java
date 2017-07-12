package com.unicorn.sxshenwutong.a.base;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.internal.LinkedTreeMap;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.GeneralService;
import com.unicorn.sxshenwutong.a.app.ParamsInitializer;
import com.unicorn.sxshenwutong.a.app.entity.Params;
import com.unicorn.sxshenwutong.a.app.entity.Response;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.list.ListResponse;

import java.util.HashMap;

import javax.inject.Inject;

import butterknife.BindView;
import pocketknife.BindExtra;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.unicorn.sxshenwutong.a.constant.Key.SUCCESS_CODE;
import static com.unicorn.sxshenwutong.a.constant.Key.YDBAKEY;


abstract public class ListAct<T> extends RefreshAct<T> {

    @Override
    protected int layoutResId() {
        return R.layout.act_list;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        clickBack();
        setTitle();
    }


    // ===================== setTitle =====================

    @BindExtra(Key.TITLE)
    String title;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    private void setTitle() {
        tvTitle.setText(title);
    }


    // ===================== params =====================

    @BindExtra(Key.LBTYPE)
    String lbtype;

    @Inject
    ParamsInitializer paramsInitializer;

    private String params() {
        Params params = new Params();
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("page", pageNo);
        parameters.put("pageSize", PAGE_SIZE);
        parameters.put(Key.LBTYPE, lbtype);
        paramsInitializer.initParams(params, "getLbList", parameters);
        return params.toString();
    }


    // ===================== load =====================

    @Inject
    GeneralService generalService;

    @Override
    protected Observable<ListResponse<T>> load() {
        return generalService.get(params())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(response -> response.getCode().equals(SUCCESS_CODE))
                .map(new Func1<Response<LinkedTreeMap<String, String>>, String>() {
                    @Override
                    public String call(Response<LinkedTreeMap<String, String>> response) {
                                            return response.getParameters().get(YDBAKEY);
                    }
                })
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return s!=null;
                    }
                })
                .map(this::gson);
    }

    abstract protected ListResponse<T> gson(String ydbaKey);

}
