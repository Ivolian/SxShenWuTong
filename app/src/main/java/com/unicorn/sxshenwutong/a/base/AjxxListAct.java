package com.unicorn.sxshenwutong.a.base;

import com.google.gson.reflect.TypeToken;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;

abstract public class AjxxListAct extends ListAct<Ajxx> {

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected ListResponse<Ajxx> gson(String ydbaKey) {
        return gson.fromJson(ydbaKey, new TypeToken<ListResponse<Ajxx>>() {
        }.getType());
    }

}
