package com.unicorn.sxshenwutong.e.zxsawl;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;
import com.unicorn.sxshenwutong.e.base.AjxxListAct;


public class ZxsawlListAct extends AjxxListAct {

    @Override
    protected BaseQuickAdapter<Ajxx, BaseViewHolder> getAdapter() {
        return new ZxsawlAdapter();
    }


}
