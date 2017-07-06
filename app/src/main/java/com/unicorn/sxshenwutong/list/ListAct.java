package com.unicorn.sxshenwutong.list;

import android.os.Bundle;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.GeneralService;
import com.unicorn.sxshenwutong.a.app.ParamsInitializer;
import com.unicorn.sxshenwutong.a.app.entity.Params;
import com.unicorn.sxshenwutong.a.base.RefreshAct;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import pocketknife.BindExtra;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.unicorn.sxshenwutong.a.constant.Key.SUCCESS_CODE;
import static com.unicorn.sxshenwutong.a.constant.Key.YDBAKEY;


public class ListAct extends RefreshAct<Model> {

    @Override
    protected int layoutResId() {
        return R.layout.act_list;
    }

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected BaseQuickAdapter<Model, BaseViewHolder> getAdapter() {
        return new ListAdapter();
    }

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        clickBack();
        tvTitle.setText(title);
    }

    @BindExtra(Key.TITLE)
    String title;

    @Override
    protected Observable<ListResponse<Model>> load() {
        Params params = new Params();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("page", pageNo);
        parameters.put("pageSize", PAGE_SIZE);
        parameters.put("lbtype", "zxdblist");
        paramsInitializer.initParams(params, "getLbList", parameters);


        return generalService.get(params.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(response -> response.getCode().equals(SUCCESS_CODE))
                .map(response -> response.getParameters().get(YDBAKEY))
                .map(ydbaKey -> {


                        ListResponse<Model> listResponse = new Gson().fromJson(ydbaKey,
                                new TypeToken<ListResponse<Model>>() {
                                }.getType());


                    return listResponse;
                });
    }

    @Inject
    ParamsInitializer paramsInitializer;

    @Inject
    GeneralService generalService;



}
