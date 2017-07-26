package com.unicorn.sxshenwutong.d.jasc;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.reflect.TypeToken;
import com.unicorn.sxshenwutong.a.base.ListAct;
import com.unicorn.sxshenwutong.a.base.ListResponse;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;

// 审判结案审查 & 执行结案审查
public class JascListAct extends ListAct<Ajxx>{

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected BaseQuickAdapter<Ajxx, BaseViewHolder> getAdapter() {
        return new JascAdapter();
    }

    @Override
    protected ListResponse<Ajxx> gson(String ydbaKey) {
        return gson.fromJson(ydbaKey, new TypeToken<ListResponse<Ajxx>>() {
        }.getType());
    }

}
