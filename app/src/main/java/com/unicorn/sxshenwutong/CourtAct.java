package com.unicorn.sxshenwutong;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.logger.Logger;
import com.unicorn.sxshenwutong.base.BaseAct;
import com.unicorn.sxshenwutong.court.Court;
import com.unicorn.sxshenwutong.court.CourtAdapter;
import com.unicorn.sxshenwutong.court.data.CourtService;
import com.unicorn.sxshenwutong.dagger.AppComponentProvider;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.blankj.utilcode.util.Utils.getContext;

public class CourtAct extends BaseAct {

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected int layoutResId() {
        return R.layout.act_court;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initRv();
    }


    // ===================== initRv =====================

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private CourtAdapter courtAdapter= new CourtAdapter();

    private void initRv() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(courtAdapter);
        addItemDecoration();

        getCourt();
    }

    private void addItemDecoration() {
        HorizontalDividerItemDecoration itemDecoration = new HorizontalDividerItemDecoration.Builder(this)
                .colorResId(R.color.md_grey_300).size(1)
                .build();
        recyclerView.addItemDecoration(itemDecoration);
    }


    // ===================== getCourt =====================

    @Inject
    ParamsHelper paramsHelper;

    @Inject
    CourtService courtService;

    private void getCourt() {
        Params params = new Params();
        paramsHelper.initParams(params, "getFyList", new HashMap<String, Object>());
        courtService.getCourt(params.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.d("");
                    }

                    @Override
                    public void onNext(Response o) {
                        CourtAct.this.copeResponse(o);
                    }
                });
    }


    private void copeResponse(Response response) {
        if(response.getCode().equals("000000")){
            LinkedTreeMap<String,String> parameters = (LinkedTreeMap<String,String>)response.getParameters();
          String ydbaKey =parameters.get("ydbaKey");
            try {
                JSONObject jsonObject = new JSONObject(ydbaKey);
             String str = jsonObject.getJSONArray("fylist").toString();
                List<Court> courts =     new Gson().fromJson(str,
                        new TypeToken<List<Court>>() {
                        }.getType());
                courtAdapter.setNewData(courts);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }


}
