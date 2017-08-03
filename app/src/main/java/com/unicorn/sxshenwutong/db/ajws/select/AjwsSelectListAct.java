package com.unicorn.sxshenwutong.db.ajws.select;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.reflect.TypeToken;
import com.hwangjr.rxbus.RxBus;
import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.ListAct;
import com.unicorn.sxshenwutong.a.base.ListResponse;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.db.ajws.ajws.entity.Ajws;
import com.unicorn.sxshenwutong.db.ajws.select.entity.AjwsWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;


public class AjwsSelectListAct extends ListAct<AjwsWrapper> {

    @Override
    protected HashMap<String, Object> parameters() {
        HashMap<String, Object> map = super.parameters();
        map.put(Key.AJBS, getIntent().getStringExtra(Key.AJBS));
        return map;
    }

    @BindView(R.id.tvOperation)
    TextView tvOperation;

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);

        tvOperation.setVisibility(View.VISIBLE);
        tvOperation.setText("确定");
        RxView.clicks(tvOperation)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> post());
    }

    private void post(){
        List<AjwsWrapper> wrappers = ajwsSelectAdapter.getData();
        ArrayList<Ajws> ajwsList = new ArrayList<>();
        for (AjwsWrapper wrapper:wrappers){
            if (wrapper.isChecked()) {
                ajwsList.add(wrapper.getAjws());
            }
        }
        if (ajwsList.size()==0){
            ToastUtils.showShort("至少选择一项案件文书");
            return;
        }

        RxBus.get().post(RxBusTag.SELECT_AJWS,ajwsList);
        finish();
    }

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }


    AjwsSelectAdapter ajwsSelectAdapter;

    @Override
    protected BaseQuickAdapter<AjwsWrapper, BaseViewHolder> getAdapter() {
        return ajwsSelectAdapter =new AjwsSelectAdapter();
    }

    @Override
    protected ListResponse<AjwsWrapper> gson(String ydbaKey) {
        ListResponse<Ajws> ajwsListResponse = gson.fromJson(ydbaKey, new TypeToken<ListResponse<Ajws>>() {
        }.getType());
        List<AjwsWrapper> wrappers = new ArrayList<>();
        for (Ajws ajws : ajwsListResponse.getRows()) {
            wrappers.add(new AjwsWrapper(ajws, false));
        }
        ListResponse<AjwsWrapper> wrapperListResponse = new ListResponse<>();
        wrapperListResponse.setTotal(ajwsListResponse.getTotal());
        wrapperListResponse.setRows(wrappers);
        return wrapperListResponse;
    }


}
