package com.unicorn.sxshenwutong.d.spdb.list.ajsqsp;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.reflect.TypeToken;
import com.unicorn.sxshenwutong.a.base.ListAct;
import com.unicorn.sxshenwutong.a.base.ListResponse;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.d.spdb.list.ajsqsp.entity.Ajsqsp;

import java.util.HashMap;


public class AjspsqListAct extends ListAct<Ajsqsp> {

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
    protected BaseQuickAdapter<Ajsqsp, BaseViewHolder> getAdapter() {
        return new AjsqspListAdapter();
    }

    @Override
    protected ListResponse<Ajsqsp> gson(String ydbaKey) {
        return gson.fromJson(ydbaKey, new TypeToken<ListResponse<Ajsqsp>>() {
        }.getType());
    }
}
