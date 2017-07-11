package com.unicorn.sxshenwutong.list;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;

public class ListAct2 extends ListAct<Model> {

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected BaseQuickAdapter<Model, BaseViewHolder> getAdapter() {
        return new ListAdapter();
    }

    @Override
    protected ListResponse<Model> gson(String ydbaKey) {
                  ListResponse<Model> listResponse = new Gson().fromJson(ydbaKey,
                new TypeToken<ListResponse<Model>>() {
                }.getType());
        return listResponse;
    }
}
