package com.unicorn.sxshenwutong.d.ajcl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
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
import com.unicorn.sxshenwutong.d.ajcl.entity.Ajcl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;


public class AjclListAct extends ListAct<Ajcl> {

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


    @BindView(R.id.tvOperation)
    TextView tvOperation;

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        tvOperation.setVisibility(View.VISIBLE);
        tvOperation.setText("创建");
        RxView.clicks(tvOperation)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> showDialog());
    }

    private void showDialog() {
        new MaterialDialog.Builder(this)
                .title("选择案件审批申请类型")
                .items(Arrays.asList("照片", "录像"))
                .itemsCallback((dialog, itemView, position, text) -> s(position))
                .show();
    }

    private void s(int position) {
        Intent intent = new Intent(this, AjclVideoAct.class);
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
