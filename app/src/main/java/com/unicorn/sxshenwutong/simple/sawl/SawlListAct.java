package com.unicorn.sxshenwutong.simple.sawl;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.db.db.entity.Ajxx;
import com.unicorn.sxshenwutong.a.base.AjxxListAct;


public class SawlListAct extends AjxxListAct {

    @Override
    protected BaseQuickAdapter<Ajxx, BaseViewHolder> getAdapter() {
        return new SawlAdapter();
    }

}
