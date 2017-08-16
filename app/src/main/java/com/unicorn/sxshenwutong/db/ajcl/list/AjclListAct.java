package com.unicorn.sxshenwutong.db.ajcl.list;

import android.content.Intent;
import android.os.Bundle;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.reflect.TypeToken;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.ListAct;
import com.unicorn.sxshenwutong.a.base.ListResponse;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.db.ajcl.ajcl.AjclAudioAct;
import com.unicorn.sxshenwutong.db.ajcl.ajcl.AjclPhotoAct;
import com.unicorn.sxshenwutong.db.ajcl.ajcl.AjclVideoAct;
import com.unicorn.sxshenwutong.db.ajcl.list.entity.Ajcl;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class AjclListAct extends ListAct<Ajcl> {

    @Override
    protected int layoutResId() {
        return R.layout.act_ajcl_list;
    }

    @Override
    protected HashMap<String, Object> parameters() {
        HashMap<String, Object> map = super.parameters();
        map.put(Key.AJBS, getIntent().getStringExtra(Key.AJBS));
        return map;
    }

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected BaseQuickAdapter<Ajcl, BaseViewHolder> getAdapter() {
        return new AjclListAdapter();
    }

    @Override
    protected ListResponse<Ajcl> gson(String ydbaKey) {
        return gson.fromJson(ydbaKey, new TypeToken<ListResponse<Ajcl>>() {
        }.getType());
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        clicks();
    }

    private void clicks() {
        RxView.clicks(findViewById(R.id.ivVideo)).throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(aVoid -> startAjclAct(AjclVideoAct.class));
        RxView.clicks(findViewById(R.id.ivPhoto)).throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(aVoid -> startAjclAct(AjclPhotoAct.class));
        RxView.clicks(findViewById(R.id.ivAudio)).throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(aVoid -> startAjclAct(AjclAudioAct.class));
    }

    private void startAjclAct(Class actClass) {
        Intent intent = new Intent(this, actClass);
        intent.putExtra(Key.AJBS, getIntent().getStringExtra(Key.AJBS));
        startActivity(intent);
    }

    @Override
    protected boolean useRxBus() {
        return true;
    }

    @Subscribe(tags = {@Tag(RxBusTag.SUBMIT_SUCCESS)})
    public void onSubmitSuccess(Object o) {
        swipeRefreshLayout.setRefreshing(true);
        loadFirst();
    }

}
