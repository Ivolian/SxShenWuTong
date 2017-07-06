package com.unicorn.sxshenwutong;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.unicorn.sxshenwutong.A.app.ParamsInitializer;
import com.unicorn.sxshenwutong.A.base.RefreshAct;
import com.unicorn.sxshenwutong.A.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.A.app.entity.Params;
import com.unicorn.sxshenwutong.A.app.entity.Response;
import com.unicorn.sxshenwutong.list.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;

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
        return new ModelAdapter();
    }

    @Override
    protected Observable<Object> load() {
        s();
        return Observable.just(new Object());
    }

    @Inject
    ParamsInitializer paramsInitializer;

    private void s() {
        Params params = new Params();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("page", pageNo);
        parameters.put("pageSize", PAGE_SIZE);
        parameters.put("lbtype", "zxdblist");
        paramsInitializer.initParams(params, "getLbList", parameters);

//        Retrofit retrofit = new RetrofitProvider().provide();
//        LoginService loginService = retrofit.create(LoginService.class);
//        loginService
//                .get(params.toString())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Response>() {
//                    @Override
//                    public void onCompleted() {
//                        Logger.d("");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Logger.d("");
//                    }
//
//                    @Override
//                    public void onNext(Response o) {
//                        onSuccess(o);
//                    }
//                });
    }

    private void copeResponse(Response response) {
        if (response.getCode().equals("000000")) {
            LinkedTreeMap<String, String> parameters = (LinkedTreeMap<String, String>) response.getParameters();
            String ydbaKey = parameters.get("ydbaKey");
            try {
                JSONObject jsonObject = new JSONObject(ydbaKey);
                Integer total = jsonObject.getInt("total");
                JSONArray rows = jsonObject.getJSONArray("rows");
                List<Model> models = new Gson().fromJson(rows.toString(),
                        new TypeToken<List<Model>>() {
                        }.getType());
        adapter.setNewData(models);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }


}
