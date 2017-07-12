package com.unicorn.sxshenwutong.list;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.logger.Logger;
import com.unicorn.sxshenwutong.a.base.ListAct;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;

import javax.inject.Inject;

public class ListAct2 extends ListAct<Model> {

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected BaseQuickAdapter<Model, BaseViewHolder> getAdapter() {
        return new ListAdapter();
    }

    @Inject
    Gson gson;

    @Override
    protected ListResponse<Model> gson(String ydbaKey) {
        Logger.d("result",ydbaKey);
        return gson.fromJson(ydbaKey, new TypeToken<ListResponse<Model>>() {
        }.getType());
    }

}
