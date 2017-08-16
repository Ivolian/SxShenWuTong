package com.unicorn.sxshenwutong.db2.ajspSq;

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
import com.unicorn.sxshenwutong.db2.ajspSq.entity.Ajsp;
import com.unicorn.sxshenwutong.db2.sxbgSq.SxbgSqAct;
import com.unicorn.sxshenwutong.db2.sycxbgSq.SycxbgSqAct;
import com.unicorn.sxshenwutong.db2.wssp.WsspSqAct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;


public class AjspsqListAct extends ListAct<Ajsp> {

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
        return new AjsqspListAdapter();
    }

    @Override
    protected ListResponse<Ajsp> gson(String ydbaKey) {
        return gson.fromJson(ydbaKey, new TypeToken<ListResponse<Ajsp>>() {
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
                .items(Arrays.asList("适用程序变更", "法定事由", "文书审批"))
                .itemsCallback((dialog, itemView, position, text) -> s(position))
                .show();
    }

    private void s(int position) {
        Class actClass;
        switch (position) {
            case 0:
                actClass = SycxbgSqAct.class;
                break;
            case 1:
                actClass = SxbgSqAct.class;
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
