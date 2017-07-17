package com.unicorn.sxshenwutong.c.spdsp;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.reflect.TypeToken;
import com.unicorn.sxshenwutong.a.base.ListAct;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.base.ListResponse;

public class SpdspAct extends ListAct<Spdsp> {
    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected BaseQuickAdapter<Spdsp, BaseViewHolder> getAdapter() {
        return new SpdspAdapter();
    }

    @Override
    protected ListResponse<Spdsp> gson(String ydbaKey) {
        return gson.fromJson(ydbaKey, new TypeToken<ListResponse<Spdsp>>() {
        }.getType());
    }
}
