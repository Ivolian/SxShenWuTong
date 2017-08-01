package com.unicorn.sxshenwutong.e.lawys;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.spdb.Ajxx;
import com.unicorn.sxshenwutong.e.base.AjxxListAct;


public class LawysListAct extends AjxxListAct {

    @Override
    protected BaseQuickAdapter<Ajxx, BaseViewHolder> getAdapter() {
        return new LawysAdapter();
    }

}
