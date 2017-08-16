package com.unicorn.sxshenwutong.db2.ajspSq;

import android.content.Intent;
import android.os.Bundle;

import com.afollestad.materialdialogs.MaterialDialog;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.reflect.TypeToken;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.unicorn.sxshenwutong.a.base.ListAct;
import com.unicorn.sxshenwutong.a.base.ListResponse;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.db2.ajspSq.entity.Ajsp;
import com.unicorn.sxshenwutong.db2.sxbgSq.FdsySqAct;
import com.unicorn.sxshenwutong.db2.sycxbgSq.SycxbgSqAct;
import com.unicorn.sxshenwutong.db2.wssp.WsspSqAct;

import java.util.Arrays;
import java.util.HashMap;


public class AjspSqListAct extends ListAct<Ajsp> {

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
    protected BaseQuickAdapter<Ajsp, BaseViewHolder> getAdapter() {
        return new AjspSqListAdapter();
    }

    @Override
    protected ListResponse<Ajsp> gson(String ydbaKey) {
        return gson.fromJson(ydbaKey, new TypeToken<ListResponse<Ajsp>>() {
        }.getType());
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        setOperation("创建", aVoid -> showDialog());
    }

    private void showDialog() {
        new MaterialDialog.Builder(this)
                .title("选择案件审批申请类型")
                .items(Arrays.asList("适用程序变更", "法定事由", "文书审批"))
                .itemsCallback((dialog, itemView, position, text) -> startSqAct(position))
                .show();
    }

    private void startSqAct(int position) {
        Class actClass;
        switch (position) {
            case 0:
                actClass = SycxbgSqAct.class;
                break;
            case 1:
                actClass = FdsySqAct.class;
                break;
            default:
                actClass = WsspSqAct.class;
        }
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
