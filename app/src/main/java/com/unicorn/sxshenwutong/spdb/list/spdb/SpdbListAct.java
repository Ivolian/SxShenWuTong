package com.unicorn.sxshenwutong.spdb.list.spdb;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.logger.Logger;
import com.unicorn.sxshenwutong.a.base.ListAct;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.base.ListResponse;
import com.unicorn.sxshenwutong.spdb.Ajxx;

public class SpdbListAct extends ListAct<Ajxx> {

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected BaseQuickAdapter<Ajxx, BaseViewHolder> getAdapter() {
        return new SpdbAdapter();
    }

    @Override
    protected ListResponse<Ajxx> gson(String ydbaKey) {
        Logger.e(ydbaKey);
        return gson.fromJson(ydbaKey, new TypeToken<ListResponse<Ajxx>>() {
        }.getType());
    }

}
