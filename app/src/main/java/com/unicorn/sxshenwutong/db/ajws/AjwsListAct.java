package com.unicorn.sxshenwutong.db.ajws;

import android.os.Bundle;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.reflect.TypeToken;
import com.unicorn.sxshenwutong.a.base.ListAct;
import com.unicorn.sxshenwutong.a.base.ListResponse;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.db.ajws.entity.Ajws;

import java.util.HashMap;


public class AjwsListAct extends ListAct<Ajws> {

    @Override
    protected HashMap<String, Object> parameters() {
        HashMap<String, Object> map = super.parameters();
        map.put(Key.AJBS, getIntent().getStringExtra(Key.AJBS));
        return map;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);



    }

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    AjwsAdapter ajwsAdapter;

    @Override
    protected BaseQuickAdapter<Ajws, BaseViewHolder> getAdapter() {
        return ajwsAdapter = new AjwsAdapter(this);
    }

    @Override
    protected ListResponse<Ajws> gson(String ydbaKey) {
        return gson.fromJson(ydbaKey, new TypeToken<ListResponse<Ajws>>() {
        }.getType());
    }


}
