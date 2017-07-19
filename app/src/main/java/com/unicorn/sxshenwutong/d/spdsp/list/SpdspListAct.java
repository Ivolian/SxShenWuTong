package com.unicorn.sxshenwutong.d.spdsp.list;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.reflect.TypeToken;
import com.unicorn.sxshenwutong.a.base.ListAct;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.base.ListResponse;

public class SpdspListAct extends ListAct<SimpleSpdsp> {

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected BaseQuickAdapter<SimpleSpdsp, BaseViewHolder> getAdapter() {
        return new SpdspAdapter();
    }

    @Override
    protected ListResponse<SimpleSpdsp> gson(String ydbaKey) {
        return gson.fromJson(ydbaKey, new TypeToken<ListResponse<SimpleSpdsp>>() {
        }.getType());
    }
}
