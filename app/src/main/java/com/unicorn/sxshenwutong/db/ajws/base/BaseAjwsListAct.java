package com.unicorn.sxshenwutong.db.ajws.base;

import com.google.gson.reflect.TypeToken;
import com.unicorn.sxshenwutong.a.base.ListAct;
import com.unicorn.sxshenwutong.a.base.ListResponse;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.db.ajws.ajws.entity.Ajws;

import java.util.HashMap;

public abstract class BaseAjwsListAct extends ListAct<Ajws> {

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected ListResponse<Ajws> gson(String ydbaKey) {
        return gson.fromJson(ydbaKey, new TypeToken<ListResponse<Ajws>>() {
        }.getType());
    }

    @Override
    protected HashMap<String, Object> parameters() {
        HashMap<String, Object> map = super.parameters();
        map.put(Key.AJBS, getIntent().getStringExtra(Key.AJBS));
        return map;
    }

}
